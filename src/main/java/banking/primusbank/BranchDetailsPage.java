package banking.primusbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchDetailsPage {
	WebDriver driver;

	@FindBy(id = "BtnNewBR")
	private WebElement newbranch;

	public BranchDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BranchCreationPage clickNewbranch() {
		this.newbranch.click();
		return PageFactory.initElements(driver, BranchCreationPage.class);
	}
	
	public boolean isPageDisplayed() {
		return this.newbranch.isDisplayed();
	}

}
