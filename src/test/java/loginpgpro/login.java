package loginpgpro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
WebDriver driver;


@BeforeTest()
public void setup() {
	System.setProperty("webdriver.chrome.driver","D:\\myinstallation\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://main.edvora.me");
	driver.manage().window().setSize(new Dimension(800,600));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
}

@Test(description="sign in button")
public void signinbutton() {
	boolean b = driver.findElement(By.xpath("//button[@type='button']")).isEnabled();
	System.out.print("sign in button is clickeable:"+ b);
	Assert.assertTrue(b);	
}
 @Test(description="veriy login button when bothfields are blank")
 public void verify_Login_Button() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 Thread.sleep(2222);
	 Alert alt=driver.switchTo().alert();
	 String text=alt.getText();
	 Assert.assertEquals(text,"Username and password field can not be blank");
	 System.out.println("getting popup like account succesfully created hence test case failed");
 }
 @Test(description="veriy login button when password field blank")
 public void verify_login_button1() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 driver.findElement(By.xpath("//input[@tabindex='1']")).sendKeys("rcpawar.007@gmail.com");
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 Thread.sleep(2222);
	 Alert alt=driver.switchTo().alert();
	 String abc=alt.getText();
	 Assert.assertEquals(abc,"password field can not be blank");
	 System.out.println("getting popup like account succesfully created hence test case failed");
 }
	
 @Test(description="veriy login button when username field blank")
 public void verify_login_button2() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]")).sendKeys("abc1234");
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 Thread.sleep(2222);
	 Alert alt=driver.switchTo().alert();
	 String abc=alt.getText();
	 Assert.assertEquals(abc,"username field can not be blank");
	 System.out.println("getting popup like account succesfully created hence test case failed");
	 
 }
 @Test(description="veriy login button when both fields are entered")
 public void verify_login_button3() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("rcpawar.007@gmail.com");
	 driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]")).sendKeys("Rahul");
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 Thread.sleep(2222);
	 Alert alt=driver.switchTo().alert();
	 String abc=alt.getText();
	 Assert.assertEquals(abc,"Account sucessfully created.");
	 
 }
 @Test(description="veriy login button when new account created")
 public void verify_Login_functionality() throws InterruptedException {
	 driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("rcpawar.007@gmail.com");
	 Thread.sleep(2222);
	 driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]")).sendKeys("Rahul");
	 Thread.sleep(2222);
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 Assert.assertTrue(false);
	 System.out.println("when clicked on login button,not landing on home page hence test case failed");
	 
 }
 @Test(description="veriy if user can edit info on setting page which is on home button")
 public void Verify_edit_info() throws InterruptedException {
	 driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("rcpawar.007@gmail.com");
	 Thread.sleep(2222);
	 driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]")).sendKeys("Rahul");
	 Thread.sleep(2222);
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 Assert.assertTrue(false);
	 System.out.println("unable to login hence unable to check and edit info in setting button hence test case failed");
	 
 }


}
