package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    public VehicleDetailsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String getVehicleRegistration(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(1) dd")));
        String make = driver.findElement(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(1) dd")).getText();
        return make;
    }

    public String getVehicleMake(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(2) dd")));
        String make = driver.findElement(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(2) dd")).getText();
        return make;
    }

    public String getVehicleModel(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(3) dd")));
        String make = driver.findElement(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(3) dd")).getText();
        return make;
    }

    public String getVehicleColour(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(4) dd")));
        String make = driver.findElement(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(4) dd")).getText();
        return make;
    }

    public String getVehicleYear(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(5) dd")));
        String make = driver.findElement(By.cssSelector("div#m > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) span > div:nth-child(2) dl:nth-child(5) dd")).getText();
        return make;
    }
}
