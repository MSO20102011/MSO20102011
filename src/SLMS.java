/* We changed the name from System to SLMS, because System
 * is already imported by default in java. */

import utils.*;
import java.util.Hashtable;

public class SLMS {

    // We use a hashtable to make lookups on e-mail addresses faster.
    public Hashtable<String, User> registeredUsers; 
    public Hashtable<String, Administrator> admins;
    public Hashtable<String, Class> classes;

    /* Implementing the singleton */
    private static SLMS instance = null;
    protected SLMS () {} 
    public static SLMS getInstance() {
        if (instance == null) instance = new SLMS(); 
        return instance;
    }

    /* Reset the system state. */
    public void resetState() {
        registeredUsers = new Hashtable<String, User> ();
        admins          = new Hashtable<String, Administrator> ();
        classes         = new Hashtable<String, Class>();
    }

    /* Add a new class by its name. */
    public void addClass(String name) {
        classes.put(name, new Class(name));
    }

    /* Gets a class by its name. */
    public Class getClass(String className) {
        Class c = classes.get(className);
        if (c == null) throw new IllegalArgumentException();
        return c;
    }

    /* Adds a new user to the system. */
    public User newUser(String name, String email, String pwd) {
        User u = new User(name, email, pwd);
        registeredUsers.put(email, u);
        return u;
    }

    /* Adds a new parent to the system. */
    public void addParent(String name, String email, String pwd) {
        User u = newUser(name, email, pwd);
        registeredUsers.put(email, new Parent(u));
    }

    /* Adds a new teacher to the system. */
    public void addTeacher(String name, String email, String pwd) {
        User u = newUser(name, email, pwd);
        registeredUsers.put(email, new Teacher(u));
    }

    /* Get an user by its e-mail address. */
    public User getUser(String email) {
        return registeredUsers.get(email);
    }

    /* Get an administrator by its e-mail address. */
    public Administrator getAdmin(String admin) {
        return admins.get(admin);
    }

    /* Walk the decoratedUser attribute to find the Teacher object. */
    public Teacher getTeacher(User u) {
        if (u instanceof Teacher) 
            return (Teacher) u;
        if (u instanceof UserDecorator) 
            return getTeacher(((UserDecorator) u).decoratedUser);
        return null;
    }

    /* Get a Teacher by its e-mail address. */
    public Teacher getTeacher(String emailTeacher) {
        User u = getUser(emailTeacher);
        Teacher t = getTeacher(u);
        if (t == null) throw new IllegalArgumentException();
        return t;

    }

    /* Walk the decoratedUser attribute to find the Parent object. */
    public Parent getParent(User u) {
        if (u instanceof Parent) 
            return (Parent) u;
        if (u instanceof UserDecorator) 
            return getParent(((UserDecorator) u).decoratedUser);
        return null;

    }

    /* Get a Parent by e-mail address. */
    public Parent getParent(String emailParent) {
        User u = getUser(emailParent);
        Parent p = getParent(u);
        if (p == null) throw new IllegalArgumentException();
        return p;
    }

    /* Walk the decoratedUser attribute to find the Coordinator object. */
    public Coordinator getCoordinator(User u) {
        if (u instanceof Coordinator) 
            return (Coordinator) u;
        if (u instanceof UserDecorator) 
            return getCoordinator(((UserDecorator) u).decoratedUser);
        return null;
    }

    /* Get a Coordinator by e-mail address. */
    public Coordinator getCoordinator(String emailCoor) {
        User u = getUser(emailCoor);
        Coordinator c = getCoordinator(u);
        if (c == null) throw new IllegalArgumentException();
        return c;
    }

