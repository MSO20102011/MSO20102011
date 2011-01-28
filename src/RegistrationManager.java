
public class RegistrationManager 
{
	SLMS sys;

	public RegistrationManager(SLMS system) {
		this.sys = system;
	}

	/* Begin a new registration progress. */
	public void beginRegister() {}
	
	/* Registers a user. This method puts the inserted data in the right place. */
	public void register(RegistrationData d) {}
	
	/* This method is there for the Administrator; so he can confirm if the user is 
	 * allowed in the system. */
	public void confirmRegistration(RegistrationData d) {}
	
	/* This method sends a mail to the person who is registering to confirm or 
	 * deny his/her access. */
	public void sendMail(RegistrationData d) {}
	
}

