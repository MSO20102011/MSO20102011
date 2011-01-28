
public class PayUpFrontScheme implements CostScheme 
{

	public int calculateCost(Child child, int year)
	{
		if( child.schedule.lunches.size()<20)
			return 0;
		else return (child.schedule.lunches.size()-20)*250;
	}
}
