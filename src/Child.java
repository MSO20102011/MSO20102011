
public class Child {

	String name;
    LunchSchedule schedule;

    public boolean hasLunch(SimpleDate d) {
        return schedule.lunches.hasKey(d);
    }
}
