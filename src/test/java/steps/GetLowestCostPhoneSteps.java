package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pages.GetAPI;
import utils.APIUtils;
import hooks.Hooks;

import java.util.List;

public class GetLowestCostPhoneSteps {

    private Response response;

    @Given("I get all objects")
    public void i_get_all_objects() {
        response = GetAPI.getInstance().getAllObjects();
        Hooks.getTest().info("Fetched all objects");
    }

    @Then("I get the phone with the lowest cost")
    public void i_get_the_phone_with_the_lowest_cost() {
        List<Integer> prices = APIUtils.parseResponse(response).getList("price");
        int minPrice = prices.stream().min(Integer::compareTo).get();
        Hooks.getTest().info("Phone with lowest cost has price: " + minPrice);
    }
}
