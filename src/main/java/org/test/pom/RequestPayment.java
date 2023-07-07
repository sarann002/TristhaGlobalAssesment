package org.test.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.UtilityClass;

public class RequestPayment extends UtilityClass {

	public RequestPayment() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement txtamount;

	@FindBy(xpath = "//input[@type='date']")
	private WebElement txtdate;

	@FindBy(xpath = "//div[@class='w-100']")
	private WebElement drpclick1;

	@FindBy(xpath = "//a[text()=' Scheduled ']")
	private WebElement drpclick2;
	
	@FindBy(xpath = "//textarea[contains(@class,'form-contro')]")
	private WebElement txtdescription;
	
	@FindBy(xpath = "//span[text()='Confirm']")
	private WebElement btnrequestsubmit1;
	
	@FindBy(xpath = "(//span[text()='Confirm'])[2]")
	private WebElement btnrequestsubmit2;
	
	
	static String amount;
	static String date1;
	static String description;
	public void requestPayment(String amt,String date,String des) throws InterruptedException {
		sendKeys(txtamount,amt);
		 amount = getAttribute(txtamount);
		sendKeys(txtdate, date);
		date1=getAttribute(txtdate);
		click(drpclick1);
		click(drpclick2);
		sendKeys(txtdescription, des);
		description=getAttribute(txtdescription);
		click(btnrequestsubmit1);
		Thread.sleep(2000);
		click(btnrequestsubmit2);

	}
	
	public boolean profileVerify() throws InterruptedException {
		staticWait(3000);
		boolean d = getUrl().contains("payment-request");
		return d;

	}
	
//	----------------------------------------------------

	public WebElement getTxtamount() {
		return txtamount;
	}

	public WebElement getTxtdate() {
		return txtdate;
	}

	public WebElement getDrpclick1() {
		return drpclick1;
	}

	public WebElement getDrpclick2() {
		return drpclick2;
	}

	public WebElement getTxtdescription() {
		return txtdescription;
	}

	public WebElement getBtnrequestsubmit1() {
		return btnrequestsubmit1;
	}

	public WebElement getBtnrequestsubmit2() {
		return btnrequestsubmit2;
	}
	
	

	// -----------------------------------------------


}
