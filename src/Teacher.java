import utils.*;

class Teacher extends UserDecorator {
    public Class schoolClass;
	
	public Teacher(User u) {
		super(u);
	}
	
    /* Add a date to class's schedule on which there are no lunches. */
	public void addNoLunchDate(SimpleDate d) {
        schoolClass.noLunches.add(d);
	}
    
    /* Remove a previously declared date from the no-lunch-schedule. */
    public void removeNoLunchDate(SimpleDate d) {
        schoolClass.noLunches.remove(d);
    }
}
