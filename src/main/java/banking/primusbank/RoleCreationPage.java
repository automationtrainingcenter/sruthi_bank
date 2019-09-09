package banking.primusbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {
	
	// role name
	@FindBy(how = How.ID, using = "txtRname")
	private WebElement roleName;
	
	// role type
	@FindBy(how = How.ID, using = "lstRtypeN")
	private WebElement roleType;
	
	// submit
	@FindBy(how = How.ID, using = "btninsert")
	private WebElement submit;
	
	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;
	
	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	private WebDriver driver;
	
	public RoleCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillRoleName(String roleName) {
		this.roleName.sendKeys(roleName);
	}
	
	public void selectRoleType(String roleType) {
		Select sel = new Select(this.roleType);
		sel.selectByVisibleText(roleType);
	}
	
	public Alert clickSubmit() {
		this.submit.click();
		return driver.switchTo().alert();
	}
	
	public void clickReset() {
		this.reset.click();
	}
	
	public RoleDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}
	
	public boolean isFormReset() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String roleNameValue = js.executeScript("return arguments[0].value", this.roleName).toString();
		return roleNameValue.isEmpty();
	}

}
