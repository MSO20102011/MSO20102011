import utils.* ;


public class SLMSTI implements SLMSTestInterface {

	
	SLMS slms ;
	
	String ADMIN ;	
	
	public void resetSLMS(){
		slms = SLMS.getInstance() ;
		slms.resetState() ;
		ADMIN = "yourgod@heaven.com" ;
		Administrator A = new Administrator("ADMIN", ADMIN, "blabla", slms) ;
		slms.admins.add(A) ;
		slms.activeUsers.add(A) ;
		//System.out.println("**" + A.email.email) ;
		//System.out.println("***" + slms.getUser(ADMIN).name) ;
	}
	
	public void addClass(String name) {
		slms.addClass(ADMIN, name) ;
	}
	
	public void addParent(String name, String email, String pwd) {
		if (slms.getUser(email) != null) throw new IllegalArgumentException() ;
		slms.activeUsers.add(new User(name,email,pwd)) ;
		slms.addParent(email) ;
	}
	
	public boolean userExists(String email) {		
		return (slms.getUser(email) != null) ;
	}

	/**
	 * This should add a child to the system, and adding her to 
	 * a school class as well.
	 */
	public void addPupil(String childName, String className) {
		slms.addPupil(ADMIN, childName, className) ;
	}
	
	/**
	 * This add a child to a parent's list of children.
	 */
	public void addChild(String emailParent, String childName) {
		slms.addChild(emailParent, childName) ;
	}
		
	public void addLunchDate(String emailParent, String childName, SimpleDate date) {
		slms.addLunchDate(emailParent, childName, date) ;
	}
	
	public boolean hasLunch(String childName, SimpleDate date) {
		Child c = slms.getChild(childName) ;
		return c.lunchSchedule.contains(date) ;	
	}
	
	public void addPreferDate(String emailParent, SimpleDate date) {
		slms.addAvailability(emailParent, date, new Preferred(date)) ;
	}
	
	public void addUnavailableDate(String emailParent, SimpleDate date) {
		slms.addAvailability(emailParent, date, new Unavailable(date)) ;
	}
	
	public boolean isAvailable(String emailParent, SimpleDate date) {
		Parent P = slms.getParent(emailParent) ;
		return P.availabilities.isAvailable(date) ;
	}
	
	public boolean isUnavailable(String emailParent, SimpleDate date) {
		Parent P = slms.getParent(emailParent) ;
		return P.availabilities.isUnavailable(date) ;
	}
	
	public boolean isPreferred(String emailParent, SimpleDate date) {
		Parent P = slms.getParent(emailParent) ;
		return P.availabilities.isPreferred(date) ;
	}

	@Override
	public void addNoLunchDate(String emailTeacher, SimpleDate date) {
		slms.addNoLunchDate(emailTeacher,date) ;		
	}

	@Override
	public void addParentRoleToTeacher(String teacherEmail) {
		slms.addParent(teacherEmail) ;
	}

	@Override
	public void addTeacher(String name, String email, String pwd) {
		if (slms.getUser(email) != null) throw new IllegalArgumentException() ;	
		slms.activeUsers.add(new User(name,email,pwd)) ;
		slms.addTeacher(ADMIN, email) ;
	}

	@Override
	public void assignTeacher(String emailTeacher, String className) {
		slms.assignTeacher(ADMIN, emailTeacher, className) ;
	}

	@Override
	public boolean hasNoLunch(String className, SimpleDate date) {
		SchoolClass C = slms.getClass(className) ;
		return C.nolunchDates.contains(date) ;
	}

	@Override
	public boolean isChildOf(String childName, String emailParent) {
		Parent P = slms.getParent(emailParent) ;
		Child C = slms.getChild(childName) ;
		if (P==null || C==null) return false ;
		return P.children.children.contains(C) ;
	}

	@Override
	public boolean isPupilOf(String childName, String className) {
		SchoolClass SC = slms.getClass(className) ;
		Child C = slms.getChild(childName) ;
		return SC.pupils.contains(C) ;
	}

	@Override
	public boolean isTeacherOf(String emailTeacher, String className) {
		SchoolClass SC = slms.getClass(className) ;
		Teacher T = slms.getTeacher(emailTeacher) ;
		return SC.teacher == T ;
	}

	@Override
	public void removeParentRoleFromTeacher(String teacherEmail) {
		slms.remParentRole(teacherEmail) ;
	}

	@Override
	public int calculateCost(String childName, int year) {
		Child C = slms.getChild(childName) ;
		return C.costScheme.calculateCost(year) ;
	}

	@Override
	public void setToPayAfrontCostScheme(String emailParent, String childName) {
		slms.changeCostScheme(emailParent, childName, "CostSchemePayAfront") ;
	}

	@Override
	public void setToStandardCostScheme(String emailParent, String childName) {
		slms.changeCostScheme(emailParent, childName, "CostSchemeStandard") ;
	}

	@Override
	public void demoteFromCoordinator(String emailCoordinator) {
		slms.demoteFromCoord(ADMIN, emailCoordinator) ;
	}

	@Override
	public void promoteToCoordinator(String emailParent) {
		slms.promoteToCoord(ADMIN, emailParent) ;
	}
		
	public boolean isCoordinator(String email) {
		return slms.getCoordinator(email) != null ;
	}
}
