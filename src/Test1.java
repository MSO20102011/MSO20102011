import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 * Test that a parent should not be able to add lunches to
 * children who are not her own.
 * 
 * <p>DO NOT CHANGE this class.
 */
public class Test1 extends SetupTestPopulation0 {

	public Test1() { super() ; }
	
	@Test
	public void tc1() {
		System.out.print("Parent should not be able to add lunches to child that is not her own  ... ") ;
		setup() ;
		assertTrue(! testInterface.hasLunch(TOE, dates[31])) ;
		try {
			testInterface.addLunchDate(BOB, TOE, dates[31]) ;
		}
		catch (Exception e) { } ;
		assertTrue(! testInterface.hasLunch(TOE, dates[31])) ;
		System.out.println("passed.") ;
	}
	
	/**
	 * To run all tests without JUnit runner. You don't need this
	 * if you use JUnit runner.
	 */
	public static void main(String[] args) {
		new Test1().tc1() ;
	}

	
}
