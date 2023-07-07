package org.test.datas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;

public class Datas {
	
	public static String getdescription() {
		List<String> li= new LinkedList<String>();
		li.add("Upcomming payament");
		li.add("New payament");
		li.add("Request to complete the payment");
		li.add("Immediate requirmenet so complete the payment");
		 Random rand = new Random();
		   return li.get(rand.nextInt(li.size()));

	}

//	------LOGIN-------
	@DataProvider(name="datas")
	private Object [][] datas() {
		Object [][]obj=new Object[][] {
			{"PaymentSender","1234","PremKumar","500","15-07-2023",getdescription()},
			{"PaymentSender","1234","PremKumar","200","16-07-2023",getdescription()},
			{"PaymentSender","1234","PremKumar","100","13-07-2023",getdescription()},
			{"PaymentSender","1234","PremKumar","400","26-07-2023",getdescription()},
			{"PaymentSender","1234","PremKumar","300","20-07-2023",getdescription()}
		};
		return obj;
	}
	


}
