/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss;

/**
 *
 * @author a_pramanik
 */
import org.openqa.selenium.Keys;
import java.io.File;
import java.io.IOException;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//import org.eclipse.jetty.server.Response.OutputType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.lang.String;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static org.openqa.selenium.lift.Finders.button;
import static org.openqa.selenium.lift.Finders.button;

public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Program Started");
		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com/maps/@23.8144636,90.3718384,14z/data=!5m1!1e1");
		//driver.get("https://www.google.com/maps/dir/Dhaka+New+Market,+Mirpur+Rd,+Dhaka+1205/13+Mirpur+Rd,+Dhaka+1205/@23.7421679,90.3726102,15z/data=!3m1!4b1!4m18!4m17!1m5!1m1!1s0x3755b84e57dd8b19:0xd66f294182e721e8!2m2!1d90.3838475!2d23.7332635!1m5!1m1!1s0x3755b8ad8ae5d3a9:0x678f8ca71427e8f5!2m2!1d90.3782731!2d23.7510727!2m3!6e0!7e2!8j1568487300!3e0");
		int date = 8;
		ImageName in = new ImageName();
		int a = 0;
		int hr =15, min = 45,day = 4,dayCount = 6;
		String month = "Aug";
		String [] days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		while (true) {

			String time = in.getTime();
			String minute = time.substring(3, 8);
			System.out.println(time);
			if ((true) || minute.equals("00:00") || minute.equals("15:00") || minute.equals("30:00")
					|| minute.equals("45:00")) {

				// driver.navigate().refresh();
				if (a == 0) {
					driver.get("https://www.google.com/maps/@23.8144636,90.3718384,14z/data=!5m1!1e1");
					Thread.sleep(20000);
					
					driver.findElement(By.xpath("//*[@id=\"layer\"]/div/div/div/span/span[3]")).click();
				}
				//a = 1;
				try {
					Thread.sleep(7000);

					if (a == 0) {
						driver.findElement(By.xpath("//*[@id=\"searchbox-directions\"]")).click();

						Thread.sleep(5000);
						WebElement source = driver.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input"));
						source.sendKeys("new market");
	
						WebElement destination = driver.findElement(By.xpath("//*[@id=\"sb_ifc52\"]/input"));
						destination.sendKeys("13 Mirpur Rd, Dhaka 1205");
	
						Thread.sleep(8000);
	
						destination.sendKeys(Keys.RETURN);
	
						Thread.sleep(5000);
	
						driver.findElement(By.id(":6")).click();
						Thread.sleep(2000);
						System.out.println("came here");
						Thread.sleep(2000);
						
						
						
	
						driver.findElement(By.id(":4")).click();
						Thread.sleep(2000);
						
						//Make some changes here 
						Thread.sleep(10000);

				}		
					// Reduce time by 15 minutes
					driver.findElement(
							By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[2]/div[1]/span[1]/span/button[1]"))
							.click();
//					String s1 = driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[2]/div[1]/span[2]/span[1]/text()")).getAttribute("value");

					// Close the side pane
					driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[3]/button")).click();
					Thread.sleep(2000);
					if(a==0) Thread.sleep(40000);
					File scrFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
					a = 1;
					// Open the side panel now
					driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[3]/button")).click();
					
//										System.out.println(s1);
					String s = date+" "+month+"-"+days[day]+"-"+hr+"-"+min;

					FileUtils.copyFile(scrFile, new File("E:\\OlifeData\\" + s + ".png"));
					min = min-15;
					if(min<=0) {
						min = 60+min;
						hr--;
						if(hr==-1) {
							day--;
							date--;
							hr = 24+hr;
							if(day==-1) day = 6;
							dayCount--;
							if(date==0) {
								month = "Sep";
								date = 30;
							}
							
						}
							
					}	

				} catch (IOException e) {
					e.printStackTrace();
				}


			}

		}

	}

}
