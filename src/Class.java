import utils.*;
import java.util.LinkedList;

public class Class {

	String name;
    Teacher teacher;
    LinkedList<Child> pupils;
    LinkedList<SimpleDate> noLunches;

    public Class(String name) {
        this.name = name;
        this.teacher = null;
        this.pupils = new LinkedList<Child>();
        this.noLunches = new LinkedList<SimpleDate>();
    }
    
    public boolean hasNoLunch(SimpleDate d) {
        return noLunches.contains(d);
    }

    public void addPupil(Child c) {
        this.pupils.add(c);
    }
    public boolean hasPupil(Child c) {
        return pupils.contains(c);
    }
}
