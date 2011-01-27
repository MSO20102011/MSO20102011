


public class StandardScheme implements CostScheme 
{

	public int CalculateCost(Child child, int year)
	{
		
		return child.schedule.lunches.length()*150;
	}
}
