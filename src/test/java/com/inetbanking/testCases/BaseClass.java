package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	//public String baseURL="https://demo.guru99.com/V1/index.php";
	public String baseURL=readconfig.getApplicationURL();
	//public String username="mngr544129";
	public String username=readconfig.getUsername();
	//public String password="UjetAdE";
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger log;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{

		if(br.equals("chrome"))
		{ 
			//WebDriverManager.chromedriver().clearDriverCache().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();

		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();

		}
		else
		{
			driver=null;


		}

		//log=LogManager.getLogger("Ebanking Project");
		log=Logger.getLogger("e_bankinf SDET");
		PropertyConfigurator.configure("log4j.properties"); 
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		log.info("URL is opened");

	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");


	}
	
	public String randomstring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randompass()
	{
		String generatepass = RandomStringUtils.randomAlphanumeric(4,8);
		return generatepass;
	}

}
