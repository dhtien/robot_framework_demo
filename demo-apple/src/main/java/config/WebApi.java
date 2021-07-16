package config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebApi {

    WebElement element;
    List<WebElement> elements;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait waitExplicit;
    Actions action;
    By byLocator;
    public WebDriver driver;
    boolean status;

    public WebApi() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void openAnyUrl(String url) {
        driver.get(url);
    }

    public void clickToElement(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = waitForElementVisible(locator);
        element = waitForElementClickable(locator);
        element.click();
    }

    public void clickToElement(WebElement element) {
        element = waitForElementVisible(element);
        element.click();
    }

    public void clickToElementByJavascript(WebElement ele) {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", ele);
    }

    public WebElement waitForElementVisible(WebElement element) {
        waitExplicit = new WebDriverWait(driver, DriverManager.getLONG_TIMEOUT());
        try {
            element = waitExplicit.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ex) {
            System.err.println(
                    "================================== Element not visible===================================");
            System.err.println(ex.getMessage() + "\n");
        }
        return element;
    }

    public WebElement waitForElementVisible(String locator, String... values) {
        waitExplicit = new WebDriverWait(driver, DriverManager.getLONG_TIMEOUT());
        locator = String.format(locator, (Object[]) values);
        byLocator = By.xpath(locator);
        try {
            return waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        } catch (Exception ex) {
            System.err.println(
                    "================================== Element not visible===================================");
            System.err.println(ex.getMessage() + "\n");
            return null;
        }
    }

    public WebElement waitForElementClickable(String locator) {
        waitExplicit = new WebDriverWait(driver, DriverManager.getLONG_TIMEOUT());
        byLocator = By.xpath(locator);
        return waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
    }

    public WebElement waitForElementClickable(WebElement element) {
        waitExplicit = new WebDriverWait(driver, DriverManager.getLONG_TIMEOUT());
        return waitExplicit.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = waitDriver -> {
            assert waitDriver != null;
            return ((JavascriptExecutor) waitDriver).executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, DriverManager.getSHORT_TIMEOUT());
            wait.until(expectation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementVisible(WebElement element, long timeout) {
        waitExplicit = new WebDriverWait(this.driver, timeout);
        try {
            return waitExplicit.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception var3) {
            return null;
        }
    }

    public boolean isControlDisplayed(WebElement element, long timeout) {
        try {
            element = waitForElementVisible(element, timeout);
            return element.isDisplayed();
        } catch (Exception var3) {
            return false;
        }
    }
}
