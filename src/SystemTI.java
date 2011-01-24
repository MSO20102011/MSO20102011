import utils.*;

public class SystemTI implements SLMSTestInterface {

    SLMS system;
	/**
	 * This method should reset the state of the SLMS. At the
	 * beginning of every test-case that we provide for you, 
	 * we call this method to make sure that the SLMS is always 
	 * started with the same state. Of course after that, each
	 * test-case may decide to put a different population into
	 * your SLMS.
	 */
	public void resetSLMS() {
        system = SLMS.getInstance();
        system.resetState();
        // todo: add admin?
    }
	
	/**
	 * This method should add a new school-class with the given name to your
	 * SLMS. 
	 */
	public void addClass(String name) {
        // todo: needs admin?
        system.addClass(name);
    }
	
	/**
	 * This method should add a new parent to your SLMS. You need to allow
	 * the test interface to do this without having to go through the normal 
	 * registration process. 
	 * 
	 * Pre-condition: nu user with the same email already exists.
	 */
	public void addParent(String name, String email, String pwd) {
        system.addParent(name, email, pwd);
    }

	/**
	 * This method should add a new teacher to your SLMS. You need to allow
	 * the test interface to do this without having to go through the normal 
	 * registration process. 
	 * 
	 * Pre-condition: nu user with the same email already exists.
	 */
	public void addTeacher(String name, String email, String pwd) {
        system.addTeacher(name, email, pwd);
    }
	
	/**
	 * Check if a user with the given email exists in your SLMS.
	 */
	public boolean userExists(String email) { 
        return system.users.containsKey(email);
    }
	
	/**
	 * Assign a teacher to a class. 
	 * 
	 * Pre-condition: the teacher and the class already exist in your
	 * SLMS,
	 */
	public void assignTeacher(String emailTeacher, String className) {
        system.assignTeacher(emailTeacher, className);
    }
	
	/**
	 * Check is the given teacher is the teacher of the given class.
	 */
	public boolean isTeacherOf(String emailTeacher, String className) {
        return system.isTeacherOf(emailTeacher, className);
    }
	
	/**
	 * This should add a child to the system, and adding her to 
	 * a school class as well.
	 * 
	 * Pre-condition: the class already exists.
	 */
	public void addPupil(String childName, String className) {}
	
	/**
	 * Check if the given pupil is a pupil of the given class.
	 */
	public boolean isPupilOf(String childName, String className) { return false; }
	
	/**
	 * This add a child to a parent's list of children. 
	 * 
	 * Pre-condition: the parent already exists, and the child
	 * must already be a pupil in some class.
	 */
	public void addChild(String emailParent, String childName) {}

	/**
	 * Check if a child belongs to the children of a parent.
	 */
	public boolean isChildOf(String childName, String emailParent) { return false; }

	/**
	 * Add a lunch date for a child that belongs to a parent.
	 * 
	 * Pre-condition: both the child and parent should already exists. 
	 * The child should be a child of the parent.
	 */
	public void addLunchDate(String emailParent, String childName, SimpleDate date) {}
	
	/**
	 * Check whether a child has a lunch scheduled on the given date.
	 * 
	 * Pre-condition: the child already exists.
	 */
	public boolean hasLunch(String childName, SimpleDate date) { return false; }
	
	/**
	 * This is to add a preferred supervision date of a parent.
	 * 
	 * Pre-condition: the parent should exist.
	 */
	public void addPreferDate(String emailParent, SimpleDate date) {}
	
	/**
	 * This is to add a date where a parent would be unavailable for supervision.
	 * 
	 * Pre-cond: the parent should exist.
	 */
	public void addUnavailableDate(String emailParent, SimpleDate date) {}
	
	/**
	 * This is to check if the parent is available for supervision on a given dat.
	 * 
	 * Pre-cond: the parent should exist.
	 */
	public boolean isAvailable(String emailParent, SimpleDate date) { return false; }
	
	/**
	 * This is to check if the parent is unavailable for supervision on a given dat.
	 * 
	 * Pre-cond: the parent should exist.
	 */
	public boolean isUnavailable(String emailParent, SimpleDate date) { return false; }

	/**
	 * This is to check if the parent prefers a given date to do supervision.
	 * 
	 * Pre-cond: the parent should exist.
	 */
	public boolean isPreferred(String emailParent, SimpleDate date) { return false; }

	/**
	 * This is to add a date that a teacher indicates that on that date there
	 * is no lunch for her class.
	 * 
	 * Pre-cond: the teacher and her class should exist.
	 */
	public void addNoLunchDate(String emailTeacher, SimpleDate date) {}

	/**
	 * This is to check if a class has no lunch on a given date.
	 * 
	 * Pre-cond: the class should exist.
	 */
	public boolean hasNoLunch(String className, SimpleDate date) { return false; }
	
	/**
	 * This is to add a parent-role to a teacher.
	 * 
	 * Pre-cond: the teacher should exist.
	 */
	public void addParentRoleToTeacher(String teacherEmail) {}
	
	/**
	 * This is to remove the parent-role from a teacher.
	 * 
	 * Pre-cond: the teacher/parent should exist.
	 */
	public void removeParentRoleFromTeacher(String teacherEmail) {}
	
	/**
	 * This is to set a child of a given parent to use the standard cost scheme.
	 * 
	 * Pre-cond: the parent and child should exist. The child should belong to the parent.
	 */
	public void setToStandardCostScheme(String emailParent, String childName) {}

	/**
	 * This is to set a child of a given parent to use the pay-afront cost shceme.
	 * 
	 * Pre-cond: the parent and child should exist. The child should belong to the parent.
	 */
	public void setToPayAfrontCostScheme(String emailParent, String childName) {}
	
	/**
	 * This is to calculate the cost of lunch of a given child, for a given year.
	 * The cost is expressed in euro-cent.
	 * 
	 * Pre-cond: the child should exist. 
	 */
	public int calculateCost(String childName, int year) { return 0; }
	
	/**
	 * This is to add a coordinator-role to a parent.
	 * 
	 * Pre-cond: the parent should exist.
	 */
	public void promoteToCoordinator(String emailParent) {}

	/**
	 * This is to remove the coordinator-role from a parent.
	 * 
	 * Pre-cond: the parent should exist.
	 */
	public void demoteFromCoordinator(String emailCoordinator) {}
	
	/**
	 * This is to check if a parent is a coordinator.
	 * 
	 * Pre-cond: the parent should exist.
	 */
	public boolean isCoordinator(String emailUser) { return false; }


}
