import utils.*;

public class Child {

	String name;
    LunchSchedule schedule;
    CostScheme costscheme;
    Parent parent; 
    Class class_;

    public Child(String name) {
        this.name = name;
        this.schedule = new LunchSchedule();
        this.costscheme = new StandardScheme();
        this.parent = null;
        this.class_ = null;
    }

    /* Returns whether or not the child has a lunch on the given date. */
    public boolean hasLunch(SimpleDate d) {
        return schedule.lunches.contains(d);
    }

    /* Set the paying scheme to up-front. */
    public void setToPayAfrontCostScheme() {
        this.costscheme = new PayUpFrontScheme();
    }

    /* Set the paying scheme to the standard one. */
    public void setToStandardCostScheme() {
        this.costscheme = new StandardScheme();
    }

    /* Calculate the cost of the lunches taken 
     * by this child in the given year. */
    public int calculateCost(int year) {
        return costscheme.calculateCost(this, year);
    }
}
