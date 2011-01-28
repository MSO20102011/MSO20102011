import java.util.Timer;


public class User {

	String name, address, email, password;
	Boolean suspended;
	Time blockTime;

    public User(String name, String email, String passwd) {
        this.name = name;
        this.email = email;
        this.password = passwd;
    }
	
	public void login(String email, String password){ }
	
	public void logout(String email, String password){ }
	
	public void viewPupilGroups(){ }
	
	public void viewNoLunchDates(){ }
	
	public void viewSupervisionSchedule(){ }
}
