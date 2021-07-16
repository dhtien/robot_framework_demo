package pageobjects;

import config.WebApi;

import static config.Constant.BASE_URL;

public class CountryPage extends WebApi {

    String lblCountryName(String name){
        return String.format("//span[text()='%s']",name);
    }

    public CountryPage(){
        openAnyUrl(BASE_URL + "/choose-country-region/");
    }

    public HomePage clickToCountryName(String fieldName){
        clickToElement(lblCountryName(fieldName));
        return new HomePage();
    }
}
