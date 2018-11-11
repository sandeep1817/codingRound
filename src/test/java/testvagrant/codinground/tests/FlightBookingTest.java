package testvagrant.codinground.tests;
import org.testng.annotations.Test;
import testvagrant.codinground.commonclasses.GenericMethods;
import testvagrant.codinground.pages.FlightSearchPage;

public class FlightBookingTest extends GenericMethods{
	
	/**
	 * Method to search flights
	 */
	@Test
	public void validateThatFlightSearchResultsDisplayed(){
		FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
		flightSearchPage.validateFlightSearchResultsAreGettingDisplayed();
	 }
}
