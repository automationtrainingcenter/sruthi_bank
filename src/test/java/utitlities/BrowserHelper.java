package utitlities;
/*
 * this class provides helper methods to launch browser based on browser name
 * and also to close the browser
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserHelper {
	public static WebDriver driver;
	
	//open browser method
	public static void openBrowser(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", GenericHelper.getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", GenericHelper.getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		}else {
			throw new RuntimeException("invalid browser....Browser name must be either chrome or firefox");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	//close browser
	public static void closeBrowser() {
		if(driver.getWindowHandles().size() > 1) {
			driver.quit();
		}else {
			driver.close();
		}
	}
	
	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void selectOption(WebElement selectEle, String visibleText) {
		Select selectElement = new Select(selectEle);
		boolean status = true;
		List<WebElement> options = selectElement.getOptions();
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase(visibleText)) {
				option.click();
				status = false;
				break;
			}
		}
		if(status) {
			System.out.println("there is no option with visible text "+visibleText);
		}
	}
}
