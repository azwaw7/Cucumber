package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.AddCustomerpage;
import page_objects.Loginpage;
import page_objects.SearcheCustomer_page;

import java.time.Duration;

public class Loginstep extends BaseClass {

    @Given("User launche chrome Browser")
    public void user_launche_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        lp = new Loginpage(driver);

    }

    @When("User opens URL as {string}")
    public void user_opens_url_as(String URL) {
        driver.navigate().to(URL);

    }

    @When("User entre Email as {string} and Password as {string}")
    public void user_entre_email_as_and_password_as(String email, String password) {
        lp.setLoginEmailBox(email);
        lp.setLoginPasswordBox(password);

    }

    @When("Click login")
    public void click_login() {
        lp.setLoginBUtton();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.assertTrue(false);
        }else {
            Assert.assertEquals(title,driver.getTitle());
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.setLogoutLink();
        Thread.sleep(3000);

    }@Then("close browser")
    public void close_browser(){
        driver.quit();

    }
    // customer feature step definitions .......................................
    @Then("User can view Dashbord")
    public void user_can_view_dashbord() {
        addCust = new AddCustomerpage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getTitel());

    }

    @When("User click on customer Menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        Thread.sleep(3000);
        addCust.setCustomersLinkMenu();

    }

    @When("click on customer Menu item")
    public void click_on_customer_menu_item() {
        addCust.setCustomerItem();

    }

    @When("click on add new button")
    public void click_on_add_new_button() throws InterruptedException {
        addCust.setAddNewButton();
        Thread.sleep(3000);

    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getTitel());

    }

    @When("User entre customer info")
    public void user_entre_customer_info() throws InterruptedException {
        String email = randomestring()+"@gmail.com";
        addCust.setEmailBoxForNewCustomerBox(email);
        addCust.setPasswordForNewCustomerBOx("admin123");
        addCust.setNewCustomerNameBox("karim");
        addCust.setNewCustomerLastNameBox("karo");
        addCust.setNewCustomerGendrMalChekBox("male");
        addCust.setNewCutomerbirthDateBox("02/05/1998");
        addCust.setCheckBoxIsTaxExempt();
//        addCust.setCustomerroles();
        addCust.setManagerOfVendorBox("Vendor 2");
//        addCust.setActiveCheckBox();
        addCust.setAdminCommentBox("I am new admin my name is karim and I am QA Lead");

        Thread.sleep(3000);


    }

    @When("click on save")
    public void click_on_save() throws InterruptedException {
        addCust.setSaveButoon();
        Thread.sleep(3000);

    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));

    }

// steps for searche a customer by emailID
@When("Enter customer Email")
public void enter_customer_email() {
        searcheCustomer= new SearcheCustomer_page(driver);
        searcheCustomer.setSearchEmail("victoria_victoria@nopCommerce.com");

}

    @When("Click on searche button")
    public void click_on_searche_button() throws InterruptedException {
        searcheCustomer.clickSearcheButton();
        Thread.sleep(3000);

    }

    @Then("User should found Email in the Searche table")
    public void user_should_found_email_in_the_searche_table() {
        boolean status = searcheCustomer.searcheByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true,status);


    }
    //Search customer by firstname and last name
    @Then("Entre Customer Firstname")
    public void entre_customer_firstname() {
        searcheCustomer= new SearcheCustomer_page(driver);
        searcheCustomer.setSearchFirstName("Victoria");

    }

    @Then("entre Customer LastName")
    public void entre_customer_last_name() {
        searcheCustomer.setSearchLastName("Terces");

    }

    @Then("User should found Name in the Search tabel")
    public void user_should_found_name_in_the_search_tabel() {
        Boolean satuts = searcheCustomer.searcheByName("Victoria Terces");
       Assert.assertEquals(true,satuts);

    }






}
