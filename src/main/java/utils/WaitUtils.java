package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10; // seconds

    // Create WebDriverWait with default timeout
    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    // Overloaded to allow custom timeout
    private static WebDriverWait getWait(WebDriver driver, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // --------- Wait Methods ---------

    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return getWait(driver).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForClickability(WebDriver driver, WebElement element) {
        return getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForInvisibility(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForTextInElement(WebDriver driver, By locator, String text) {
        return getWait(driver).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static Alert waitForAlert(WebDriver driver) {
        return getWait(driver).until(ExpectedConditions.alertIsPresent());
    }

    // Optional: Add overloaded methods with custom timeouts
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeout) {
        return getWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebDriver driver, By locator, int timeout) {
        return getWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static void waitForPageLoad(WebDriver driver) {
        getWait(driver).until(webDriver -> 
            ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

 // This wait is for page load timeout
    public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
        getWait(driver, timeoutInSeconds).until(webDriver -> 
            ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    // This wait is for element to be interactable
    public static WebElement waitForInteractable(WebDriver driver, WebElement element) {
        return getWait(driver).until(driver1 -> {
            try {
                return (element.isDisplayed() && element.isEnabled()) ? element : null;
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                return null;
            }
        });
    }
	
}
