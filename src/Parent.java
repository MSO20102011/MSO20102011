
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
    public bool isChildOf(Child child) {
        childrenList.contains(child);
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
        Availability a = new Availability();
        a.date = date;
        a.preferred = preferred;
        return a;
	}

    public bool isAvailable(SimpleDate d) {
        for (Availability a : this.availabilities) {
            if (a.date.equals(d)) {
                return a.preferred;
            }
        }
        return true;
    }


	public void changeAvailability(Date date, Boolean preferred) {
		
	}
	public void removeAvailability(Date date) {
		
	}
	public void swapTurn(SwapRequest swap) {
		
	}
    public bool isPreferred(SimpleDate d) {
        for (Availability a : this.availabilities) {
            if (a.date.equals(d)) {
                return a.preferred;
            }
        }
        return false;
    }

}
