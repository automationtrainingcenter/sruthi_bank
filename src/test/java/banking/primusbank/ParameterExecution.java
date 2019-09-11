package banking.primusbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution {

	@BeforeClass(groups = { "role", "create_valid", "create", "reset", "cancel", "blank", "branch", "employee",
			"employeeDP", "roleDP" })
	@Parameters({ "url", "browserName" })
	public void browserLaunch(String url, String browserName) {
		openBrowser(browserName, url);
	}

	@AfterClass(groups = { "role", "create_valid", "create", "reset", "cancel", "blank", "branch", "employee",
			"employeeDP", "roleDP" })
	public void browserClose() {
		closeBrowser();
	}
}
