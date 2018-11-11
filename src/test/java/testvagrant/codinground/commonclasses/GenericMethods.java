package testvagrant.codinground.commonclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.sun.javafx.PlatformUtil;

public class GenericMethods {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	public WebDriver driver ;
	final String clearTripUrl = "https://www.cleartrip.com/";
	
	/**
	 * @author Sandeep Reddy
	 * Method to kill browser instances and Driver instances before starting test
	 * @throws InterruptedException 
	 */
	@BeforeTest(alwaysRun=true)
	public void killTheBrowserAndDriverInstances() throws InterruptedException{
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		} catch (IOException e) {
			log.info("No Browser Instances Found");
		}
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			log.info("No Driver Instances Found");
		}
		setDriverPath();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		launchClearTrip();
	}
	
	public void launchClearTrip() {
		driver.get(clearTripUrl);
	}

	public void setDriverPath() {
		
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
	
	@AfterTest(alwaysRun = true)
	public void killTheBrowserInstances(){
		try{
		driver.quit();
		}
		catch(Exception e){
			log.info("No Browser Instances Found");
		}
	}
	
}
