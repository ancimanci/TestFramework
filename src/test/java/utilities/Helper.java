package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {

	/* here we create method to take screenshot in this case we give parameter two :
	 * 1- the driver
	 * 2- screenshot name 
	 * 
	 * we set the destination path for the screenshots
	*/
	
	public static void CapureScreenShot(WebDriver driver , String ScreenShotName) 
	{
		Path dest = Paths.get("./Screenshots/"+ScreenShotName+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exceptaion while takeing Screenshot" + e.getMessage());
		}
	}
	
	public static void CapureScreenShotsuccess(WebDriver driver , String ScreenShotName) 
	{
		Path dest = Paths.get("./successScreenshots/"+ScreenShotName+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exceptaion while takeing Screenshot" + e.getMessage());
		}
	}
}
