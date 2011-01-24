/* Changed the name from System, because that name
 * is already imported by default in java. */

import java.util.Hashtable;

public class SLMS {

    // We use a hashtable to make lookups on e-mail addresses faster.
    public Hashtable users; 

    // Implementing the singleton
    private static SLMS instance = null;
    protected SLMS () {} 
    public static SLMS getInstance() {
        return (instance = instance == null ? new SLMS() : instance);
    }

    public void resetState() {

    }
}
