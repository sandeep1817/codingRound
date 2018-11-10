package testvagrant.codinground.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightBookingPage {
	
	@FindBy(how=How.XPATH,using="//*[@id='SearchForm']//*[@id='OneWay']")
	WebElement oneWayRadioButton;

	@FindBy(how=How.ID,using="FromTag")
	WebElement fromCityTextBox;
	
	@FindBy(how=How.ID,using="ToTag")
	WebElement toCityTextBox;
	
	@FindBy(how=How.XPATH,using="(//*[@id='SearchForm']//section[2]/div//input)[1]")
	WebElement journeyDateBox;
	
	@FindBy(how=How.ID,using="//*[@id='SearchBtn']")
	WebElement searchButton;

}
