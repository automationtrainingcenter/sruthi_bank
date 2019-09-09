package banking.primusbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// PAGE FACTORY
public class AdminHomePage {
	private WebDriver driver;

	// home
	@FindBy(css = "a[href='adminflow.aspx']")
	private WebElement home;

	// logout
	@FindBy(how = How.CSS, using = "a[href='http://primusbank.qedgetech.com']")
	private WebElement logout;

	// branches
	@FindBy(how = How.CSS, using = "a[href='admin_banker_master.aspx']")
	private WebElement branches;

	// roles
	@FindBy(how = How.CSS, using = "a[href='Admin_Roles_details.aspx']")
	private WebElement roles;

	// employee
	@FindBy(how = How.CSS, using = "a[href='Admin_Emp_details.aspx']")
	private WebElement employee;
	
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// click on home
	public AdminHomePage clickHome() {
		this.home.click();
		return PageFactory.initElements(driver, AdminHomePage.class);
	}
	
	
	// click logout button
	public BankHomePage clickLogout() {
		this.logout.click();
		return PageFactory.initElements(driver, BankHomePage.class);
	}
	
	// click branches button returns BranchDetailsPage
	public BranchDetailsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}
	
	
	//click roles button returns RoleDetailsPage
	public RoleDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}
	
	// click empoloyee button returns EmployeeDetailsPage
	public EmployeeDetailsPage clickEmployee() {
		this.employee.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);
	}
	
	
	// verify logout link is displayed or not
	public boolean isLogoutLinkDisplayed() {
		return this.logout.isDisplayed();
	}

}
