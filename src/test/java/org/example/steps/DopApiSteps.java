package org.example.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.example.Models.DogList;
import org.example.Models.RandomDog;
import org.example.Models.SubDog;
import org.example.service.ApiServices;
import org.junit.Assert;

public class DopApiSteps  extends ApiServices {
    private Response response;
    private RandomDog randomDog;
    private SubDog subDog;
    private DogList dogList;

    @When("^searching a random breed$")
    public void searching_a_random_breed() throws Exception {
        response = randomDog("/breeds/image/random/");
        randomDog = gson().fromJson(response.body().prettyPrint(), RandomDog.class);
    }

    @When("^a success message comes through$")
    public void a_success_message_cames_through() throws Exception {
        Assert.assertEquals(randomDog.getStatus(), "success");

    }

    @When("^searching for a \"([^\"]*)\"$")
    public void searching_for_a(String arg1) throws Exception {
        response = randomDog("/breed/"+arg1+"/images/random");
        randomDog = gson().fromJson(response.body().prettyPrint(), RandomDog.class);
    }

    @When("^its found$")
    public void its_found() throws Exception {
        Assert.assertEquals(randomDog.getStatus(), "success");
    }

    @When("^retrieving all sub-breeds for bulldogs$")
    public void retrieving_all_sub_breeds_for_bulldogs() throws Exception {
        response = randomDog("/breed/bulldog/list");
        subDog= gson().fromJson(response.body().prettyPrint(), SubDog.class);

    }

    @When("^I get a response$")
    public void i_get_a_responsw() throws Exception {
        Assert.assertEquals(subDog.getStatus(), "success");
    }
}
