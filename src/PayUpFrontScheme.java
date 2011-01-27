
public class PayUpFrontScheme implements CostScheme 
{

	public int CalculateCost(Child child, int year)
	{
		if( child.schedule.lunches.length()<20)
			return 0;
		else return (child.schedule.lunches.length()-20)*250;
	}
}
