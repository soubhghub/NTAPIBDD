package pages;

import io.restassured.response.Response;

public class DeleteAPI extends BasePage {

    private static DeleteAPI instance;

    private DeleteAPI() {}

    public static DeleteAPI getInstance() {
        if (instance == null) {
            synchronized (DeleteAPI.class) {
                instance = new DeleteAPI();
            }
        }
        return instance;
    }

    public Response deleteObject(String id) {
        return request.delete("/" + id);
    }
}
