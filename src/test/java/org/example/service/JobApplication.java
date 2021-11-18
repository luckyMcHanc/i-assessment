package org.example.service;

import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class JobApplication {

    private static WebDriver driver = null;
    public static void openBrowser(String browser){
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

    public static void navigateToJobSearch() {
        driver.findElement(By.xpath("//*[@id=\"menu-item-1373\"]/a")).click();
        driver.findElement(By.xpath(" /html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a")).click();
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"wpjb-scroll\"]/div[1]/a")).click();
    }

    public static void enterApplicationDetails(DataTable dataTable) {
        Map<Object, Object> dataMap = dataTable.asMaps(String.class, String.class).get(0);

        driver.findElement(By.xpath("//*[@id=\"applicant_name\"]")).sendKeys(dataMap.get("name").toString());
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(dataMap.get("email").toString());
        String phNo = 0 + RandomStringUtils.randomNumeric(2) + " " + RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomNumeric(4);
        driver.findElement((By.xpath("//*[@id=\"phone\"]"))).sendKeys(phNo);
        driver.findElement(By.xpath("//*[@id=\"wpjb_submit\"]")).click();
    }

    public static void getResults() {
        String result = driver.findElement(By.xpath("//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul/li")).getText();
        Assert.assertEquals(result, "You need to upload at least one file.");
        driver.quit();
    }
}