    /* Looks in every class to find a Child with the given name. */
    public Child getChildByName(String childName) {
        for (Class c : this.classes.values()) {
            for (Child ch : c.pupils) {
                if (ch.name.equals(childName)) {
                    return ch;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    /* Assigns a Teacher to the given Class. */
    public void assignTeacher(String emailTeacher, String className) {
        Teacher t = getTeacher(emailTeacher);
        Class   c = getClass(className);
        c.teacher = t;
        t.schoolClass = c;
    }
    
    /* Check if the teacher is really the teacher of the class. */
    public boolean isTeacherOf(String emailTeacher, String className) {
        try {
            return getTeacher(emailTeacher).schoolClass.name.equals(className); 
        }
        catch (Exception e) {
            return false;
        }
    }

    /* Adds a child to the given parent. */
    public void addChild(String emailParent, String childName) {
        Parent p = getParent(emailParent); 
        Child ch = getChildByName(childName);
        p.addChild(ch);
        ch.parent = p;
    }

    /* Adds a lunch for the child of the parent on the given day. */
    public void addLunch(String emailParent, String childName, SimpleDate date) {
        Parent p = getParent(emailParent);
        Child ch = getChildByName(childName);
        if (p.isChildOf(ch)) {
            p.addLunchDate(ch, date);
        }
    }

    /* Adds a day on which the teacher's class doesn't get to lunch. */
    public void addNoLunchDate(String emailTeacher, SimpleDate date) {
        Teacher t = getTeacher(emailTeacher);
        t.addNoLunchDate(date);
    }

    /* Adds a new pupil to the class. */
    public void addPupil(String admin, String childName, String classname) { 
        Administrator a = getAdmin(admin);
        a.addChild(getClass(classname), new Child(childName));
    }

    /* Whether or not the class has lunch on the given date. */
    public boolean hasNoLunch(String classname, SimpleDate d) {
        return getClass(classname).hasNoLunch(d);
    }

    /* Add a day on which the parent is not available to supervise a lunch group. */
    public void addUnavailableDate(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        p.addAvailability(d, false);
    }

    /* Add a day on which the parent prefers to supervise a lunch group. */
    public void addPreferDate(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        p.addAvailability(d, true);
    }

    /* Whether or not the parent is available on the given day. */
    public boolean isAvailable(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        return p.isAvailable(d);
    }

    /* Whether or not the parent is unavailable on the given day. */
    public boolean isUnavailable(String emailParent, SimpleDate d) {
        return !this.isAvailable(emailParent, d);

    }

    /* Whether or not the parent prefers the given day to supervise. */
    public boolean isPreferred(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        return p.isPreferred(d);

    }

    /* Whether or not the child is a pupil in the given class. */
    public boolean isPupilOf(String childName, String className) {
        Child ch = getChildByName(childName);
        return getClass(className).hasPupil(ch);
    }

    /* Whether or not the child is a child of the given parent. */
    public boolean isChildOf(String childName, String emailParent) {
        try {
            Child ch = getChildByName(childName);
            Parent p = getParent(emailParent);
            return p.isChildOf(ch);
        }
        catch (Exception IllegalArgumentException) {
            return false;
        }
    }

    /* Set the child up to use the pay upfront scheme. */
    public void setToPayAfrontCostScheme(String emailParent, String childName) {
        Child ch = getChildByName(childName);
        Parent p = getParent(emailParent);
        if (p.isChildOf(ch)) 
            ch.setToPayAfrontCostScheme();
    }

    /* Set the child up to use the standard cost scheme. */
    public void setToStandardCostScheme(String emailParent, String childName) {
        Child ch = getChildByName(childName);
        Parent p = getParent(emailParent);
        if (p.isChildOf(ch)) 
            ch.setToStandardCostScheme();
    }

    /* Adds a Parent role to the Teacher. */
    public void addParentRoleToTeacher(String teacherEmail) {
        Teacher t = getTeacher(teacherEmail);
        Parent p = new Parent(t);
        registeredUsers.put(teacherEmail, p);
    }

    /* Promote Parents to Coordinators. */
    public void promote(String admin, String emailParent) {
        getAdmin(admin).promote(emailParent);
    }

    /* Demote Coordinators to Parent. */
    public void demote(String admin, String coordinator) {
        getAdmin(admin).demote(coordinator);
    }


    /* Check if the given user is a coordinator. */
    public boolean isCoordinator(String emailUser) { 
        try {
            Coordinator c = getCoordinator(emailUser);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /* Calculate the cost for the child lunching in year. */
    public int calculateCost(String childName, int year) { 
        return getChildByName(childName).calculateCost(year);
    
    }

    /* Whether or not a child has lunch on the given day. */
    public boolean hasLunch(String childName, SimpleDate d) { 
        return getChildByName(childName).hasLunch(d);
    }

    /* Removes the Parent role from a Teacher. */
    public void removeParentRoleFromTeacher(String teacherEmail) {
        User u = getUser(teacherEmail);
        registeredUsers.put(teacherEmail, removeParentRole(u));
    }

    /* Helper function to remove the Parent decorator from the User. */
    private User removeParentRole(User u) {
        if (u instanceof Parent) 
            return removeParentRole(((Parent) u).decoratedUser);
        if (u instanceof UserDecorator) {
            User n = removeParentRole(((UserDecorator )u).decoratedUser);
            ((UserDecorator) u).decoratedUser = n;
        }
        return u;
    }
}
