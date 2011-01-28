import utils.*;

public class StandardScheme implements CostScheme 
{

	public int calculateCost(Child child, int year)
	{
        int n = 0;
        for (SimpleDate d : child.schedule.lunches) {
            if (d.year == year && !child.class_.noLunches.contains(d)) {
                n++;
            }
        }
        System.out.printf("%d\n", n);
		return n * 150;
	}
}
