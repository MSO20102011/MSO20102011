/* We changed the name from System to SLMS, because System
 * is already imported by default in java. */

import java.util.Hashtable;

public class SLMS {

    // We use a hashtable to make lookups on e-mail addresses faster.
    public Hashtable users; 
    public Hashtable teachers;
    public Hashtable admins;

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
    }
    
    public boolean isTeacherOf(String emailTeacher, String className) {
        Teacher t = (Teacher) teachers.get(emailTeacher);
        if (t == null) { return false; }
        return t.schoolClass.className.equals(className);
    }
}
