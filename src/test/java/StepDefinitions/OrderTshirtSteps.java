package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTshirtSteps {

    @Given("the user opens the browser to the ordering site")
    public void the_user_opens_the_browser_to_the_ordering_site() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("First function");
         
    }
    @And("is redirected to the home page")
    public void is_redirected_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Second function");
         
    }
    @When("The user is Displayed the {string} category Tab")
    public void the_user_is_displayed_the_category_tab(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Third function");
         
    }
    @And("Click on the T-Shirt Category button")
    public void click_on_the_t_shirt_category_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Fourth function");
         
    }
    @Then("the user is redirected to the {string} category page")
    public void the_user_is_redirected_to_the_category_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Fifth function");
         
    }

}
