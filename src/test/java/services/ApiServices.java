package services;

import helper.ApiHelper;
import io.restassured.response.Response;

public class ApiServices extends ApiHelper {
    public static Response randomDog(String path){
        return getDogApi().get(path);
    }

    public static Response getPet(String path){
        return getPetApi().get(path);
    }
}
