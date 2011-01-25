
import java.util.LinkedList;

public class Parent {
	
	int allowedMisses;
	int missesCount;
	float ownedMoney;
    LinkedList<Child> childrenList;
	
	public void addChild(Child child) {
        childrenList.add(child);
	}
	public void removeChild(Child child) {
        childrenList.remove(child);
	}
	public void viewLunchSchedule(Child child) {
		System.out.println(child.getLunchSchedule());
	}
	public void addLunchDate(Child child, Date date) {
	}
	public void remLunchDate(Child child, Date date) {
		
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
