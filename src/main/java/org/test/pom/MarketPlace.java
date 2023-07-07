package org.test.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.UtilityClass;

public class MarketPlace extends UtilityClass {

	public MarketPlace() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Marketplace']")
	private WebElement btnmrtplace;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement srcbeneficiary;

	@FindBy(xpath = "//div[@class='card-body']")
	private WebElement choosebeneficiary;

	@FindBy(xpath = "//div[text()='Request payment']")
	private WebElement reqpayment;

	// -----------------------------------------------
	

	public WebElement getBtnmrtplace() {
		return btnmrtplace;
	}

	public WebElement getSrcbeneficiary() {
		return srcbeneficiary;
	}

	public WebElement getChoosebeneficiary() {
		return choosebeneficiary;
	}

	public WebElement getReqpayment() {
		return reqpayment;
	}

	public void marketPlace(String ben) {
		click(btnmrtplace);
		sendKeys(srcbeneficiary,ben );
		click(choosebeneficiary);
		click(reqpayment);

	}
	
	
	
	
	
	
}
