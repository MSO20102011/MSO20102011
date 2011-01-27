
public class Child {

	String name;
    LunchSchedule schedule;
    CostScheme costscheme;

    public boolean hasLunch(SimpleDate d) {
        return schedule.lunches.hasKey(d);
    }

    public setToPayAFrontCostScheme() {
        costscheme = new PayUpFrontScheme();
    }
    public setToStandardCostScheme() {
        costscheme = new StandardScheme();

    }
}
