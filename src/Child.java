import utils.*;

public class Child {

	String name;
    LunchSchedule schedule;
    CostScheme costscheme;

    public Child(String name) {
        this.name = name;
        this.schedule = new LunchSchedule();
        this.costscheme = new StandardScheme();
    }
    public boolean hasLunch(SimpleDate d) {
        return schedule.lunches.contains(d);
    }

    public void setToPayAFrontCostScheme() {
        costscheme = new PayUpFrontScheme();
    }
    public void setToStandardCostScheme() {
        costscheme = new StandardScheme();
    }
    public int calculateCost(int year) {
        return costscheme.calculateCost(this, year);
    }
}
