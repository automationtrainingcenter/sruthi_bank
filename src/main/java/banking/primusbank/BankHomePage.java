package banking.primusbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankHomePage {

	WebDriver driver;

	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// username
	public WebElement username() {
//		WebElement uname = driver.findElement(By.id(""));
//		return uname;
		return driver.findElement(By.id("txtuId"));
	}

	// password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}

	// login button
	public WebElement login() {
		return driver.findElement(By.id("login"));
	}

	// fill the User name
	public void fillUserName(String username) {
		this.username().sendKeys(username);
	}

	// fill the password
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}

	// click on login button
	public void clickLogin() {
		this.login().click();
	}
}
