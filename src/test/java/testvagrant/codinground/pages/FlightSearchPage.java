package testvagrant.codinground.pages;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightSearchPage {
	
	private WebDriver driver;
	
	public FlightSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	String fromCity = "Bangalore, IN - Kempegowda International Airport (BLR)";
	String toCity = "New Delhi, IN - Indira Gandhi Airport (DEL)";
	String dateOfJourney = "Fri, 28 Dec, 2018";
	
	@FindBy(how=How.XPATH,using="//*[@id='SearchForm']//*[@id='OneWay']")
	WebElement oneWayRadioButton;

	@FindBy(how=How.ID,using="FromTag")
	WebElement fromCityTextBox;
	
	@FindBy(how=How.ID,using="ToTag")
	WebElement toCityTextBox;
	
	@FindBy(how=How.XPATH,using="(//*[@id='SearchForm']/div[3]/section[2]//input)[1]")
	WebElement journeyDateBox;
	
	@FindBy(how=How.CSS,using="#SearchBtn")
	WebElement searchButton;
	
	@FindBy(how=How.XPATH,using="(//*[@id='modifySearchLink'])[2]")
	WebElement modifySearchBtn;
	
	
	/**
	 * Method to search the flights and to validate results are displayed
	 */
	public void validateFlightSearchResultsAreGettingDisplayed(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		FlightSearchPage flightsPage = PageFactory.initElements(driver, FlightSearchPage.class);
		wait.until(ExpectedConditions.visibilityOf(flightsPage.oneWayRadioButton)).click();
		wait.until(ExpectedConditions.visibilityOf(flightsPage.fromCityTextBox)).sendKeys(fromCity);
		log.info("From City Entered is: "+fromCity);
		wait.until(ExpectedConditions.visibilityOf(flightsPage.toCityTextBox)).sendKeys(toCity);
		log.info("To City Entered is: "+toCity);
		flightsPage.journeyDateBox.sendKeys(dateOfJourney);
		flightsPage.searchButton.click();
		wait.until(ExpectedConditions.visibilityOf(flightsPage.modifySearchBtn));
		assertEquals(flightsPage.modifySearchBtn.isDisplayed(), true);
		log.info("Flight Search results successfully displayed");
	}

}
