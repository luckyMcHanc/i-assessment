package org.example.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.example.helper.Printer;
import org.example.helper.SearchPet;
import org.example.service.ApiServices;
import org.json.JSONObject;
import org.junit.Assert;

public class PetStoreSteps extends ApiServices {
    static private Response response;
    static private String newPetID;
    @When("you retrieve the list of pets")
    public static void you_retrieve_the_list_of_pets() {
        response = getPet("v2/pet/findByStatus?status=available");

    }

    @And("Confirm if {string} with {string} exist")
    public void confirm_if_with_exist(String name, String id) {

        int petFound = SearchPet.pet(response, name, id);
        Assert.assertEquals(1, petFound);
    }

    @When("you add a new pet")
    public void you_add_a_new_pet() {

        String name = SearchPet.generateName();
        response = postPet("/v2/pet/", name, "available");
        Assert.assertEquals(200, response.getStatusCode());
        JSONObject result = new JSONObject(response.getBody().prettyPrint());
        newPetID = result.get("id").toString();
        Printer.print(newPetID);
    }

    @When("Confirm the new pet is added")
    public void confirm_the_new_pet_is_added() {

        response = getPet("v2/pet/"+newPetID);
        Assert.assertEquals(200, response.getStatusCode());
    }
}
