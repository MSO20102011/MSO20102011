import utils.*;
import java.util.LinkedList;

public class Class {

	String name;
    Teacher teacher;
    LinkedList<Child> pupils;
    LinkedList<SimpleDate> noLunches;

    public Class(String name) {
        this.name      = name;
        this.teacher   = null;
        this.pupils    = new LinkedList<Child>();
        this.noLunches = new LinkedList<SimpleDate>();
    }
    
    /* Reports if a child has a lunch on the given date. */
    public boolean hasNoLunch(SimpleDate d) {
        return noLunches.contains(d);
    }

    /* Adds a pupil to the class. */
    public void addPupil(Child c) {
        this.pupils.add(c);
    }

    /* Check if the child is in the class. */
    public boolean hasPupil(Child c) {
        return pupils.contains(c);
    }
}
