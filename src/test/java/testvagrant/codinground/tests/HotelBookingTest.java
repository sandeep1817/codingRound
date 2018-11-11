package testvagrant.codinground.tests;
import org.testng.annotations.Test;

import testvagrant.codinground.commonclasses.GenericMethods;
import testvagrant.codinground.pages.HotelSearchPage;

public class HotelBookingTest extends GenericMethods{
		
		/**
		 * Method to search the hotels
		 */
	 	@Test
	    public void shouldBeAbleToSearchForHotels() {
	    	    	HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
	    	    	hotelSearchPage.searchHotels();
	  }
}
