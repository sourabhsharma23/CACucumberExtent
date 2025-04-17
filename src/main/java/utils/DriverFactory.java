package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory(){}
    
    public static WebDriver getDriver() {
        if (driver == null) {
        	ChromeOptions options = new ChromeOptions();
        	 // Detect if running on Jenkins and add headless
            if (System.getenv("JENKINS_HOME") != null) {
                options.addArguments("--headless=new"); // or "--headless" for older Chrome
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
                System.out.println("Running in Jenkins - launching Chrome in headless mode.");
            }
            driver = new ChromeDriver();  // or use WebDriverManager for setup
        }
        return driver;
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
