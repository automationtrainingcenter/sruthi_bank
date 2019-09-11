package banking.primusbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utitlities.BrowserHelper;
import utitlities.GenericHelper;

public class TestExecution extends BrowserHelper{
	BankHomePage bankHomePage;
	private AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	private RoleCreationPage roleCreationPage;
	BranchDetailsPage branchDetailsPage;
	BranchCreationPage branchCreationPage;
	EmployeeDetailsPage employeeDetailsPage;
	EmployeeCreationPage employeeCreationPage;

	Alert alert;
	
	@Test(priority=0, alwaysRun=true, groups = {"role" , "create_valid", "create", "reset", "cancel", "blank", "branch", "employee", "employeeDP", "roleDP"})
	public void adminLogin() {
		bankHomePage = new BankHomePage(driver);
		bankHomePage.fillUserName(GenericHelper.readProperty("resources", "config.properties", "admin_user"));
		bankHomePage.fillPassword(GenericHelper.readProperty("resources", "config.properties", "admin_pass"));
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isLogoutLinkDisplayed());
	}
	
	@Test(priority=1, groups = {"role" , "create_valid"})
	public void roleCreationWithValidData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName(TestData.roleName_valid);
		roleCreationPage.selectRoleType(TestData.roleType);
		Alert alert = roleCreationPage.clickSubmit();
		String text = alert.getText();
		alert.accept();
		Reporter.log("alert came "+text);
		Assert.assertTrue(text.toLowerCase().contains("new role"));
	}
	
	@Test(priority = 2, dependsOnMethods= {"roleCreationWithValidData"}, groups = {"role" , "create"})
	public void roleCreationWithDuplicateData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName(TestData.roleName_valid);
		roleCreationPage.selectRoleType(TestData.roleType);
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Reporter.log("alert came "+alertText);
		Assert.assertTrue(alertText.toLowerCase().contains("already Exist"));
	}

	@Test(priority = 3, groups = {"role" , "blank"})
	public void roleCreationWithBlankData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following"));
	}
	
	@Test(priority = 4, groups = {"role" , "reset"})
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		roleCreationPage.clickReset();
	}
	
	@Test(priority = 5, groups = {"role" , "cancel"})
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleDetailsPage = roleCreationPage.clickCancel();
	}

	@Test(priority = 6, groups = {"branch" , "create_valid"})
	public void branchCreationWithValidData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchCreationPage.fillbranchName("newBranchNMO");
		branchCreationPage.fillAdress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectcountry("INDIA");
		branchCreationPage.selectstate("Andhra Pradesh");
		branchCreationPage.selectcity("Hyderabad");
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));

	}

	@Test(priority = 7, groups = {"branch" , "create"})
	public void branchCreationDuplicateDate() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchCreationPage.fillbranchName("newBranchNMO");
		branchCreationPage.fillAdress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectcountry("INDIA");
		branchCreationPage.selectstate("Andhra Pradesh");
		branchCreationPage.selectcity("Hyderabad");
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}
	
	@Test(priority = 8, groups = {"branch" , "blank"})
	public void branchCreationBlankData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following"));
	}

	@Test(priority = 9, groups = {"branch" , "reset"})
	public void branchCreationReset() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchCreationPage.fillbranchName("newBranchN");
		branchCreationPage.fillAdress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectcountry("INDIA");
		branchCreationPage.selectstate("Andhra Pradesh");
		branchCreationPage.selectcity("Hyderabad");
		branchCreationPage.clickReset();

	}

	@Test(priority = 10, groups = {"branch" , "cancel"})
	public void branchCreationCancel() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchDetailsPage = branchCreationPage.clickCancel();

	}

	@Test(priority = 11, groups = {"employee" , "create_valid"})
	public void employeeCreationWithValidData() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName("sunshinessts");
		employeeCreationPage.fillLoginPassword("12345");
		employeeCreationPage.selectRole("Manager");
		employeeCreationPage.selectBranch("Hyderabad");
		alert = employeeCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));
	}

	@Test(priority = 12, groups = {"employee" , "create"})
	public void employeeCreationWithDuplicateData() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName("sunshinessts");
		employeeCreationPage.fillLoginPassword("12345");
		employeeCreationPage.selectRole("Manager");
		employeeCreationPage.selectBranch("Hyderabad");
		alert = employeeCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}

	@Test(priority = 13, groups = {"employee" , "blank"})
	public void employeeCreationBlankData() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		alert = employeeCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following fields"));
	}

	@Test(priority = 14, groups = {"employee" , "reset"})
	public void employeeCreationWithReset() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName("sunshine");
		employeeCreationPage.fillLoginPassword("12345");
		employeeCreationPage.selectRole("bankerONE");
		employeeCreationPage.selectBranch("hyderabad");
		employeeCreationPage.clickReset();

	}

	@Test(priority = 15, groups = {"employee" , "cancel"})
	public void employeeCreationCancel() {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeDetailsPage = employeeCreationPage.clickCancel();

	}
	
	@Test(priority = 16, groups = {"employee" , "employeeDP"}, dataProviderClass=DataProviderHelper.class, dataProvider="employeeDP")
	public void employeeCreationResetWithDP(String empName, String loginPass, String roleName, String branchName) throws InterruptedException {
		employeeDetailsPage = adminHomePage.clickEmployee();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName(empName);
		employeeCreationPage.fillLoginPassword(loginPass);
		employeeCreationPage.selectRole(roleName);
		employeeCreationPage.selectBranch(branchName);
		employeeCreationPage.clickReset();
		Thread.sleep(2000);
	}
	
	@Test(priority = 17, groups = {"role" , "roleDP"}, dataProviderClass=DataProviderHelper.class, dataProvider="roleDP")
	public void roleCreationResetWithDP(String roleName, String roleType) {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName(roleName);
		roleCreationPage.selectRoleType(roleType);
		roleCreationPage.clickReset();
	}

	@Test(priority = 20, groups = {"role" , "create_valid", "create", "reset", "cancel", "blank", "branch", "employee", "employeeDP", "roleDP"})
	public void logout() {
		bankHomePage = adminHomePage.clickLogout();

	}
}
