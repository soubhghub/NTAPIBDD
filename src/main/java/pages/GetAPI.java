package pages;

import io.restassured.response.Response;

public class GetAPI extends BasePage {

    private static GetAPI instance;

    private GetAPI() {}

    public static GetAPI getInstance() {
        if (instance == null) {
            synchronized (GetAPI.class) {
                instance = new GetAPI();
            }
        }
        return instance;
    }

    public Response getAllObjects() {
        return request.get();
    }
}
