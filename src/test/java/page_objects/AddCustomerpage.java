package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddCustomerpage {


    public WebDriver driver;
    @FindBy(id = "Email")  private WebElement loginEmailBox;
    @FindBy(id = "Password") private  WebElement loginPasswordBox;
    @FindBy(linkText = "Customers") private WebElement CustomersLinkMenu;
    @FindBy(xpath = "//ul/li[4]/ul/li[1]/a/p") private  WebElement customerItem;
    @FindBy(xpath = "//form[1]/div/div/a/i") private WebElement addNewButton;
    @FindBy(id = "Email") private  WebElement emailBoxForNewCustomerBox;
    @FindBy(id = "Password") private WebElement passwordForNewCustomerBOx;
    @FindBy(id = "FirstName") private WebElement newCustomerNameBox;
    @FindBy(id = "LastName") private  WebElement newCustomerLastNameBox;
    @FindBy(id = "Gender_Male") private WebElement newCustomerGendrMalChekBox;
    @FindBy(id = "DateOfBirth") private  WebElement newCutomerbirthDateBox;
    @FindBy(id = "IsTaxExempt") private  WebElement checkBoxIsTaxExempt;
    @FindBy(css = "div[class='k-multiselect-wrap k-floatwrap']") private List<WebElement> customerroles;
    @FindBy(xpath = "//*[@id=\"VendorId\"]") private WebElement managerOfVendorBox;
    @FindBy(id = "Active") private WebElement activeCheckBox;
    @FindBy(id = "AdminComment") private WebElement adminCommentBox;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/div[1]/div/button[1]") private WebElement saveButoon;
    @FindBy(id = "Gender_Female") private  WebElement newCustomerFemaleGender;
    @FindBy(xpath= "//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]") private WebElement optionRole;
    public AddCustomerpage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public String getTitel(){
        return driver.getTitle();
    }


    public void setCustomersLinkMenu() {
        CustomersLinkMenu.click();
    }

    public void setCustomerItem() {
        customerItem.click();
    }

    public void setAddNewButton() {
        addNewButton.click();
    }

    public void setEmailBoxForNewCustomerBox(String emailBoxForNewCustomer) {
        emailBoxForNewCustomerBox.sendKeys(emailBoxForNewCustomer);
    }

    public void setPasswordForNewCustomerBOx(String passwordForNewCustomer) {
        passwordForNewCustomerBOx.sendKeys(passwordForNewCustomer);
    }

    public void setNewCustomerNameBox(String newCustomerFName) {
        newCustomerNameBox.sendKeys(newCustomerFName);
    }

    public void setNewCustomerLastNameBox(String newCustomerLastName) {
        newCustomerLastNameBox.sendKeys(newCustomerLastName);
    }

    public void setNewCustomerGendrMalChekBox(String gendre) {
        if (gendre.equalsIgnoreCase("male")){
            newCustomerGendrMalChekBox.click();
        } else if (gendre.equalsIgnoreCase("female")) {
            newCustomerFemaleGender.click();
            
        } else {
            newCustomerGendrMalChekBox.click();
        }
    }

    public void setNewCutomerbirthDateBox(String dateOfBirth) {
        newCutomerbirthDateBox.sendKeys(dateOfBirth);
    }

    public void setCheckBoxIsTaxExempt() {
        checkBoxIsTaxExempt.click();
    }

//    public void setCustomerroles() {
////       customerroles.get(1).click();
////        optionRole.click();
//        WebElement element = driver.findElement(By.id("Terms1"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].click();", customerroles,optionRole );
//    }

    public void setManagerOfVendorBox(String Value) {
       Select select = new Select(managerOfVendorBox);
       select.selectByVisibleText(Value);
    }

//    public void setActiveCheckBox() {
//        activeCheckBox.click();
//    }

    public void setAdminCommentBox(String adminComment) {
        adminCommentBox.click();
    }

    public void setSaveButoon() {
        saveButoon.click();
    }
}
