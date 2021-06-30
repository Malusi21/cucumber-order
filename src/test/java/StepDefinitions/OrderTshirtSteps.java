package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderTshirtSteps {

    // Adding in the project path to allow project to run from any location
    String projectPath = System.getProperty("user.dir");
    String ItemPrice;
    String OrderItemCountString = "There is 1 item in your cart.";
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
        // Write code here that turns the phrase above into concrete actions
        System.out.println("First function");
        System.setProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.navigate().to("http://automationpractice.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @And("is redirected to the home page")
    public void is_redirected_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Second function");
        driver.findElement(By.id("header_logo")).isDisplayed();
        driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();
        driver.findElement(By.className("login")).isDisplayed();

    }
    @When("The T-Shirt category Tab is Displayed and can be clicked")
    public void the_t_shirt_category_tab_is_displayed_and_can_be_clicked() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Third function");
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a[contains(.,\"T-shirts\")]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a[contains(.,\"T-shirts\")]")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    @Then("the user is redirected to the T-Shirt category page")
    public void the_user_is_redirected_to_the_t_shirt_category_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Fifth function");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[contains(.,\"T-shirts\")]")).isDisplayed();
        driver.findElement(By.className("product-container")).isDisplayed();
    }

    @And("Products are displayed to the user")
    public void products_are_displayed_to_the_user() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.className("product-container")).isDisplayed();
        driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
    }
    @Then("Hovering over a Product Reveals the item add to cart button")
    public void hovering_over_a_product_reveals_the_item_add_to_cart_button() {
        // Write code here that turns the phrase above into concrete actions
        Actions actions = new Actions(driver);
        WebElement listItem = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li"));
        actions.moveToElement(listItem).perform();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//span[contains(.,\"Add to cart\")]")).isDisplayed();
        ItemPrice = driver.findElement(By.className("content_price")).getText();
        System.out.println(ItemPrice);
        //Assert.assertTrue(!ItemPrice.equals("0.00"));
        driver.findElement(By.xpath("//*//span[contains(.,\"Add to cart\")]")).click();


    }
    @And("User is able to click on the Add to Cart button")
    public void user_is_able_to_click_on_the_add_to_cart_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//*//span[contains(.,\"Add to cart\")]")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).isEnabled();
        String OrderPrice = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).getText();
        System.out.println(OrderPrice);
        driver.findElement(By.xpath("//*//h2/span[contains(.,\"There is 1 item in your cart.\")]")).isDisplayed();
        String ItemCount = driver.findElement(By.xpath("//*//h2/span[contains(.,\"There is 1 item in your cart.\")]")).getText();
        //Assert.assertEquals(ItemCount,OrderItemCountString);
        //Assert.assertEquals(OrderPrice,ItemPrice);
    }
    @Then("Click on the Proceed to Checkout button")
    public void click_on_the_proceed_to_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
        js.executeScript("window.scrollBy(0,100)");
        clickCheckout();
    }
    private void clickCheckout(){
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//a[contains(.,\"Proceed to checkout\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a[contains(.,\"Proceed to checkout\")]")).click();
    }
    private void clickSummaryCheckout(){
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//p[2]/a[contains(.,\"Proceed to checkout\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//p[2]/a[contains(.,\"Proceed to checkout\")]")).click();
    }
    private void clickAddressCheckout(){

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//p/button[contains(.,\"Proceed to checkout\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//p/button[contains(.,\"Proceed to checkout\")]")).click();
    }

    @Then("Verify the user is redirected to the Shopping-Cart Summary page")
    public void verify_the_user_is_redirected_to_the_Shopping_Cart_Summary_page(){

        driver.findElement(By.id("cart_title")).isDisplayed();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        clickSummaryCheckout();

    }
    @And("Signin With a default user account on Authentication page")
    public void signin_With_a_default_user_account_on_authentication_page(){


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

        driver.findElement(By.id("SubmitCreate")).isDisplayed();
        driver.findElement(By.id("SubmitCreate")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @And("Create a new user account by adding in Personal details")
    public void create_a_new_user_account_by_adding_in_personal_details(){

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
    @Then("Click on the Register button")
    public void click_on_the_register_button(){

        driver.findElement(By.xpath("")).isDisplayed();
        driver.findElement(By.xpath("")).click();



    }

    @And("Enter user address")
    public void enter_user_address_on_signin(){

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
        js.executeScript("window.scrollBy(0,700)");
        clickAddressCheckout();
    }
    @Then("Confirm Shipping")
    public void confirm_shipping_address(){
        driver.findElement(By.id("cgv")).isDisplayed();
        driver.findElement(By.id("cgv")).isEnabled();
        driver.findElement(By.id("cgv")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("cgv")).isSelected();
        clickAddressCheckout();
    }
    @And("Complete Payment via bank")
    public void complete_payment_via_bank(){

        driver.findElement(By.className("bankwire")).isDisplayed();
        driver.findElement(By.className("bankwire")).isEnabled();
        driver.findElement(By.className("bankwire")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Then("Confirm Order")
    public void confirm_order(){
        driver.findElement(By.className("module-bankwire-payment")).isDisplayed();
        driver.findElement(By.xpath("//*//button[contains(.,\"I confirm my order\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//button[contains(.,\"I confirm my order\")]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*//h1[contains(.,\"Order confirmation\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//h1[contains(.,\"Order confirmation\")]")).click();

    }

    @Then("Return User to Home Page")
    public void return_user_to_home_page(){
        driver.findElement(By.xpath("//*//a[contains(@title,\"My Store\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a[contains(@title,\"My Store\")]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.getCurrentUrl().contains("http://automationpractice.com/index.php");
        driver.close();
        driver.quit();
    }

    @Then("Go to User Personal information page")
    public void go_to_personal_information_page(){
        driver.findElement(By.xpath("//*//a[contains(.,\"My personal information\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a[contains(.,\"My personal information\")]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @And("Update Users Firstname")
    public void update_firstname(){
        driver.findElement(By.xpath("//*//h1[contains(.,\"Your personal information\")]")).isDisplayed();
        driver.findElement(By.id("firstname")).isDisplayed();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).sendKeys(UpdatedName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @And("Update User password")
    public void update_password(){
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

        driver.findElement(By.xpath("//*//p[contains(.,\"Your personal information has been successfully updated.\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a/span[contains(.,\"Home\")]")).isDisplayed();
        driver.findElement(By.xpath("//*//a/span[contains(.,\"Home\")]")).isEnabled();
        driver.findElement(By.xpath("//*//a/span[contains(.,\"Home\")]")).click();

    }
    @And("New name is displayed to the user on the home page")
    public void new_name_displayed_to_user(){

        driver.getCurrentUrl().contains("http://automationpractice.com/index.php");
        String namePath = "//*//a/span[contains(.,\""+UpdatedName+" "+ Lastname +"\")]";
        System.out.println(namePath);
        driver.findElement(By.xpath(namePath)).isDisplayed();
        driver.close();
        driver.quit();
    }
}
