package testvagrant.codinground.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage {
	
	@FindBy(how=How.ID,using="userAccountLink")
	WebElement yourTrips;

	@FindBy(how=How.ID,using="SignIn")
	WebElement signInButton;
	
}
