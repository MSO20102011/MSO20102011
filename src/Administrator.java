public class Administrator extends UserDecorator {

    private RegistrationManager registration;
	private SLMS system;

	public Administrator(User u, SLMS sys) {
		super(u);
		sys = system;
	}
    
    public void promote(String parent) {
		Parent p = system.getParent(parent);
		system.registeredUsers.put(parent, new Coordinator(p));
    }
    public void demote(String coor) {
		User u = system.getUser(coor);
		system.registeredUsers.put(coor, removeCoordinatorRole(u));
    }
	public User removeCoordinatorRole(User u) {
		if (u instanceof Coordinator) {
			return removeCoordinatorRole(u);
		}
		if (u instanceof UserDecorator) {
			User n = removeCoordinatorRole(((UserDecorator) u).decoratedUser);
			((UserDecorator) u).decoratedUser = n;
		}
		return u;
	}

    public void addChild(Class c, Child ch) {
        c.addPupil(ch);
        ch.class_ = c;
    }
    public void remChild(Class c, Child ch) { }
    public void approveRegistration(RegistrationData date) { }
    public void handleOutstandingRegistrations() { }
}
