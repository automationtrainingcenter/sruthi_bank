package utitlities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScripHelper {
	
	//get the text of a text field or text area
	public static String getTextBoxValue(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].value", element).toString();
	}
	
	// to bring an element into the view
	public static void getElementToView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	// to scroll a page with given values
	public static void scrollPageBy(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", x, y);
	}

}
