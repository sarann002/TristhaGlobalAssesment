package org.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {
	public static WebDriver driver;

	public static void openBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
			else if(browsername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browsername.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else {
				System.out.println("Invalid BrowserName");
				throw new WebDriverException();
			}
	}

	public static void openUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	public static String getTitle() {
		return driver.getTitle();

	}

	public static String getUrl() {
		return driver.getCurrentUrl();

	}
	
	public static void selectDropDownByValue(WebElement element, String val) {
		Select s = new Select(element);
		s.selectByValue(val);
	}
	public void sendKeys(WebElement e, String value) {
		WebDriverWait w= new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOf(e));
		try{
			e.sendKeys(value);
				}
		catch (Exception ex) {
			jsSendKeys(e, value);
			ex.printStackTrace();
		}

	}
	
	
	public void click(WebElement e) {
		WebDriverWait w= new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementToBeClickable(e));
		try{
			e.click();
		}catch (Exception ex) {
			jsClick(e);
			ex.printStackTrace();
		}

	}

	public static void sendKeys(WebElement e, String val, Keys k) {
		e.sendKeys(val, k);
	}

	public static void jsSendKeys(WebElement e, String val) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + val + "')", e);

	}

	

	public static void jsClick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);

	}
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void mouseHover(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}
	
	public static void windowHandles(int id) {
		Set<String> all = driver.getWindowHandles();
		List<String> li= new LinkedList<String>(all);
		driver.switchTo().window(li.get(id));

	}

	public static String getPropertyValue(String key) {
		String s = null;
		try {
			Properties p = new Properties();
			p.load(new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\config.properties"));
			s = p.get(key).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;

	}

	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}
	public static String getText(WebElement e) {
		return e.getText();
	}

	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");
	}
	
	public static void staticWait(int mil) throws InterruptedException {
		Thread.sleep(mil);

	}
	
	public static void quit() {
		driver.quit();

	}

	public static void takeScreenShot(String imagename) {
		try{TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShots\\" + imagename + ".png");
		FileUtils.copyFile(src, des);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
