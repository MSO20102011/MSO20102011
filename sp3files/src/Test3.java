import static junit.framework.Assert.* ;
import org.junit.*;
import utils.* ;

/**
 * For testing the cost calculation schemes.
 * 
 * <p>DO NOT CHANGE this class.
 */
public class Test3 extends SetupTestPopulation0 {
	
	public Test3() { super() ; }
	
	@Test
	public void tc1() {
		System.out.print("Testing standard cost scheme (assumed to be the default) ... ") ;
		setup() ;
		//System.out.println(">> " + testInterface.calculateCost(TIC, 2011)) ;
		assertTrue(testInterface.calculateCost(TIC, 2011) == 20*150) ;
		assertTrue(testInterface.calculateCost(TAC, 2011) == 4*150) ;
		assertTrue(testInterface.calculateCost(TOE, 2011) == 11*150) ;
		System.out.println("passed.") ;
	}
	
	@Test
	public void tc2() {
		System.out.print("Testing pay-afront cost scheme ... ") ;
		setup() ;
		testInterface.setToPayAfrontCostScheme(BOB, TIC) ;
		assertTrue(testInterface.calculateCost(TIC, 2011) == 0) ;
	
		testInterface.addLunchDate(BOB,TIC, new SimpleDate(1,2,2011)) ;
		testInterface.addLunchDate(BOB,TIC, new SimpleDate(2,2,2011)) ;

		assertTrue(testInterface.calculateCost(TIC, 2011) == 2*250) ;
		
		System.out.println("passed.") ;
	}
	
	@Test
	public void tc3() {
		System.out.print("Only a child's parent can set his cost scheme ... ") ;
		setup() ;
		try {
			testInterface.setToPayAfrontCostScheme(PAT, TIC) ;
		}
		catch (Exception e) { }
		assertTrue(testInterface.calculateCost(TIC, 2011) == 20*150) ;
		
		System.out.println("passed.") ;
	}	
	
	/**
	 * To run all tests without JUnit runner. You don't need this
	 * if you use JUnit runner.
	 */
	public static void main(String[] args) {
		new Test3().tc1() ;
		new Test3().tc2() ;
		new Test3().tc3() ;
	}
}
