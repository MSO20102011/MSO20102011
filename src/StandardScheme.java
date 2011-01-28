

public class StandardScheme implements CostScheme 
{

	public int calculateCost(Child child, int year)
	{
		return child.schedule.lunches.size() * 150;
	}
}
