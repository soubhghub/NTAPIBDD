package pages;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import config.ConfigManager;

public class BasePage {
    protected RequestSpecification request;

    public BasePage() {
        RestAssured.baseURI = ConfigManager.getInstance().getProperty("endpoint");
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }
}
