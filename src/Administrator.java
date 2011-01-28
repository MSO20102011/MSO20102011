public class Administrator extends UserDecorator {


    private RegistrationManager registration;
	private SLMS system;

	public Administrator(User u, SLMS sys) {
		super(u);
		sys = system;
		this.registration = new RegistrationManager(sys);
	}
    

	/* Promote a parent to a coordinator. */
    public void promote(String parent) {
		Parent p = system.getParent(parent);
		system.registeredUsers.put(parent, new Coordinator(p));
    }


	/* Demote a coordinator to a parent. */
    public void demote(String coor) {
		User u = system.getUser(coor);
		system.registeredUsers.put(coor, removeCoordinatorRole(u));
    }

	/* Helper function to remove the coordinator role 
	 * from the decorated User. */
	private User removeCoordinatorRole(User u) {
		if (u instanceof Coordinator) 
			return removeCoordinatorRole(u);
		if (u instanceof UserDecorator) {
			User n = removeCoordinatorRole(((UserDecorator) u).decoratedUser);
			((UserDecorator) u).decoratedUser = n;
		}
		return u;
	}


	/* Adds a child to the given class. */
    public void addChild(Class c, Child ch) {
        c.addPupil(ch);
        ch.class_ = c;
    }


	/* Removes a child from the given class. */
    public void remChild(Class c, Child ch) { }

	/* Approve registration data entered by a potential new user. */
    public void approveRegistration(RegistrationData date) { }

	/* Presents the admin with a page to handle outstanding registrations. */
    public void handleOutstandingRegistrations() { }
}
