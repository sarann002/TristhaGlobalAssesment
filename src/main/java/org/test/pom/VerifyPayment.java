package org.test.pom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.utility.UtilityClass;

public class VerifyPayment extends UtilityClass {

	public VerifyPayment() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='d-flex label-value-value']")
	private List<WebElement> txtamount;

	@FindBy(xpath = "//div[@class='notification-message']//div")
	private WebElement successMessage;
	
	@FindBy(xpath = "//span[text()='Amount']//parent::label//following-sibling::div[@class='label-value-container']/div")
	private WebElement actaulamount;
	
	@FindBy(xpath = "//span[text()='Expiration date']//parent::label//following-sibling::div[@class='label-value-container']/div")
	private WebElement actaulDate;
	
	@FindBy(xpath = "//span[text()='Description']//parent::label//following-sibling::div[@class='label-value-container']/div")
	private WebElement actualDes;

	// ---------------------------------------

	public List<WebElement> getTxtamount() {
		return txtamount;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public boolean verfiyPay() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> l = getTxtamount();
		List<String> expectedDatas = new LinkedList<String>(
				Arrays.asList(RequestPayment.amount,RequestPayment.date1,RequestPayment.description));
		List<String> actualDatas = new LinkedList<String>();
		String am = getText(actaulamount);
		am=am.substring(0,am.indexOf(','));
		actualDatas.add(am);
		
		try {
			Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(getText(actaulDate));
			 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			    String dt = sf.format(date1);
				actualDatas.add(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		actualDatas.add(getText(actualDes));

		
		System.out.println(expectedDatas);
		System.out.println(actualDatas);
		return expectedDatas.equals(actualDatas);
		

	}

	public boolean verifyPaymentSuccesMessage() {
		boolean flag=false;
		String expected = "The payment request was successfully sent";
		String actaul = getText(getSuccessMessage());
		if(expected.equals(actaul)) {
			flag= true;
		}
		else {
			flag= false;
		}
		System.out.println(actaul);
		return flag;

	}

}
