import utils.*;

public class StandardScheme implements CostScheme 
{

    /* Calculates the lunch cost for the given child and year using 
     * the standard paying scheme (1.50 per lunch). */
	public int calculateCost(Child child, int year)
	{
        int n = 0;
        for (SimpleDate d : child.schedule.lunches) {
            if (d.year == year && !child.class_.noLunches.contains(d)) {
                n++;
            }
        }
		return n * 150;
	}
}
