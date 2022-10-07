package page_objects;

import Utilities.WaitHelpr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class SearcheCustomer_page {
    WebDriver driver;
    WaitHelpr waitHelpr;

    public SearcheCustomer_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitHelpr = new WaitHelpr(driver);
    }
    @FindBy(how = How.ID,using = "SearchEmail") @CacheLookup
    WebElement searchEmail;
    @FindBy(how = How.ID,using = "SearchFirstName") @CacheLookup WebElement searchFirstName;
    @FindBy(how = How.ID,using = "SearchLastName") @CacheLookup WebElement searchLastName;
    @FindBy(how = How.ID,using = "SearchMonthOfBirth") @CacheLookup WebElement searchMonthOfBirth;
    @FindBy(how = How.ID,using = "SearchDayOfBirth") @CacheLookup WebElement searchDayOfBirth;
    @FindBy(how = How.ID,using = "SearchCompany") @CacheLookup WebElement searchCompany;
    @FindBy(how = How.ID,using = "SearchIpAddress") @CacheLookup WebElement searchIpAddress;
    @FindBy(how = How.CSS,using = "tr[role='row']") @CacheLookup
    List<WebElement> tableRows;
    @FindBy(how = How.CSS,using = "td[class=' text-center']") @CacheLookup
    List<WebElement> tableColumns;
   @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']") @CacheLookup  WebElement
    table;
    @FindBy(id = "search-customers") @CacheLookup WebElement searcheButton;


    public void setSearchEmail(String email){
        waitHelpr.waitForElement(searchEmail, Duration.ofSeconds(30));
        searchEmail.clear();
        searchEmail.sendKeys(email);


    }


    public void setSearchFirstName(String firstName) {
        waitHelpr.waitForElement(searchFirstName, Duration.ofSeconds(30));
        searchFirstName.clear();
        searchFirstName.sendKeys(firstName);
    }

    public void setSearchLastName(String lastName) {
        waitHelpr.waitForElement(searchLastName,Duration.ofSeconds(30));
        searchLastName.clear();
        searchLastName.sendKeys(lastName);
    }
    public void clickSearcheButton(){
        searcheButton.click();
        waitHelpr.waitForElement(searcheButton,Duration.ofSeconds(10));
    }

    public int setTableRows() {
        return (tableRows.size());
    }
    public int setTableColumns(){
        return (tableColumns.size());
    }

    public boolean searcheByEmail(String email) {
        boolean flag = false;
        for (int i = 1; i < setTableRows(); i++) {
            String emailID = table.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();

           if (emailID.equalsIgnoreCase(emailID)){
               flag = true;
           }
        }
        return flag;
    }
    public boolean searcheByName(String Name) {
        boolean flag = false;
        for (int i = 1; i < setTableRows(); i++) {
                String name = table.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
                String names[] = name.split(" ");// seprating fisrtname and lastname
            System.out.println(names);
                if (names[0].equalsIgnoreCase("Victoria") && names[1].equalsIgnoreCase("Terces")) {
                    flag = true;
                }

        }
        return flag;

    }
}

