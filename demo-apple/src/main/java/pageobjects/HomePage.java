package pageobjects;

import config.WebApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebApi {
    @FindBy(xpath = "//div[@data-unit-id='iphone-12']//a[.='Buy']")
    WebElement lblBuyIphone12;

    public BuyPage clickBuyIphone12(){
        clickToElement(lblBuyIphone12);
        return new BuyPage();
    }
}
