

abstract class UserDecorator extends User {
    protected User decoratedUser;
    public UserDecorator(){}
    public UserDecorator(User u) {
        decoratedUser = u;
    }

    /*
    public Teacher getTeacher() {
        if (decoratedUser instanceof Teacher) {
            return (Teacher) decoratedUser;
        }
        if (decoratedUser instanceof User) {
            return null;
        }
        return decoratedUser.getTeacher();
    }*/
}


