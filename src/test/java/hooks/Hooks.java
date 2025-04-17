package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtils;
import utils.WaitUtils;

public class Hooks {

    WebDriver driver;
   static ExtentReports extent = ExtentManager.getExtent();
   static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {
    	WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getDriver();
        System.out.println("Browser launched.");
        driver.manage().window().maximize();

       ExtentTest test = extent.createTest(scenario.getName());
       scenarioTest.set(test);
       
       scenarioTest.get().log(Status.INFO, "Scenario Started: " + scenario.getName());
        
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
    	if(scenario.isFailed()) {
    		String screenshotPath = ScreenshotUtils.takeScreenshot(driver, scenario.getName());
    		scenarioTest.get().addScreenCaptureFromPath(screenshotPath);
    	}
    	
    }  
    
    @After
    public void tearDown(Scenario scenario) {
    	if(scenario.isFailed()) {
    		scenarioTest.get().log(Status.FAIL," Scenario failed: " + scenario.getName());
    	}else {
    		scenarioTest.get().log(Status.PASS, "Scenario passed: " +scenario.getName());
    	}
    	
        DriverFactory.quitDriver();
        System.out.println("Browser closed.");
        extent.flush();
    }
}
