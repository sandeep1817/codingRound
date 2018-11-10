package testvagrant.codinground.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HotelBookingPage {
	
	@FindBy(how=How.XPATH,using="//*[@id='Home']//a[contains(@href,'hotels')]")
	WebElement hotelsLink;

	@FindBy(how=How.XPATH,using="(//*[@id='SearchForm']/section/div/dl/dd/span/input)[1]")
	WebElement cityTextboxForhotel;
	
	@FindBy(how=How.XPATH,using="//*[@id='SearchForm']//input[contains(@title,'Check-in date')]")
	WebElement checkInDateForHotel;
	
	@FindBy(how=How.XPATH,using="//*[@id='SearchForm']//input[contains(@title,'Check-out date')]")
	WebElement checkOutDateForHotel;
	
	@FindBy(how=How.ID,using="SearchHotelsButton")
	WebElement searchHotelsButton;
	
}
