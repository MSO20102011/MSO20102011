import org.junit.*;
import static junit.framework.Assert.*  ;
import utils.* ;

/**
 * Testing the dynamic adding and removal of a parent-role
 * to a teacher. 
 * 
 * <p>DO NOT CHANGE this class.
 */
public class Test2 extends SetupTestPopulation0 {

	
	
	// a new pupil
	String DUFFY = "Duffy Duck" ;
	public Test2() { super() ; }
	
	@Test
	public void tc1() {
		System.out.print("Testing adding a parent-role to a teacher ... ") ;
		setup() ;
		testInterface.addPupil(DUFFY,C1B) ;
		assertTrue(testInterface.isPupilOf(DUFFY, C1B)) ;
		testInterface.addParentRoleToTeacher(CRAB) ;
		testInterface.addChild(CRAB, DUFFY) ;
		assertTrue(testInterface.isChildOf(DUFFY,CRAB)) ;
		assertTrue(! testInterface.isChildOf(DUFFY,BOB)) ;
		assertTrue(! testInterface.isChildOf(TIC,CRAB)) ;
		assertTrue(testInterface.isTeacherOf(CRAB, C1B)) ;
		System.out.println("passed.") ;
	}
	
	@Test
	public void tc2() {
		System.out.print("Testing adding, then removing a parent-role to a teacher ... ") ;
		setup() ;
		testInterface.addPupil(DUFFY,C1B) ;
		// make mr crab a parent, then add duffy as his child
		testInterface.addParentRoleToTeacher(CRAB) ;
		testInterface.addChild(CRAB, DUFFY) ;
		assertTrue(testInterface.isChildOf(DUFFY,CRAB)) ;
		// now remove parent role from mr crab:
		testInterface.removeParentRoleFromTeacher(CRAB) ;
		assertTrue(! testInterface.isChildOf(DUFFY,CRAB)) ;
		System.out.println("passed.") ;
	}
	
	/**
	 * To run all tests without JUnit runner. You don't need this
	 * if you use JUnit runner.
	 */
	public static void main(String[] args) {
		new Test2().tc1() ;
		new Test2().tc2() ;
	}
}
