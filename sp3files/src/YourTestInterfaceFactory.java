/**
 * This class is responsible for producing instances of 
 * SLMSTestInterface. We can't produce those instances 
 * directly because "SLMSTestInterface" is defined as a
 * Java "interface".
 * 
 * <p>You need to change the code of the single method below.
 * Don't change the type and name of the method.
 *
 */
public class YourTestInterfaceFactory {

	/**
	 * This will create an instance of SLMSTestInterface.
	 * Modify its body.
	 */
	static SLMSTestInterface getSLMSTestInterface() {
		
		// Modify the line below. Suppose that the class "TI"
		// is *your* implementation of SLMSTestInterface,
		// you need to create an instance of this TI, and
		// return it.
		
		return new SLMSTI() ;
	}
}
