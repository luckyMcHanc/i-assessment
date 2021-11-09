package assessment;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class WebSite {

    WebDriver driver = null;

    @Given("^I open the ilab website on  \"([^\"]*)\"$")
    public void initialized(String browser) {


        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get("https://www.ilabquality.com/");
        driver.manage().window().maximize();
    }

    @When("^I navigate to the job search$")
    public void nagitator() {
        driver.findElement(By.xpath("//*[@id=\"menu-item-1373\"]/a")).click();
        driver.findElement(By.xpath(" /html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"wpjb-scroll\"]/div[1]/a")).click();

    }

    @And("^enter my details and submit:$")
    public void enter_details(DataTable dataTable)
    {

        Map<String, String> dataMap = dataTable.asMaps(String.class, String.class).get(0);

        driver.findElement(By.xpath("//*[@id=\"applicant_name\"]")).sendKeys(dataMap.get("name"));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(dataMap.get("email"));
        String phNo = 0 + RandomStringUtils.randomNumeric(2) + " " + RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomNumeric(4);
        driver.findElement((By.xpath("//*[@id=\"phone\"]"))).sendKeys(phNo);
        driver.findElement(By.xpath("//*[@id=\"wpjb_submit\"]")).click();
    }

    @Then("^i get an error")
    public void result(){
        String result = driver.findElement(By.xpath("//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul/li")).getText();
        Assert.assertEquals(result, "You need to upload at least one file.");
        driver.quit();
    }

}
