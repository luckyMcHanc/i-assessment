package helper;

import java.net.URI;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;


public class ApiHelper {
    private static String dogApi = "https://dog.ceo/api";
    private static String petApi = "https://petstore.swagger.io";

    protected static RequestSpecification getDogApi(){
        RestAssured.baseURI = URI.create(dogApi).toString();
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json;charset=UTF-8");
    }

    protected static RequestSpecification getPetApi(){
        RestAssured.baseURI = URI.create(petApi).toString();
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json;charset=UTF-8");
    }

    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gson(gsonBuilder);
        return gson;
    }

    public static Gson gson(GsonBuilder gsonBuilder) {
        Gson gson = gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        return gson;
    }

}
