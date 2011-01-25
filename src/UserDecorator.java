
abstract class UserDecorator extends User {
	protected User decoratedUser;
	public UserDecorator(User u) {
		decoratedUser = u;
	}
}


class Teacher extends UserDecorator {
	
	public Teacher(User u) {
		super(u);
	}
	
	public void addNoLunchDate(SimpleDate d) {
		
	}
}
