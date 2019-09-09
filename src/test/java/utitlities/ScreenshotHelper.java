package utitlities;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper extends GenericHelper{
	
	/**
	 * take screenshot using selenium approach. This method
	 * accepts WebDriver reference, folder name and file name without 
	 * any extension. The screenshot will store with .png extension
	 * @param driver
	 * @param folderName
	 * @param fileName
	 */
	public static String takeScreenShot(WebDriver driver, String folderName, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		try {
			File destImg = new File(getFilePath(folderName, fileName+getTime()+".png"));
			BufferedImage bi = ImageIO.read((srcImg));
			ImageIO.write(bi, "png", destImg);
			return destImg.getAbsolutePath();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	/**
	 * This method accepts folder name and file name without 
	 * any extension. The screenshot will store with .png extension
	 * @param folderName
	 * @param fileName
	 */
	
	public static void takeAlertScreenshot(String folderName, String fileName) {
		try {
			Robot r = new Robot();
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(bi, "png", new File(getFilePath(folderName, fileName+getTime()+".png")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		};
	}

}
