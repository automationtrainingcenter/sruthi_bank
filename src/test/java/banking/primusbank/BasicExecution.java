package banking.primusbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utitlities.BrowserHelper;
import utitlities.GenericHelper;

public class BasicExecution extends TestExecution{
	@BeforeClass
	public void browserLaunch() {
		BrowserHelper.openBrowser("chrome", GenericHelper.readProperty("resources", "config.properties", "ur"));
	}
	
	@AfterClass
	public void closeBrowser() {
		BrowserHelper.closeBrowser();
	}
}
