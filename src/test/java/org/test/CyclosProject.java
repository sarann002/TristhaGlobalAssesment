package org.test;

import java.io.IOException;
import java.util.Date;

import org.test.datas.Datas;
import org.test.pom.LoginPage;
import org.test.pom.MarketPlace;
import org.test.pom.RequestPayment;
import org.test.pom.VerifyPayment;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utility.ExtentReport_Generation;
import org.utility.UtilityClass;

public class CyclosProject extends UtilityClass {
	long starttime;
	long endtime;
	@BeforeClass
	private void setup() {
		
		ExtentReport_Generation.startReport();

	}

	@BeforeMethod
	private void beforeMethod() {		
		openBrowser(getPropertyValue("browsername"));
		openUrl(getPropertyValue("url"));
		implicitWait(10);
		System.out.println("Start Time....." + new Date());
		starttime = System.currentTimeMillis();

	}

	@AfterMethod
	private void afterMethod(ITestResult r) throws IOException {
		System.out.println("End Time....." + new Date());
		endtime = System.currentTimeMillis();
		System.out.println("Duration of Execurtion...." + (endtime - starttime));
		takeScreenShot(r.getName());
		ExtentReport_Generation.createLog(r);
		quit();
		

	}

	@AfterClass
	private void tearDown() {
		ExtentReport_Generation.endReport();
		

	}
	

	
	
	@Test(priority=1,dataProvider="datas",dataProviderClass=Datas.class)
	private void loginPage(String user,String pass,String ben,String amt,String date,String des) throws InterruptedException {
		LoginPage l=new LoginPage();
		l.login(user,pass);
		staticWait(3000);
		Assert.assertTrue(l.verfiylogin(),"Verify user login");
		MarketPlace m=new MarketPlace();
		m.marketPlace(ben);
		RequestPayment r=new RequestPayment();
		Assert.assertTrue(r.profileVerify(),"User profile Verify");
		r.requestPayment(amt, date, des);	
		VerifyPayment v=new VerifyPayment();
		Assert.assertTrue(v.verfiyPay(),"User Payment Details");
		Assert.assertTrue(v.verifyPaymentSuccesMessage(),"Verify Payment succes message");
		
		System.out.println("Done");	
	}
	
	

	
	
	

}
