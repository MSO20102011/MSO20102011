/* We changed the name from System to SLMS, because System
 * is already imported by default in java. */

import java.util.Hashtable;

public class SLMS {

    // We use a hashtable to make lookups on e-mail addresses faster.
    public Hashtable<String, User> users; 
    public Hashtable<String, Teacher> teachers;
    public Hashtable<String, Administrator> admins;
    public Hashtable<String, Class> classes;


    // Implementing the singleton
    private static SLMS instance = null;
    protected SLMS () {} 
    public static SLMS getInstance() {
        return (instance = instance == null ? new SLMS() : instance);
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
        return getTeacher(emailTeacher).schoolClass.className.equals(className);
    }
}
