package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.GetAPI;
import utils.APIUtils;
import hooks.Hooks;

import java.util.List;

public class GetAllPhoneNamesSteps {

    private Response response;

    @Given("I get all objects")
    public void i_get_all_objects() {
        response = GetAPI.getInstance().getAllObjects();
        Hooks.getTest().info("Fetched all objects");
    }

    @Then("I verify all phone names start with {string}")
    public void i_verify_all_phone_names_start_with(String prefix) {
        List<String> phoneNames = APIUtils.parseResponse(response).getList("name");
        for (String name : phoneNames) {
            Assert.assertTrue(name.startsWith(prefix));
        }
        Hooks.getTest().pass("All phone names start with " + prefix);
    }
}
