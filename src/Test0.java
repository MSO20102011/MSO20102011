import org.junit.*;
import static junit.framework.Assert.*  ;
import utils.* ;

/**
 * This test class checks some basic functionalities of
 * your SLMS like adding parent, class, child, lunch date, etc.
 * 
 * <p>The superclass SetupTestPopulation0 will do the setting
 * up of the initial population of your SLMS. DO NOT CHANGE 
 * this class if you want to make your own tests. We use 
 * this same test class to test your SLMS.
 * 
 * <p>If you want to write your own test class, you may want
 * to subclass SetupTestPopulation0; this way you can inherit 
 * its setup method, that sets the initial population of 
 * your SLMS.
 *
 */
public class Test0 extends SetupTestPopulation0 {
	
	public Test0() { super() ; }
			
	@Test
	public void tc1() {
		System.out.print("Checking parents ... ") ;
		setup() ;
		assertTrue(testInterface.userExists(BOB)) ;
		assertTrue(testInterface.userExists(PAT)) ;
		assertTrue(! testInterface.userExists("xxx@gmail.com")) ;
		System.out.println("passed.") ;
	}
	
	@Test
	public void tc2() {
		System.out.print("Checking teachers ... ") ;
		setup() ;
		assertTrue(testInterface.userExists(SANDY)) ;
		assertTrue(testInterface.userExists(CRAB)) ;
		assertTrue(testInterface.isTeacherOf(SANDY, C1A)) ;
		assertTrue(testInterface.isTeacherOf(CRAB, C1B)) ;
		assertTrue(! testInterface.isTeacherOf(BOB, C1A)) ;
		System.out.println("passed.") ;
	}
	
	@Test
	public void tc3() {
		System.out.print("Checking children ... ") ;
		setup() ;
		assertTrue(testInterface.isChildOf(TIC,BOB)) ;
		assertTrue(testInterface.isChildOf(TAC,BOB)) ;
		assertTrue(testInterface.isChildOf(TOE,PAT)) ;
		assertTrue(! testInterface.isChildOf(TIC,OCTO)) ;
		assertTrue(testInterface.isPupilOf(TIC,C1A)) ;
		assertTrue(testInterface.isPupilOf(TAC,C1A)) ;
		assertTrue(testInterface.isPupilOf(TOE,C1B)) ;
		assertTrue(! testInterface.isPupilOf(TOE,C1A)) ;
		System.out.println("passed.") ;
	}
	
	@Test
	public void tc4() {
		System.out.print("Checking lunch dates ... ") ;
		setup() ;
		assertTrue(testInterface.hasLunch(TIC,dates[3])) ;
		assertTrue(testInterface.hasLunch(TIC,dates[31])) ;
		assertTrue(testInterface.hasLunch(TAC,dates[3])) ;
		assertTrue(! testInterface.hasLunch(TAC,dates[4])) ;
		assertTrue(testInterface.hasLunch(TOE,dates[3])) ;
		assertTrue(! testInterface.hasLunch(TOE,dates[31])) ;
		System.out.println("passed.") ;
	}
	
	
	@Test
	public void tc5() {
		System.out.print("Checking parents' availabilities ... ") ;
		setup() ;
		assertTrue(testInterface.isAvailable(PAT, dates[3])) ;
		assertTrue(testInterface.isAvailable(PAT, dates[7])) ;
		assertTrue(testInterface.isAvailable(PAT, dates[31])) ;
		assertTrue(! testInterface.isPreferred(PAT, dates[31])) ;
		assertTrue(! testInterface.isUnavailable(PAT, dates[27])) ;

		assertTrue(testInterface.isAvailable(BOB, dates[3])) ;
		assertTrue(testInterface.isPreferred(BOB, dates[3])) ;
		assertTrue(! testInterface.isUnavailable(BOB, dates[3])) ;
		assertTrue(! testInterface.isAvailable(BOB, dates[28])) ;
		assertTrue(! testInterface.isPreferred(BOB, dates[28])) ;
		assertTrue(testInterface.isUnavailable(BOB, dates[28])) ;
		
		System.out.println("passed.") ;
	}
	
	@Test
	public void tc6() {
		System.out.print("Checking no-lunch dates ... ") ;
		setup() ;
		assertTrue(testInterface.hasNoLunch(C1A,dates[31])) ;
		assertTrue(! testInterface.hasNoLunch(C1A,dates[3])) ;
		assertTrue(! testInterface.hasNoLunch(C1B,dates[31])) ;
		assertTrue(testInterface.hasNoLunch(C1B,dates[3])) ;
		System.out.println("passed.") ;
	}
	
	/**
	 * To run all tests without JUnit runner. You don't need this
	 * if you use JUnit runner.
	 */
	public static void main(String[] args) {
		new Test0().tc1() ;
		new Test0().tc2() ;
		new Test0().tc3() ;
		new Test0().tc4() ;
		new Test0().tc5() ;
		new Test0().tc6() ;
	}
	
}
