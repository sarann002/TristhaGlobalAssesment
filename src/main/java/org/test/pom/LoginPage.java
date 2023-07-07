package org.test.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.utility.UtilityClass;

public class LoginPage extends UtilityClass {

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//input[@placeholder='User']")
	private WebElement txtuser;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement txtpass;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement btnlogin;

//	-----------------------------------------------
	public WebElement getTxtuser() {
		return txtuser;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
	
	public void login(String user,String pass) {
		sendKeys(getTxtuser(), user);
		sendKeys(getTxtpass(), pass);
		click(getBtnlogin());
		

	}
	
	public boolean verfiylogin() {
		boolean c = getUrl().contains("dashboard");
		return c;

	}
	
}
