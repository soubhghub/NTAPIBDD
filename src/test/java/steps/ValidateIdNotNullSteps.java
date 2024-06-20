package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.GetAPI;
import utils.APIUtils;
import hooks.Hooks;

import java.util.List;

public class ValidateIdNotNullSteps {

    private Response response;

    @Given("I get all objects")
    public void i_get_all_objects() {
        response = GetAPI.getInstance().getAllObjects();
        Hooks.getTest().info("Fetched all objects");
    }

    @Then("I verify ID is not null")
    public void i_verify_ID_is_not_null() {
        List<String> ids = APIUtils.parseResponse(response).getList("id");
        for (String id : ids) {
            Assert.assertNotNull(id);
        }
        Hooks.getTest().pass("All IDs are not null");
    }
}
