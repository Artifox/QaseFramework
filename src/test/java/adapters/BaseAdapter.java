package adapters;

import com.google.gson.Gson;
import models.APIResponse;
import org.testng.Assert;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    public static final String TOKEN = System.getenv().getOrDefault("API_TOKEN", PropertyReader.getProperty("API_TOKEN"));
    public static final String URL = "https://api.qase.io/";
    Gson gson = new Gson();

    public String post(String body, String uri, int status) {
        return given().
                header("Token", TOKEN).
                header("Content-Type", "application/json").
                body(body).
                when().
                post(URL + uri).
                then().
                log().all().
                statusCode(status).
                extract().body().asString();
    }

    public String get(String uri, int status) {
        return given().
                header("Token", TOKEN).
                header("Content-Type", "application/json").
                when().
                get(URL + uri).
                then().
                log().all().
                statusCode(status).
                extract().body().asString();
    }

    public String delete(String uri, int status) {
        return given().
                header("Token", TOKEN).
                header("Content-Type", "application/json").
                when().
                delete(URL + uri).
                then().
                log().all().
                statusCode(status).
                extract().body().asString();
    }

    public void checkStatus(String response, boolean expectedResult) {
        APIResponse apiResponse = gson.fromJson(response, APIResponse.class);
        Assert.assertEquals(apiResponse.isStatus(), expectedResult, "Response status is not correct");
    }
}
