package userDefinedLibraries;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckFields extends Utilities {
	
	
	/*
	 * Clear the value present in text box
	 */
	public WebElement clearValue(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		element.sendKeys(Keys.DELETE);
		return element;
	}
	
	/********* Check for TextBox **********/
	public WebElement checkText(String key, String xpath) {
		WebElement element = clearValue(xpath);
		element.sendKeys(key);
		element.sendKeys(Keys.TAB);
		String value = element.getAttribute("value").replaceAll(",", "");
		
		Assert.assertEquals(value, key);
		return element;
	}
	
	/********* Check for Slider **********/
	public String checkSlider(String xpath1, String xpath2)  {
		WebElement slider = driver.findElement(By.xpath(xpath1));
		
		WebElement element = clearValue(xpath2);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
		element.sendKeys(Keys.TAB);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider, 10, 0).perform();
		String value = element.getAttribute("value");
		return value;
	}

}
