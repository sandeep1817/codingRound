package testvagrant.codinground.tests;
import org.testng.annotations.Test;
import testvagrant.codinground.commonclasses.GenericMethods;
import testvagrant.codinground.pages.SignInPage;

public class SignInTest extends GenericMethods{
	
	/**
	 * Method to validate error message on Cleartrip when credentials are wrong
	 * 
	 */
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	SignInPage signInInPage = new SignInPage(driver);
    	signInInPage.validateErrorMessageIsDisplayedWhileSigningIn();
    }
}
