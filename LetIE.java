package com.test.lambda;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LetIE {
	
	public boolean status =false;
	public static void main(String[] args) throws InterruptedException{
		 String url="https://www.let.ie/";
		 
		 By accept_loc=By.xpath("//button[contains(text(),'Acc')]");
		 System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver_114.exe");
		 WebDriver driver=new ChromeDriver();
		 
		 driver.get(url);
		 Thread.sleep(3000);
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		//div[contains(@class,'results-panel')][1]//h2//a[1]
		 driver.findElement(accept_loc).click();
		 Thread.sleep(3000);
		 SearchBox(driver, "Dublin", "400", "1600");
		 int getsize=driver.findElements(By.xpath("//div[contains(@class,'results-panel')]//h2//a[1]")).size();
		 for(int i=2; i<=getsize;i++){
			 driver.findElement(By.xpath("//div[contains(@class,'results-panel')]["+i+"]//h2//a[1]")).click();
			 ContactAdvtiser(driver, "Vinayak", "test@gmail.com", "+3538922222");
		 }
		 
		 driver.quit();
	}
	
	 public static boolean SearchBox(WebDriver driver ,String county,String minprice,String maxprice){
		 try{
			 By search_btn=By.xpath("//div[contains(text(),'Sea')]");
			 
			 WebElement tstdrpdown=driver.findElement(By.name("county"));
			 Select drpdwn=new Select(tstdrpdown);
			 drpdwn.selectByVisibleText(county);
			 Thread.sleep(2000);
			 
			 WebElement tstdrpdwn1=driver.findElement(By.name("min_price"));
			 Select drpdwn1=new Select(tstdrpdwn1);
			 drpdwn1.selectByValue(minprice);
			 Thread.sleep(2000);
			 
			 WebElement tstdrpdwn2=driver.findElement(By.name("max_price"));
			 Select drpdwn2=new Select(tstdrpdwn2);
			 drpdwn2.selectByValue(maxprice);
			 Thread.sleep(2000);
			 
			 driver.findElement(search_btn).click();
			 Thread.sleep(3000);
			 
		 }catch(Exception e){
			 return false;
		 }
		 return true;
	 }
	 
	 public static boolean ContactAdvtiser(WebDriver driver, String name,String email,String phone){
		 try{
			 By search_btn=By.xpath("//div[contains(text(),'Sea')]");
			 By contact_btn=By.xpath("//div[contains(@id,'contact_advertiser')]");
			 By name_loc=By.xpath("//input[contains(@name,'name')]");
			 By email_loc=By.xpath("//input[contains(@name,'email')]");
			 By phone_loc=By.xpath("//input[contains(@name,'phone')]");
			 By message_loc=By.xpath("//textarea[contains(@name,'message')]");
			 By robo_loc=By.xpath("//label[contains(@role,'prese')]//span");
			 By terms_loc=By.xpath("//label[contains(@for,'terms')]");
			 By send_loc=By.xpath("//div[contains(text(),'Send')]");
			 By back_loc=By.xpath("//a[contains(text(),'Back')]");
			 
			 Thread.sleep(2000);
			 driver.findElement(contact_btn).click();
			 
			 ScrollUpOrDown(driver, name_loc);
			 driver.findElement(name_loc).sendKeys(name);
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, email_loc);
			 driver.findElement(email_loc).sendKeys(email);
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, phone_loc);
			 driver.findElement(phone_loc).sendKeys(phone);
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, message_loc);
			 driver.findElement(message_loc).sendKeys("msg");
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, robo_loc);
			 driver.findElement(robo_loc).click();
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, terms_loc);
			 driver.findElement(terms_loc).click();
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, send_loc);
			 driver.findElement(send_loc).click();
			 
			 Thread.sleep(1000);
			 ScrollUpOrDown(driver, back_loc);
			 driver.findElement(back_loc).click();
			 
			 Thread.sleep(2000);
			 
		 }catch(Exception e){
			 return false;
		 }
		 return true;
	 }
	 
	 public static boolean ScrollUpOrDown(WebDriver driver,By ele){
			try{
				Thread.sleep(1000);
				WebElement element=driver.findElement(ele);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(2000);
				driver.findElement(ele).isDisplayed();
			}catch(Exception e){
				return false;
			}
			return true;
		}

}
