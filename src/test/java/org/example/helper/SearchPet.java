package org.example.helper;


import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.Random;

public class SearchPet {

    public static int pet(Response response, String name, String id) {

        JSONArray array = new JSONArray(response.getBody().print());
        int res = 0;
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = new JSONObject(array.get(i).toString());
            if (object.has("name") && object.get("name").equals(name) && object.has("category")) {
                JSONObject innerObject = new JSONObject(object.get("category").toString());
                if (innerObject.get("id").toString().equalsIgnoreCase(id))
                    res = 1;
            }
        }
        return res;
    }

    public static String generateName() {

        int start = 97;
        int end = 122;
        int targetStringLength = 5;
        Random random = new Random();

        return random.ints(start, end + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
