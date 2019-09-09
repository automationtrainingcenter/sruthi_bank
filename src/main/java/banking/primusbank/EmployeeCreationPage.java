package banking.primusbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {

	// employer name
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement empName;

	// login password
	@FindBy(how = How.ID, using = "txtLpwd")
	private WebElement loginPass;

	// role name
	@FindBy(how = How.ID, using = "lst_Roles")
	private WebElement role;

	// branch name
	@FindBy(how = How.ID, using = "lst_Branch")
	private WebElement branch;

	// submit button
	@FindBy(how = How.ID, using = "BtnSubmit")
	private WebElement submit;

	// reset button
	@FindBy(how = How.ID, using = "btnreset")
	private WebElement reset;

	// cancel button
	@FindBy(how = How.ID, using = "btnCancel")
	private WebElement cancel;
	
	private WebDriver driver;
	
	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//fill emp name
	public void fillEmployerName(String employerName) {
		this.empName.sendKeys(employerName);
	}
	
	//fill login pass
	public void fillLoginPassword(String password) {
		this.loginPass.sendKeys(password);
	}
	
	
	//select role
	public void selectRole(String roleName) {
		Select roleSelect = new Select(this.role);
		roleSelect.selectByVisibleText(roleName);
	}

	//select branch
	public void selectBranch(String branchName) {
		Select branchSelect = new Select(this.branch);
		branchSelect.selectByVisibleText(branchName);
	}
	
	
	// click on submit button
	public Alert clickSubmit() {
		this.submit.click();
		return driver.switchTo().alert();
	}
	
	// click on reset button
	public void clickReset() {
		this.reset.click();
	}
	
	
	// click on cancel button
	public EmployeeDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);
		
	}
	
}
