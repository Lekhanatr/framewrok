package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
//to run same test script with different or multiple set of data
//ex: situation is create constumer but with different customer names, add multiple items to cart at a time
	@Test(dataProvider = "customerinfo")
	public void sample(String name, int id) {
		System.out.println("customer name is: "+ name);
		System.out.println("customer id is: "+ id);
	}
	//to run same test script with different or multiple set of data
	@DataProvider(name="customerinfo")
	public Object[][] getData(){
		
		//rows n columns -there are 3 data sets with 2 info each
		Object[][] data = new Object[3][2];
		
		//first set
		data[0][0]="Lekhana";
		data[0][1]=12;
		
		//second set
		data[1][0]="swaroop";
		data[1][1]=13;
		
		//third set
		data[2][0]="chetana";
		data[2][1]=14;
		
		return data;
	}
}
