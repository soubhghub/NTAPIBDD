package pages;

import io.restassured.response.Response;

public class PostAPI extends BasePage {

    private static PostAPI instance;

    private PostAPI() {}

    public static PostAPI getInstance() {
        if (instance == null) {
            synchronized (PostAPI.class) {
                instance = new PostAPI();
            }
        }
        return instance;
    }

    public Response postObject(String body) {
        return request.body(body).post();
    }
}
