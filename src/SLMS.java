/* We changed the name from System to SLMS, because System
 * is already imported by default in java. */

import utils.*;
import java.util.Hashtable;

public class SLMS {

    // We use a hashtable to make lookups on e-mail addresses faster.
    public Hashtable<String, User> registeredUsers; 
    public Hashtable<String, Administrator> admins; // Todo: User?
    public Hashtable<String, Class> classes;

    // Implementing the singleton
    private static SLMS instance = null;
    protected SLMS () {} 
    public static SLMS getInstance() {
        if (instance == null) {
            instance = new SLMS();
        }
        return instance;
    }

    public void resetState() {
        this.registeredUsers    = new Hashtable<String, User> ();
        this.admins   = new Hashtable<String, Administrator> ();
        this.classes  = new Hashtable<String, Class>();
    }

    public void addClass(String name) {
        classes.put(name, new Class(name));
    }

    public Class getClass(String className) {
        Class c = classes.get(className);
        if (c == null) throw new IllegalArgumentException();
        return c;
    }

    public User newUser(String name, String email, String pwd) {
        User u = new User(name, email, pwd);
        registeredUsers.put(email, u);
        return u;
    }

    public void addParent(String name, String email, String pwd) {
        User u = newUser(name, email, pwd);
        Parent p = new Parent(u);
        registeredUsers.put(email, p);
    }
    public void addTeacher(String name, String email, String pwd) {
        User u = newUser(name, email, pwd);
        Teacher t = new Teacher(u);
        registeredUsers.put(email, t);
    }

    public User getUser(String email) {
        return registeredUsers.get(email);
    }

    public Teacher getTeacher(User u) {
        if (u instanceof Teacher) {
            return (Teacher) u;
        }
        if (u instanceof UserDecorator) {
            return getTeacher(((UserDecorator) u).decoratedUser);
        }
        return null;
    }
    public Teacher getTeacher(String emailTeacher) {
        User u = getUser(emailTeacher);
        Teacher t = getTeacher(u);
        if (t == null) throw new IllegalArgumentException();
        return t;

    }
    public Parent getParent(User u) {
        if (u instanceof Parent) {
            return (Parent) u;
        }
        if (u instanceof UserDecorator) {
            return getParent(((UserDecorator) u).decoratedUser);
        }
        return null;

    }
    public Parent getParent(String emailParent) {
        User u = getUser(emailParent);
        Parent p = getParent(u);
        if (p == null) throw new IllegalArgumentException();
        return p;
    }

    public Coordinator getCoordinator(User u) {
        if (u instanceof Coordinator) {
            return (Coordinator) u;
        }
        if (u instanceof UserDecorator) {
            return getCoordinator(((UserDecorator) u).decoratedUser);
        }
        return null;
    }

    public Coordinator getCoordinator(String emailCoor) {
        User u = getUser(emailCoor);
        Coordinator c = getCoordinator(u);
        if (c == null) throw new IllegalArgumentException();
        return c;
    }

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

    public void assignTeacher(String emailTeacher, String className) {
        Teacher t = getTeacher(emailTeacher);
        Class   c = getClass(className);
        c.teacher = t;
        t.schoolClass = c;
    }
    
    public boolean isTeacherOf(String emailTeacher, String className) {
        try {
            return getTeacher(emailTeacher).schoolClass.name.equals(className); 
        }
        catch (Exception e) {
            return false;
        }
    }

    public void addChild(String emailParent, String childName) {
        Parent p = getParent(emailParent); 
        Child ch = getChildByName(childName);
        p.addChild(ch);
    }
    public void addLunch(String emailParent, String childName, SimpleDate date) {
        Parent p = getParent(emailParent);
        Child ch = getChildByName(childName);
        if (p.isChildOf(ch)) {
            p.addLunchDate(ch, date);
        }
    }
    public void addNoLunchDate(String emailTeacher, SimpleDate date) {
        Teacher t = getTeacher(emailTeacher);
        t.addNoLunchDate(date);
    }
    public void addPupil(String childName, String classname) { 
        Child child = new Child(childName);
        Class c = getClass(classname);
        c.addPupil(child);
    }

    public boolean hasNoLunch(String classname, SimpleDate d) {
        return getClass(classname).hasNoLunch(d);
    }
    public void addUnavailableDate(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        p.addAvailability(d, false);
    }
    public void addPreferDate(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        p.addAvailability(d, true);
    }
    public boolean isAvailable(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        return p.isAvailable(d);
    }
    public boolean isUnavailable(String emailParent, SimpleDate d) {
        return !this.isAvailable(emailParent, d);

    }
    public boolean isPreferred(String emailParent, SimpleDate d) {
        Parent p = getParent(emailParent);
        return p.isPreferred(d);

    }
    public boolean isPupilOf(String childName, String className) {
        Child ch = getChildByName(childName);
        return getClass(className).hasPupil(ch);
    }
    public boolean isChildOf(String childName, String emailParent) {
        Child ch = getChildByName(childName);
        Parent p = getParent(emailParent);
        return p.isChildOf(ch);
    }
    public void setToPayAFrontCostScheme(String emailParent, String childName) {
        Child ch = getChildByName(childName);
        Parent p = getParent(emailParent);
        if (p.isChildOf(ch)) 
            ch.setToPayAFrontCostScheme();
    }
    public void setToStandardCostScheme(String emailParent, String childName) {
        Child ch = getChildByName(childName);
        Parent p = getParent(emailParent);
        if (p.isChildOf(ch)) 
            ch.setToStandardCostScheme();
    }
    public void addParentRoleToTeacher(String teacherEmail) {
        Teacher t = getTeacher(teacherEmail);
        Parent p = new Parent(t);
        registeredUsers.put(teacherEmail, p);
    }

    public void removeParentRoleFromTeacher(String teacherEmail) {}
    public void promote(String emailParent) {}
    public void demote(String coordinator) {}
    public boolean isCoordinator(String emailUser) { 
        try {
            Coordinator c = getCoordinator(emailUser);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public int calculateCost(String childName, int year) { return 0; }

    public boolean hasLunch(String childName, SimpleDate d) { 
        Child ch = getChildByName(childName);
        return ch.hasLunch(d);
    }
    
}
