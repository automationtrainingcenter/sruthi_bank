package banking.primusbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utitlities.GenericHelper;

public class TestExecution {
	WebDriver driver;
	BankHomePage bankHomePage;
	private AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	private RoleCreationPage roleCreationPage;
	
	@Test(priority=0, alwaysRun=true)
	public void adminLogin() {
		bankHomePage = new BankHomePage(driver);
		bankHomePage.fillUserName(GenericHelper.readProperty("resources", "config.properties", "admin_user"));
		bankHomePage.fillPassword(GenericHelper.readProperty("resources", "config.properties", "admin_pass"));
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isLogoutLinkDisplayed());
	}
	
	@Test(priority=1)
	public void roleCreationWithValidData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName(TestData.roleName_valid);
		roleCreationPage.selectRoleType(TestData.roleType);
		Alert alert = roleCreationPage.clickSubmit();
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.toLowerCase().contains("new role"));
	}
	
	@Test(priority=2)
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName(TestData.roleName_valid);
		roleCreationPage.selectRoleType(TestData.roleType);
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isFormReset());
	}
}
