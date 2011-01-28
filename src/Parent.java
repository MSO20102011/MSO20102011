import utils.*;
import java.util.LinkedList;

public class Parent extends UserDecorator {
    
    int allowedMisses;
    int missesCount;
    int ownedMoney;
    LinkedList<Child> children;
    LinkedList<Availability> availabilities;

    public Parent(User u) {
        super(u);
        children       = new LinkedList<Child>();
        availabilities = new LinkedList<Availability>();
    }

    /* Adds a child to the parent's children */
    public void addChild(Child child) {
        children.add(child);
    }

    /* Remove a child from the parent's children */
    public void removeChild(Child child) {
        children.remove(child);
    }

    /* Checks if the given Child is a child of this parent. */
    public boolean isChildOf(Child child) {
        return children.contains(child);
    }

    /* Add a date to the child's schedule */
    public void addLunchDate(Child child, SimpleDate date) {
        child.schedule.addLunch(date);
    }

    /* Add an availability preference for the given date. 
     * @param preferred   If true the date is preferred; 
     *                    if not the date is unavailable. */
    public void addAvailability(SimpleDate date, Boolean preferred) {
        Availability a = new Availability();
        a.date = date;
        a.preferred = preferred;
        availabilities.addFirst(a);
    }

    /* Check if the parent is available to supervise on the given date. */
    public boolean isAvailable(SimpleDate d) {
        for (Availability a : this.availabilities) {
            if (a.date.equals(d)) return a.preferred;
        }
        return true;
    }

    /* Mark the given day as preferred for overlooking a lunch. */
    public boolean isPreferred(SimpleDate d) {
        for (Availability a : this.availabilities) {
            if (a.date.equals(d)) return a.preferred;
        }
        return false;
    }

    /* View the child's lunch schedule. */
    public void viewLunchSchedule(Child child) { }

    /* Remove a lunch date from the child's schedule. */
    public void remLunchDate(Child child, SimpleDate date) { }

    /* View the availability entries*/
    public void viewAvailability() { }

    /* Change the availability preference.*/
    public void changeAvailability(SimpleDate date, Boolean preferred) { } 

    /* Remove the availability preference.*/
    public void removeAvailability(SimpleDate date) { } 

    /* Confirm a swap request. */
    public void swapTurn(SwapRequest swap) { }
}
