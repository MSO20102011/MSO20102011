import java.util.LinkedList;
import utils.*;

public class LunchSchedule {
    LinkedList<SimpleDate> lunches;

    public LunchSchedule() {
        lunches = new LinkedList<SimpleDate>();

    }
    public void addLunch(SimpleDate d) {
        lunches.add(d);
    }
}
