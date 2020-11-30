package pageObjects;

import org.openqa.selenium.WebDriver;

public class CarTaxCheckHomePage {

    WebDriver driver;
    String homepageUrl = "https://cartaxcheck.co.uk/";

    public CarTaxCheckHomePage(WebDriver driver){
        this.driver = driver;
    }

    public CarTaxCheckHomePage loadPage(){
        driver.navigate().to(homepageUrl);
        return this;
    }
}
