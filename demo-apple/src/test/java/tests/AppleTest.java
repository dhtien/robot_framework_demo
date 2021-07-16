package tests;

import config.DriverManager;
import config.PageFactoryManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CountryPage;

public class AppleTest {
    @BeforeMethod
    public void init(){
        DriverManager.openMultiBrowser("chrome");
    }
    @Test
    public void demo(){
        PageFactoryManager.get(CountryPage.class)
                .clickToCountryName("United States")
                .clickBuyIphone12()
                .clickFieldIphone12()
                .clickFieldColorWhite()
                .click256Capacity()
                .clickCarrier()
                .clickNoTrade()
                .clickOneTimePayment()
                .clickAddToBag()
                .verifyBag();

    }

    @AfterMethod
    public void clean(){
        DriverManager.closeBrowserAndDriver();
    }
}
