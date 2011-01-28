import utils.*;

public class Child {

	String name;
    LunchSchedule schedule;
    CostScheme costscheme;

    public boolean hasLunch(SimpleDate d) {
        return schedule.lunches.contains(d);
    }

    public void setToPayAFrontCostScheme() {
        costscheme = new PayUpFrontScheme();
    }
    public void setToStandardCostScheme() {
        costscheme = new StandardScheme();

    }
}
