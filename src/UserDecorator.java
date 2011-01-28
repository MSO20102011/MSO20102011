

abstract class UserDecorator extends User {
    protected User decoratedUser;
    public UserDecorator(User u) {
        decoratedUser = u;
    }
}


