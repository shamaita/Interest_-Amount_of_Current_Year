package userDefinedLibraries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static String browser;

	/*
	 * Creating constructor to initialize properties file
	 */
	public Utilities() {

		FileReader reader = null;
		String path = System.getProperty("user.dir") + "\\URL_Locators.properties";

		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/********** Invoke Browser ***********/
	/*
	 * Method to open user choice of browser
	 */
	public static WebDriver getDriver(String browser)
	{

		System.out.println("Browser selected: " + browser);
		// open chrome browser
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		// open firefox browser
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		} 
		
		// open edge browser
		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		// Maximize window
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}                                                                                                           


	/*
	 * Method to Open URL
	 */
	public void openUrl() 
	{
		driver.get(config.getProperty("baseUrl"));
	}

	
	/*
	 * Method to wait till element is click-able
	 */
	public void waitElementClickable(String elementXpath) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
	}


	/*
	 * Take Screenshot
	 */
	public void snap(String fileName) 
	{
		// Creating a screenshot driver and storing in scrFile temporarily.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Now copying it in the folder
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName +"_"+browser+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/*
	 * Closing browser
	 */
	public void quitBrowser() {
		driver.quit();
	}


}
