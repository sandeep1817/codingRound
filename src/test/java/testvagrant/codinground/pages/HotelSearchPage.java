package testvagrant.codinground.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HotelSearchPage {
	
	private WebDriver driver;
	
	public HotelSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	String locationToSearchHotel = "Indiranagar";
	
	@FindBy(how=How.XPATH,using="//*[@id='Home']//a[contains(@href,'hotels')]")
	WebElement hotelsLink;

	@FindBy(how=How.XPATH,using="(//*[@id='SearchForm']/section/div/dl/dd/span/input)[1]")
	WebElement cityTextboxForhotel;
	
	@FindBy(how=How.XPATH,using="//*[@class='autoComplete']/li//a[text()='Indiranagar, Bangalore, Karnataka, India']")
	WebElement selectLocationDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id='SearchForm']//input[contains(@title,'Check-in date')]")
	WebElement checkInDateForHotelTxtBox;
	
	@FindBy(how=How.XPATH,using="(//*[@id='ui-datepicker-div']/div[2]//tbody/tr[4]/td)[1]")
	WebElement clickOnDate;
	
	@FindBy(how=How.XPATH,using="//*[@id='SearchForm']//input[contains(@title,'Check-out date')]")
	WebElement checkOutDateForHotelTxtBox;
	
	@FindBy(how=How.ID,using="SearchHotelsButton")
	WebElement searchHotelsButton;
	
	/**
	 * @author Sandeep Reddy
	 * Method to search Hotels
	 */
	public void searchHotels(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		HotelSearchPage hotelsPage = PageFactory.initElements(driver, HotelSearchPage.class);
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.hotelsLink)).click();
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.cityTextboxForhotel)).sendKeys(locationToSearchHotel);
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.selectLocationDropDown)).click();
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.checkInDateForHotelTxtBox)).click();
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.clickOnDate)).click();
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.checkOutDateForHotelTxtBox)).click();
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.clickOnDate)).click();
		wait.until(ExpectedConditions.visibilityOf(hotelsPage.searchHotelsButton)).click();
	}
}
