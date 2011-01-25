
public class Parent {
	
	int allowedMisses;
	int missesCount;
	float ownedMoney;
	Child[] childrenList;
	
	public void addChild(Child child) {
		childrenList[childrenList.length] = child;
	}
	public void removeChild(Child child) {
		for (Child c : childrenList) {
			if (c.equals(child)) {
				c = null;
			}
		}
	}
	public void viewLunchSchedule(Child child) {
		System.out.println(child.getLunchSchedule());
	}
	public void addLunchDate(Child child, Date date) {
		
		child.schedule.lunches[child.schedule.lunches.length] = new Lunch(date);
		
	}
	public void remLunchDate(Child child, Date date) {
		
		for (Lunch l : child.schedule.lunches) {
			if (l.date.equals(date)) {
				l = null;
			}
		}
		
	}
	public void viewAvailability() {
		
	}
	public void addAvailability(Date date, Boolean preferred) {
		
	}
	public void changeAvailability(Date date, Boolean preferred) {
		
	}
	public void removeAvailability(Date date) {
		
	}
	public void swapTurn(SwapRequest swap) {
		
	}

}
