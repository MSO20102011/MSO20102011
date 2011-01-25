
import java.util.LinkedList;

public class Class {

	String name;
    LinkedList<Child> pupils;
    LinkedList<Date> noLunches;
    
    public boolean hasNoLunch(SimpleDate d) {
        return noLunches.hasKey(d);
    }
}
