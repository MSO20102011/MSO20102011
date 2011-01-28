import utils.*;
import java.util.LinkedList;

public class Parent extends UserDecorator {
	
	int allowedMisses;
	int missesCount;
	int ownedMoney;
    LinkedList<Child> childrenList;
    LinkedList<Availability> availabilities;
	
	public void addChild(Child child) {
        childrenList.add(child);
	}
	public void removeChild(Child child) {
        childrenList.remove(child);
	}
    public boolean isChildOf(Child child) {
        childrenList.contains(child);
    }
	public void viewLunchSchedule(Child child) { }
	public void addLunchDate(Child child, SimpleDate date) {
	}
	public void remLunchDate(Child child, SimpleDate date) {
		
	}
	public void viewAvailability() {
		
	}
	public void addAvailability(SimpleDate date, Boolean preferred) {
        Availability a = new Availability();
        a.date = date;
        a.preferred = preferred;
	}

    public boolean isAvailable(SimpleDate d) {
        for (Availability a : this.availabilities) {
            if (a.date.equals(d)) {
                return a.preferred;
            }
        }
        return true;
    }


	public void changeAvailability(SimpleDate date, Boolean preferred) {
		
	}
	public void removeAvailability(SimpleDate date) {
		
	}
	public void swapTurn(SwapRequest swap) {
		
	}
    public boolean isPreferred(SimpleDate d) {
        for (Availability a : this.availabilities) {
            if (a.date.equals(d)) {
                return a.preferred;
            }
        }
        return false;
    }

}
