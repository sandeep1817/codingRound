package testvagrant.codinground.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignInPage {
	
	private WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}

	
	Logger log = LoggerFactory.getLogger(this.getClass());
	String userMail = "sandeepbasireddy45@gmail.com";
	String passwordOfUser = "xyz";
	String expectedMessage = "There were errors in your submission";
	String actualMessage;

	@FindBy(how=How.ID,using="userAccountLink")
	WebElement yourTrips;

	@FindBy(how=How.ID,using="SignIn")
	WebElement signInButton;
	
	@FindBy(how=How.ID,using="email")
	WebElement userName;
	
	@FindBy(how=How.CSS,using="#password")
	WebElement password;
	
	@FindBy(how=How.ID,using="signInButton")
	WebElement signInBtn;
	
	@FindBy(how=How.XPATH,using="//*[@id='Wrapper']//*[@class='errors']/span")
	WebElement errorMsg;
	
	@FindBy(how=How.XPATH,using="//*[@id='ModalFrame']/iframe")
	WebElement siginToClearTripFrame;
	
	
	/**
	 * @author Sandeep Reddy 
	 * Method to validate error message on cleartrip home page
	 */
	public void validateErrorMessageIsDisplayedWhileSigningIn(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		wait.until(ExpectedConditions.visibilityOf(signInPage.yourTrips)).click();
		wait.until(ExpectedConditions.visibilityOf(signInPage.signInButton)).click();
		try{
			driver.switchTo().frame(6);
		}
		catch(Exception e){
			driver.switchTo().activeElement();
			try{
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ModalFrame']/iframe")));
			}
			catch(Exception e1){
				
			}
		}
		wait.until(ExpectedConditions.visibilityOf(signInPage.userName)).sendKeys(userMail);
		wait.until(ExpectedConditions.visibilityOf(signInPage.password)).sendKeys(passwordOfUser);
		wait.until(ExpectedConditions.visibilityOf(signInPage.signInBtn)).click();
		actualMessage = wait.until(ExpectedConditions.visibilityOf(signInPage.errorMsg)).getText();
		log.info("Error Message Displayed On the Page is: "+actualMessage);
		assertEquals(actualMessage, expectedMessage);
	}
}
