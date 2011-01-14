import utils.* ;

/**
 * This class is used to setup your SLMS to some initial 
 * population, which we will use to test your SLMS. 
 * DO NOT CHANGE this class. If you need a different
 * population you have to create your own class.
 *
 */
public class SetupTestPopulation0 {

	public SetupTestPopulation0() { }
	
	SLMSTestInterface testInterface ;
	
	// The parents :
	String BOB = "bob@gmail.com" ;
	String PAT = "patrick@gmail.com" ;
	String OCTO = "octo@gmail.com" ;
	
	// Children :
	String TIC = "Tic" ;
	String TAC = "Tac" ;
	String TOE = "Toe" ;

	// The teachers :
	String SANDY = "sandy@gmail.com" ;
	String CRAB = "mr.crab@gmail.com" ;
	
	// Classes :
	String C1A = "C1A" ; // class 1-a, teacher is sandy
	String C1B = "C1B" ; // class 1-b, teacher is mr crab
	
	// will hold dates 1 - 31 jan 2011
	SimpleDate[] dates ;

	/**
	 * This will setup your SLMS to hold the test configuration.
	 * E.g. this will add parents, childred, etc.
	 */
	void setup() {
		testInterface = YourTestInterfaceFactory.getSLMSTestInterface() ;
		testInterface.resetSLMS() ;	
		populating() ;
		fillingDatesOfJan2011() ;
		addingLunchDates() ;
		addingParentsDatesPrefs() ;	
		addingNoLunchDates() ;
	}
	
	private void populating(){
		testInterface.addClass(C1A) ;
		testInterface.addClass(C1B) ;
		testInterface.addTeacher("Sandy", SANDY, "hahaha") ;
		testInterface.addTeacher("Mr Crab", CRAB, "hahaha") ;
		//assertTrue(testInterface.userExists(SANDY)) ;
		testInterface.assignTeacher(SANDY, C1A) ;
		testInterface.assignTeacher(CRAB, C1B) ;
		testInterface.addPupil(TIC, C1A) ;
		testInterface.addPupil(TAC, C1A) ;
		testInterface.addPupil(TOE, C1B) ;
		testInterface.addParent("Bob Sponge", BOB, "bob123") ;
		testInterface.addParent("Patrick Star", PAT, "pat123") ;
		testInterface.addParent("Octo", OCTO, "blabla") ;
		testInterface.addChild(BOB, TIC) ;
		testInterface.addChild(BOB, TAC) ;
		testInterface.addChild(PAT, TOE) ;
	}
	
	private void fillingDatesOfJan2011() {
		dates = new SimpleDate[32] ;
		// note that index-0 is not used!
		// so, date[i] corresponds to i-jan-2011
		for (int i=1; i<=31; i++) dates[i] = new SimpleDate(i,1,2011) ;
	}
	
	private void addingLunchDates() {
		// tic stays every day
		int[] ticDates = { 3,4,5,6,7,
		                  10,11,12,13,14,
		                  17,18,19,20,21,
		                  24,25,26,27,28,
		                  31 } ;
		
		// tac stays every monday
		int[] tacDates = { 3,10,17,24,31 } ;
		
		// toe stays is some arbitrary dates
		int[] toeDates ={ 3,4,6,7,
		                  12,
		                  18,21,
		                  24,25,26,27,28 } ;
		
		for (int k=0; k<ticDates.length; k++) 
			testInterface.addLunchDate(BOB, TIC, dates[ticDates[k]]) ;
		
		for (int k=0; k<tacDates.length; k++) 
			testInterface.addLunchDate(BOB, TAC, dates[tacDates[k]]) ;

		for (int k=0; k<toeDates.length; k++) 
			testInterface.addLunchDate(PAT, TOE, dates[toeDates[k]]) ;
	}
	
	private void addingParentsDatesPrefs() {
		// Octo is unavailable on tue-fri
		int[] octoUnavailDates = { 4,7, 
				11,14, 
				18,21, 
				25,28 } ;
		
		// Bob prefers monday, unavailable on friday
		int[] bobPrefDates = { 3,10,17,24,31 } ;
		int[] bobUnavailDates = { 7, 14, 21, 28 } ;
		
		// Patrick is always available
		
		for (int k=0;k<octoUnavailDates.length; k++)
			testInterface.addUnavailableDate(OCTO,dates[octoUnavailDates[k]]) ;
		
		for (int k=0;k<bobUnavailDates.length; k++)
			testInterface.addUnavailableDate(BOB,dates[bobUnavailDates[k]]) ;

		for (int k=0;k<bobPrefDates.length; k++)
			testInterface.addPreferDate(BOB,dates[bobPrefDates[k]]) ;
	}
	
	private void addingNoLunchDates(){
		// C1A has no lunch on 31st jan
		testInterface.addNoLunchDate(SANDY, dates[31]) ;
		// C1B has no lunch on 3rd jan
		testInterface.addNoLunchDate(CRAB, dates[3]) ;
	}
	
}
