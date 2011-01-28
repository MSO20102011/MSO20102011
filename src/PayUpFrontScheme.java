import utils.*;

public class PayUpFrontScheme implements CostScheme 
{

	public int calculateCost(Child child, int year)
	{
        int n = 0;
        for (SimpleDate d : child.schedule.lunches) {
            if (d.year == year && !child.class_.noLunches.contains(d)) {
                n++;
            }
        }
		return Math.max((n - 20) * 250, 0);
	}
}
