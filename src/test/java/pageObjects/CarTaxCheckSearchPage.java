package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarTaxCheckSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public CarTaxCheckSearchPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void findAVehicle(String vrn){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#vrm-input")));
        driver.findElement(By.cssSelector("input#vrm-input")).sendKeys(vrn);
        driver.findElement(By.cssSelector("button")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
