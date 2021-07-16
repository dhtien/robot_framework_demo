package pageobjects;

import config.WebApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BuyPage extends WebApi {
    @FindBy(xpath = "//h2[.='Choose your model.']/following-sibling::fieldset//span[.='iPhone 12']")
    WebElement fieldIphone12;

    @FindBy(xpath = "//h2[.='Choose your finish.']/following-sibling::fieldset//span[.='White']")
    WebElement fieldColorWhite;

    @FindBy(xpath = "//h2[.='Choose your capacity.']/following-sibling::fieldset//span[text()='256']")
    WebElement fieldCapacity;

    @FindBy(xpath = "//h2[.='Choose your carrier.']/following-sibling::fieldset//span[text()='SIM-free']")
    WebElement fieldChooseCarrier;

    @FindBy(xpath = "//h2[.='Do you have a smartphone to trade in with Apple?']//ancestor::fieldset//span[text()='No ']")
    WebElement fieldTradeNo;

    @FindBy(xpath = "//input[@data-autom='purchaseOptionfullPrice']")
    WebElement lblOneTimePayment;

    @FindBy(name = "add-to-cart")
    WebElement btnAddToBag;

    @FindBy(xpath = "//span[text()='iPhone 12 256GB White']")
    WebElement lblIphone12InBag;
    public BuyPage clickFieldIphone12(){
        clickToElement(fieldIphone12);
        return this;
    }

    public BuyPage clickFieldColorWhite(){
        waitForPageLoaded();
        clickToElement(fieldColorWhite);
        return this;
    }

    public BuyPage click256Capacity(){
        waitForPageLoaded();
        clickToElement(fieldCapacity);
        return this;
    }

    public BuyPage clickCarrier(){
        waitForPageLoaded();
        clickToElement(fieldChooseCarrier);
        return this;
    }

    public BuyPage clickNoTrade(){
        waitForPageLoaded();
        clickToElement(fieldTradeNo);
        return this;
    }

    public BuyPage clickOneTimePayment(){
        try{
            Thread.sleep(2000);
        }catch (Exception ignore){
        }
        waitForPageLoaded();
        clickToElementByJavascript(lblOneTimePayment);
        return this;
    }

    public BuyPage clickAddToBag(){
        waitForPageLoaded();
        clickToElementByJavascript(btnAddToBag);
        return this;
    }

    public void verifyBag(){
        Assert.assertTrue(isControlDisplayed(lblIphone12InBag, 5));
    }
}
