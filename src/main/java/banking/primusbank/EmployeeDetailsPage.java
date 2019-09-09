package banking.primusbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetailsPage {
	
	// new employee button
	@FindBy(how = How.ID, using = "BtnNew")
	private WebElement newEmployee;
	
	private WebDriver driver;
	
	public EmployeeDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// click on new employee button
	public EmployeeCreationPage clickNewEmployee() {
		this.newEmployee.click();
		return PageFactory.initElements(driver, EmployeeCreationPage.class);
	}
	


}
