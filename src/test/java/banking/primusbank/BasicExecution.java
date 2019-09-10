package banking.primusbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utitlities.BrowserHelper;
import utitlities.GenericHelper;

public class BasicExecution extends TestExecution{
	@BeforeClass(groups = {"role" , "create_valid", "create", "reset", "cancel", "blank", "branch", "employee", "employeeDP", "roleDP"})
	public void browserLaunch() {
		openBrowser("chrome", GenericHelper.readProperty("resources", "config.properties", "url"));
	}
	
	@AfterClass(groups = {"role" , "create_valid", "create", "reset", "cancel", "blank", "branch", "employee", "employeeDP", "roleDP"})
	public void browserClose() {
		closeBrowser();
	}
}
