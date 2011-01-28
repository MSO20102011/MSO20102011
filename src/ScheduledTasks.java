
public class ScheduledTasks {

	SLMS system;

	public ScheduledTasks(SLMS sys) {
		this.system = sys;
	}

	/* Calculates the fine for each parent at the end of the year. */
	public void calculateFine() { }

	/* Calculates the lunch costs for each Parent at the end of the year. */
	public void calculateCost() { }

	/* Calculates the supervision schedule at the beginning of each month. */
	public void calculateSupervisionSchedule(int month, int year) { }

	/* At the end of the year, the variable of how many meetings a Parent has missed is set to zero again. */
	public void resetMissedMeetings() { }
	
}
