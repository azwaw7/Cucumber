package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMsteps {
    WebDriver driver ;

    public void getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("^I launche chrome Browser$")
    public void i_launche_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("^I open orange hrm url$")
    public void i_open_orange_hrm_url() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

    }

    @Then("^I verify that logo present on page$")
    public void i_verify_that_logo_present_on_page() {
     Boolean status =   driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
        Assert.assertEquals(true,status);
    }

    @Then("^close browser$")
    public void close_browser() {
        driver.quit();

    }

}
