package stepDefinitions;

import org.openqa.selenium.WebDriver;
import page_objects.AddCustomerpage;
import org.apache.commons.lang3.RandomStringUtils;
import page_objects.Loginpage;
import page_objects.SearcheCustomer_page;

import java.util.random.RandomGenerator;

public class BaseClass {
    public WebDriver driver;
    public Loginpage lp;
    public AddCustomerpage addCust;
    public SearcheCustomer_page searcheCustomer;
// Created for generating randome string for Unique  email
    public static  String randomestring(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return generatedString1;
    } 
}
