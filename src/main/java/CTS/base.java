package CTS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	
	{
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\arun_\\CTSProject\\src\\main\\java\\CTS\\data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
			driver = new ChromeDriver();
	}
		else if (browserName.equals("firefox"))
			{
			System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
			driver = new FirefoxDriver();
			}
			
	else if (browserName.equals("IE"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Jalaram\\chromedriver.exe");
		driver = new InternetExplorerDriver();
		}
			
		driver.manage().window().maximize();
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
}