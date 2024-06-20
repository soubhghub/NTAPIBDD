package pages;

import io.restassured.response.Response;

public class PutAPI extends BasePage {

    private static PutAPI instance;

    private PutAPI() {}

    public static PutAPI getInstance() {
        if (instance == null) {
            synchronized (PutAPI.class) {
                instance = new PutAPI();
            }
        }
        return instance;
    }

    public Response putObject(String id, String body) {
        return request.body(body).put("/" + id);
    }
}
