
abstract class UserDecorator extends User {
	protected User decoratedUser;
	public UserDecorator(User u) {
		decoratedUser = u;
	}

    public Teacher getTeacher() {
        if (decoratedUser instanceof Teacher) {
            return (Teacher) decoratedUser;
        }
        if (decoratedUser instanceof User) {
            return null;
        }
    }
}


class Teacher extends UserDecorator {
	
	public Teacher(User u) {
		super(u);
	}
	
	public void addNoLunchDate(SimpleDate d) {
		
	}
}
