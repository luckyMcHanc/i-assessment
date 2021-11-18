package org.example.service;


import io.restassured.response.Response;
import org.example.helper.ApiHelper;
import org.json.JSONObject;

public class ApiServices extends ApiHelper {
    public static Response randomDog(String path){
        return getDogApi().get(path);
    }

    public static Response getPet(String path){
        return getPetApi().get(path);
    }
    public static Response postPet(String path, String name, String status){

        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("status", status);

        return getPetApi().body(object.toString()).post(path);}
}
