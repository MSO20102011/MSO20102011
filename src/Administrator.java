public class Administrator extends UserDecorator {

    public RegistrationManager registration;


	public Administrator(User u) {
		super(u);
	}
    
    public void promote(Parent parent) {

    }
    public void demote(Coordinator coor) {

    }
    public void addChild(Class c, Child ch) {

    }
    public void remChild(Class c, Child ch) {

    }
    public void approveRegistration(RegistrationData date) {

    }
    public void handleOutstandingRegistrations() {

    }
}
