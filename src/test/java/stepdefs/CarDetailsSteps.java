package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static Utilities.Helper.*;
import static  org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CarTaxCheckSearchPage;
import pageObjects.CarTaxCheckHomePage;
import pageObjects.VehicleDetailsPage;
import java.util.List;

public class CarDetailsSteps {

    WebDriver driver;
    WebDriverWait wait;
    CarTaxCheckHomePage homePage;
    CarTaxCheckSearchPage searchPage;
    VehicleDetailsPage detailsPage;

    String testFileDirectory;
    List<String> inputFiles;
    List<String> matchedCarRegs;
    String expectSearchResults;
    String outputFilePath = "src/test/resources/testFiles/car_output.txt";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        homePage = new CarTaxCheckHomePage(driver);
        searchPage = new CarTaxCheckSearchPage(driver, wait);
        detailsPage = new VehicleDetailsPage(driver, wait);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("^a text file which contains some vehicle registration numbers$")
    public void a_text_file_which_contains_some_vehicle_registration_numbers() {
        testFileDirectory = "src/test/resources/testFiles/input";
    }

    @When("^I read the content of the file and do a vehicle search$")
    public void i_read_the_content_of_the_file_and_do_a_vehicle_search() {
        inputFiles = getAllFilesInDirectory(testFileDirectory);
    }

    @Then("^a free car check result is displayed for the vehicle registration numbers$")
    public void a_free_car_check_result_is_displayed_for_the_vehicle_registration_numbers() {

        expectSearchResults = readFileContent(outputFilePath);

        for(String file : inputFiles){

            matchedCarRegs = getCarRegistrationFromFile(file);

            for(String carReg : matchedCarRegs){
                System.out.println("========== Finding vehicle details for car registration number : " + carReg);

                homePage.loadPage();
                searchPage.findAVehicle(carReg);
                String carSearchResult = String.format("%s,%s,%s,%s,%s",
                        detailsPage.getVehicleRegistration(),
                        detailsPage.getVehicleMake(),
                        detailsPage.getVehicleModel(),
                        detailsPage.getVehicleColour(),
                        detailsPage.getVehicleYear());

                  System.out.println("************************************");
                  System.out.println(expectSearchResults);
                  System.out.println("                 ");
                  System.out.println(carSearchResult);
                  System.out.println("************************************");

                  assertTrue("***** The vehicle search result " + carSearchResult + " does match the expected vehicle details *****", expectSearchResults.contains(carSearchResult));

                System.out.println("========== Found vehicles details for car registration number : " + carReg);
            }
        }
    }
}
