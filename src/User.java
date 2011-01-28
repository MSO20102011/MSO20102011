import java.util.Timer;


public class User {

    String name, address, email, password;
    Boolean suspended;
    Time blockTime;

    public User() {}
    public User(String name, String email, String passwd) {
        this.name = name;
        this.email = email;
        this.password = passwd;
    }
    
    /* Try to login to the system. */
    public void login(String email, String password){ }
    
    /* Logout of the system. */
    public void logout(String email, String password){ }
    
    /* View the pupils in every lunch-group. */
    public void viewPupilGroups(){ }
    
    /* View the dates on which there is no lunch. */
    public void viewNoLunchDates(){ }
    
    /* View the supervision schedule. */
    public void viewSupervisionSchedule(){ }
}
