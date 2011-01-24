/* We changed the name from System to SLMS, because System
 * is already imported by default in java. */

import java.util.Hashtable;

public class SLMS {

    // We use a hashtable to make lookups on e-mail addresses faster.
    public Hashtable users; 
    public Hashtable teachers;
    public Hashtable admins;
    public Hashtable classes;


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

    public Class getClass(String className) {
        Class c = (Class) classes.get(className);
        if (c == null) throw new IllegalArgumentException();
        return c;
    }
    public Teacher getTeacher(String emailTeacher) {
        Teacher t = (Teacher) teachers.get(emailTeacher);
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
