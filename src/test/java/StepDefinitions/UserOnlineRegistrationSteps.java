package StepDefinitions;


import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UserOnlineRegistrationSteps {

    WebDriver driver = null;
    JavascriptExecutor js = null;

    @Given("The user enters an already existing email")
    public void Load_Browser_and_navigate_to_registration(){

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;
        driver.get("http://automationpractice.com\"");
        //driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        The_user_enters_an_already_existing_email();
    }

    public void The_user_enters_an_already_existing_email() {
        // This function validates that the user is redirected to the correct page
        driver.findElement(By.id("header_logo")).isDisplayed();
        driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();
        driver.findElement(By.className("login")).isDisplayed();

    }

}