package org.example.steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import org.example.service.JobApplication;

public class SubmitApplicationSteps {


    @Given("^I open the ilab website on  \"([^\"]*)\"$")
    public static void initialized(String browser) {
        JobApplication.openBrowser(browser);
    }

    @When("^I navigate to the job search$")
    public void navigator() {
        JobApplication.navigateToJobSearch();
    }

    @And("^enter my details and submit:$")
    public void enter_details(DataTable dataTable)
    {
        JobApplication.enterApplicationDetails(dataTable);
    }

    @Then("^i get an error")
    public void result(){
        JobApplication.getResults();
    }
}
