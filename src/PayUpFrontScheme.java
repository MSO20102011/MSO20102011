import utils.*;

public class PayUpFrontScheme implements CostScheme 
{

    /* Calculate the lunch cost for a given child and year 
     * using the upfront pay-scheme. 20 lunches are paid for, 
     * after that the costs are 2.50 per lunch. */
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
