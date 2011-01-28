/* We changed the name from System to SLMS, because System
 * is already imported by default in java. */

import utils.*;
import java.util.Hashtable;

public class SLMS {

    // We use a hashtable to make lookups on e-mail addresses faster.
    public Hashtable<String, User> users; 
    public Hashtable<String, Teacher> teachers; // Todo: Teacher -> User
    public Hashtable<String, Administrator> admins; // Todo: Administrator -> User
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
        users.clear();
        teachers.clear();
        admins.clear();
        classes.clear();
    }

    public void addClass(String name) {
        classes.put(name, new Class(name));
    }

    public User newUser(String name, String email, String pwd) {
        User u = new User(name, email, pwd);
        users.put(email, u);
        return u;
    }

    public void addParent(String name, String email, String pwd) {
        User u = newUser(name, email, pwd);
        // TODO: add parent role
    }
    public void addTeacher(String name, String email, String pwd) {
        User u = newUser(name, email, pwd);
        // teachers.put(email, u);
        // TODO: add teacher role
    }

    public Class getClass(String className) {
        Class c = classes.get(className);
        if (c == null) throw new IllegalArgumentException();
        return c;
    }
    public Teacher getTeacher(String emailTeacher) {
        Teacher t = teachers.get(emailTeacher);
        if (t == null) throw new IllegalArgumentException();
        return t;
    }

    public void assignTeacher(String emailTeacher, String className) {
        Teacher t = getTeacher(emailTeacher);
        Class   c = getClass(className);
        c.teacher = t;
        t.schoolClass = c;
    }
    
    public boolean isTeacherOf(String emailTeacher, String className) {
        return getTeacher(emailTeacher).schoolClass.name.equals(className);
    }

    public void addChild(String emailParent, String childName) {
        // parent opzoeken
        // child toevoegen.

    }
    public void addLunch(String emailParent, String childName, SimpleDate date) {
        // parent opzoeken
        // child vinden
    }
    public void addNoLunchDate(String emailParent, SimpleDate date) {
        // parent opzoeken
        // child vinden.

    }
    public void addPupil(String childName, String classname) { 
        Child child = null; // child opzoeken
        Class c = null; // class opzoeken
        c.addPupil(child);
    }

    public boolean hasNoLunch(String classname, SimpleDate d) {
        Class c = null; // class opzoeken
        return c.hasNoLunch(d);
    }
    public void addUnavailableDate(String emailParent, SimpleDate d) {
        Parent p = null; // parent opzoeken
        p.addAvailability(d, false);
    }
    public void addPreferDate(String emailParent, SimpleDate d) {
        Parent p = null; // parent opzoeken
        p.addAvailability(d, true);
    }
    public boolean isAvailable(String emailParent, SimpleDate d) {
        Parent p = null; // parent opzoeken
        return p.isAvailable(d);
    }
    public boolean isUnavailable(String emailParent, SimpleDate d) {
        return this.isAvailable(emailParent, d);

    }
    public boolean isPreferred(String emailParent, SimpleDate d) {
        Parent p = null; // parent opzoeken
        return p.isPreferred(d);

    }
    public boolean isPupilOf(String childName, String className) {
        Child ch = null;
        Class c = null;
        return c.hasPupil(ch);
    }
    public boolean isChildOf(String childName, String emailParent) {
        Child ch = null; // child opzoeken
        Parent p = null; // parent opzoeken
        return p.isChildOf(ch);
    }
    public void setToPayAFrontCostScheme(String emailParent, String childName) {
        Child ch = null; //child opzoeken
        Parent p = null; // parent opzoeken
        if (p.isChildOf(ch)) 
            ch.setToPayAFrontCostScheme();
    }
    public void setToStandardCostScheme(String emailParent, String childName) {
        Child ch = null;
        Parent p = null;
        if (p.isChildOf(ch)) 
            ch.setToStandardCostScheme();
    }


    
}
