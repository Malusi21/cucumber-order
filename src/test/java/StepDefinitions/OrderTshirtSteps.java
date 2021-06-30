package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class OrderTshirtSteps {

    // Adding in a list of Project variables that will be needed for the tests
    // These can be stored differently in another class and referenceced from there
    String projectPath = System.getProperty("user.dir");
    String ItemPrice;
    WebDriver driver = null;
    String Firstname = "Legend1sdfdsfTestShop";
    String UpdatedName = "Spanishlaliga";
    String Lastname = "TetSur";
    String email = "Test@1222email.com";
    String Password = "54321";
    String newPassword = "12345";
    String Company = "Test225433";
    String Address = "23 Test road, Automation";
    String City = "Automation";
    String Zipcode = "12346";
    String Mobile = "0273346253";
    String alias = "TestLegend44343";
    JavascriptExecutor js = null;

    @Given("the user opens the browser to the ordering site")
    public void the_user_opens_the_browser_to_the_ordering_site() {
        // This function to starts up a new chrome web driver browser session
        // driver location also contains firefox geco driver which tests can also run against
        System.setProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.navigate().to("http://automationpractice.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @And("is redirected to the home page")
    public void is_redirected_to_the_home_page() {
        // This function validates that the user is redirected to the correct page
        driver.findElement(By.id("header_logo")).isDisplayed();
        driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();
        driver.findElement(By.className("login")).isDisplayed();

    }
    @When("The T-Shirt category Tab is Displayed and can be clicked")
    public void the_t_shirt_category_tab_is_displayed_and_can_be_clicked() {
        // This function validates the user id sdisplayed and can click the T-Shirts Tab
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a[contains(.,\"T-shirts\")]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a[contains(.,\"T-shirts\")]")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    @Then("the user is redirected to the T-Shirt category page")
    public void the_user_is_redirected_to_the_t_shirt_category_page() {
        // This function ensured that the user is redirected to the correct category page
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[contains(.,\"T-shirts\")]")).isDisplayed();
        driver.findElement(By.className("product-container")).isDisplayed();
    }

    @And("Products are displayed to the user")
    public void products_are_displayed_to_the_user() {
        // This function verifies that the user is displayed a product in the Product List item
        driver.findElement(By.className("product-container")).isDisplayed();
        driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
    }
    @Then("Hovering over a Product Reveals the item add to cart button")
    public void hovering_over_a_product_reveals_the_item_add_to_cart_button() {
        // This function simulates the hover function on the product item to reveal the "Add to cart" button
        Actions actions = new Actions(driver);
        WebElement listItem = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li"));
        actions.moveToElement(listItem).perform();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//span[contains(.,\"Add to cart\")]")).isDisplayed();
        ItemPrice = driver.findElement(By.className("content_price")).getText();
        System.out.println(ItemPrice);
        driver.findElement(By.xpath("//*//span[contains(.,\"Add to cart\")]")).click();


    }
    @And("User is able to click on the Add to Cart button")
    public void user_is_able_to_click_on_the_add_to_cart_button() {
        // This function validates that the user is displayed the correct summary string for their purchase on the cart view
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).isEnabled();
        String OrderPrice = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).getText();
        System.out.println(OrderPrice);
        driver.findElement(By.xpath("//*//h2/span[contains(.,\"There is 1 item in your cart.\")]")).isDisplayed();
        String ItemCount = driver.findElement(By.xpath("//*//h2/span[contains(.,\"There is 1 item in your cart.\")]")).getText();
    }
    @Then("Click on the Proceed to Checkout button")
    public void click_on_the_proceed_to_checkout_button() {
        // This Function clicks on the Proceed button on the Cart poo-up
        js.executeScript("window.scrollBy(0,100)");
        clickCheckout();
    }
    private void clickCheckout(){
        // This function is a helper function that is called to click the Proceed to checkout button on the cart pop-up
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//a[contains(.,\"Proceed to checkout\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a[contains(.,\"Proceed to checkout\")]")).click();
    }
    private void clickSummaryCheckout(){
        // This function is a helper function that is called to click the Proceed to checkout button on the checkout summary
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//p[2]/a[contains(.,\"Proceed to checkout\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//p[2]/a[contains(.,\"Proceed to checkout\")]")).click();
    }
    private void clickAddressCheckout(){
        // This function is a helper function that is called to click the Proceed to checkout button on the Address summary
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//p/button[contains(.,\"Proceed to checkout\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//p/button[contains(.,\"Proceed to checkout\")]")).click();
    }

    @Then("Verify the user is redirected to the Shopping-Cart Summary page")
    public void verify_the_user_is_redirected_to_the_Shopping_Cart_Summary_page(){
        // This function validates that the user is on the Shoping cart summary page, srolls and clicks on the Proceed to checkout button
        driver.findElement(By.id("cart_title")).isDisplayed();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        clickSummaryCheckout();

    }
    @And("Signin With a default user account on Authentication page")
    public void signin_With_a_default_user_account_on_authentication_page(){
        //This function sets the user up for signing up with a new account
        // function not in user due to elements location issues on the registration page
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1[contains(.,\"Authentication\")]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"create-account_form\"]/h3[contains(.,\"Create an account\")]")).isDisplayed();
        driver.findElement(By.id("SubmitCreate")).isDisplayed();
        driver.findElement(By.id("SubmitCreate")).isEnabled();
        driver.findElement(By.id("email_create")).isDisplayed();
        driver.findElement(By.id("email_create")).isEnabled();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("SubmitCreate")).click();

    }
    @And("Login with existing account")
    public void login_with_existing_account(){
        //this function Logs in an existing user using the variables set at the top of this class
        driver.findElement(By.xpath("//*//a[contains(.,\"Sign in\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a[contains(.,\"Sign in\")]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"create-account_form\"]/h3[contains(.,\"Create an account\")]")).isDisplayed();
        driver.findElement(By.id("email")).isDisplayed();
        driver.findElement(By.id("email")).isEnabled();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("passwd")).isDisplayed();
        driver.findElement(By.id("passwd")).isEnabled();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys(Password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("SubmitLogin")).isDisplayed();
        driver.findElement(By.id("SubmitLogin")).isEnabled();
        driver.findElement(By.id("SubmitLogin")).click();

    }
    @Then("Click on the Create an account button")
    public void click_on_the_create_an_account_button(){
        // This function clicks on the create button once user has entered in all their details for signin up
        driver.findElement(By.id("SubmitCreate")).isDisplayed();
        driver.findElement(By.id("SubmitCreate")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @And("Create a new user account by adding in Personal details")
    public void create_a_new_user_account_by_adding_in_personal_details(){
        // This function enters the users details to the signup page
        // function not in user due to elements location issues on the registration page
        driver.findElement(By.id("id_gender1")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(Firstname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).sendKeys(Lastname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,100)");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys(Password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("uniform-days")).isDisplayed();
        driver.findElement(By.id("uniform-days")).click();
        driver.findElement(By.id("days")).click();
        driver.findElement(By.xpath("//*[@id=\"days\"]/option[4]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"days\"]/option[4]")).click();
        driver.findElement(By.id("months")).isDisplayed();
        driver.findElement(By.id("months")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[4]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[4]")).click();
        driver.findElement(By.id("years")).isDisplayed();
        driver.findElement(By.id("years")).click();
        driver.findElement(By.xpath("//*[@id=\"years\"]/option[4]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"years\"]/option[4]")).click();
    }
    @And("Enter user address")
    public void enter_user_address_on_signin(){
        // This function Enters in the user details into the registration page elements
        // this function still need to be worked on to be funtional
        driver.findElement(By.id("customer_firstname")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(Firstname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).sendKeys(Lastname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("Company")).click();
        driver.findElement(By.id("Company")).sendKeys(Company);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.id("Address")).click();
        driver.findElement(By.id("Address")).sendKeys(Address);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("City")).click();
        driver.findElement(By.id("City")).sendKeys(City);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("Zipcode")).click();
        driver.findElement(By.id("Zipcode")).sendKeys(Zipcode);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.id("Mobile")).click();
        driver.findElement(By.id("Mobile")).sendKeys(Mobile);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("alias")).sendKeys(alias);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @And("Preview Entered user address")
    public void enter_user_address(){
        // This function scrolls user through the address page and clicks "Proceed to checkout" button
        js.executeScript("window.scrollBy(0,700)");
        clickAddressCheckout();
    }
    @Then("Confirm Shipping")
    public void confirm_shipping_address(){
        // This function clicks on the conrifmation checkbox and calls the address page helper function to click "Proceed to checkout"
        driver.findElement(By.id("cgv")).isDisplayed();
        driver.findElement(By.id("cgv")).isEnabled();
        driver.findElement(By.id("cgv")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("cgv")).isSelected();
        clickAddressCheckout();
    }
    @And("Complete Payment via bank")
    public void complete_payment_via_bank(){
        // This function selects the payment Method Bank wire as payment
        driver.findElement(By.className("bankwire")).isDisplayed();
        driver.findElement(By.className("bankwire")).isEnabled();
        driver.findElement(By.className("bankwire")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Then("Confirm Order")
    public void confirm_order(){
        // This function validates that the user is taken to correct page and clicks confirm order, and waits for order confirmation header
        driver.findElement(By.className("module-bankwire-payment")).isDisplayed();
        driver.findElement(By.xpath("//*//button[contains(.,\"I confirm my order\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//button[contains(.,\"I confirm my order\")]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//h1[contains(.,\"Order confirmation\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//h1[contains(.,\"Order confirmation\")]")).click();

    }

    @Then("Return User to Home Page")
    public void return_user_to_home_page(){
        // This function clicks on the home menu logo and validates the user is returned home then closes and quits the browser session
        driver.findElement(By.xpath("//*//a[contains(@title,\"My Store\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a[contains(@title,\"My Store\")]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.getCurrentUrl().contains("http://automationpractice.com/index.php");
        driver.close();
        driver.quit();
    }

    @Then("Go to User Personal information page")
    public void go_to_personal_information_page(){
        // This function validates that the user is redirected to the personal information page
        driver.findElement(By.xpath("//*//a[contains(.,\"My personal information\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a[contains(.,\"My personal information\")]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @And("Update Users Firstname")
    public void update_firstname(){
        // This function updates the users firstname with a new firstname on the personal information page
        driver.findElement(By.xpath("//*//h1[contains(.,\"Your personal information\")]")).isDisplayed();
        driver.findElement(By.id("firstname")).isDisplayed();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).sendKeys(UpdatedName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @And("Update User password")
    public void update_password(){
        // This function updates the users password with a new password on the personal information page
        driver.findElement(By.id("old_passwd")).isDisplayed();
        driver.findElement(By.id("old_passwd")).click();
        driver.findElement(By.id("old_passwd")).isDisplayed();
        driver.findElement(By.id("old_passwd")).sendKeys(Password);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("passwd")).isDisplayed();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).isDisplayed();
        driver.findElement(By.id("passwd")).sendKeys(newPassword);

        driver.findElement(By.id("confirmation")).isDisplayed();
        driver.findElement(By.id("confirmation")).click();
        driver.findElement(By.id("confirmation")).isDisplayed();
        driver.findElement(By.id("confirmation")).sendKeys(newPassword);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//button[contains(.,\"Save\")]")).click();


    }
    @Then("Validate user details have been updated")
    public void confirm_details_updated(){
        // This function validates the personal information has been updated message that should be displayed to the user after updating details
        driver.findElement(By.xpath("//*//p[contains(.,\"Your personal information has been successfully updated.\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a/span[contains(.,\"Home\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a/span[contains(.,\"Home\")]")).isEnabled();
        driver.findElement(By.xpath("//*//a/span[contains(.,\"Home\")]")).click();

    }
    @And("New name is displayed to the user on the home page")
    public void new_name_displayed_to_user(){
        // This function validates the user is returned home, checks that the username has been updated then closes and quits the browser session
        driver.getCurrentUrl().contains("http://automationpractice.com/index.php");
        String namePath = "//*//a/span[contains(.,\""+UpdatedName+" "+ Lastname +"\")]";
        System.out.println(namePath);
        driver.findElement(By.xpath(namePath)).isDisplayed();
        driver.close();
        driver.quit();
    }
}
