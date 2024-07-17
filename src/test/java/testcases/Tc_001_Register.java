package testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tc_001_Register  extends Baseclass{
@Test(dataProvider ="registerdata")
public void registration(String fname,String lname,String street,String city,String state,String zipcode,String phone,String ssn,String uname,String password,String rpassword) {
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(fname);
	driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(lname);
	driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(street);
	driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
	driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
	driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(zipcode);
	driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(phone);
	driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(ssn);
	driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(uname);
	driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(rpassword);
	Assert.assertTrue(false);
}

@DataProvider(name="registerdata")
	public String[][] Registrationdata(){
		String[][]data= {
				
				{"DEERAJ","kumar","kotagally","nizamabad","telangana","503001","9989101075","1233","Deeraj@5990","Deeraj@123","Deeraj@123"},
		
		};
				return data;
	

		
}

}


