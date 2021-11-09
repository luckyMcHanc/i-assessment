package assessment;

import Models.DogList;
import Models.RandomDog;
import Models.SubDog;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import services.ApiServices;



public class dogApi extends ApiServices {

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
        // Write code here that turns the phrase above into concrete actions
        response = randomDog("/breed/bulldog/list");
         subDog= gson().fromJson(response.body().prettyPrint(), SubDog.class);

    }

    @When("^I get a response$")
    public void i_get_a_responsw() throws Exception {
        Assert.assertEquals(subDog.getStatus(), "success");
    }
}
