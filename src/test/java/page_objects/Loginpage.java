package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    public WebDriver driver;
    @FindBy(css = "button[class='button-1 login-button']") @CacheLookup
    WebElement loginBUtton;
    @FindBy(id = "Email")  private WebElement loginEmailBox;
    @FindBy(id = "Password") private  WebElement loginPasswordBox;
    @FindBy(xpath = "//*[@id='navbarText']/ul/li[3]/a") private WebElement LogoutLink;

    public Loginpage(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }




    public void setLoginEmailBox(String username) {
        loginEmailBox.clear();
        loginEmailBox.sendKeys(username);
    }

    public void setLoginPasswordBox(String password) {
        loginPasswordBox.clear();
        loginPasswordBox.sendKeys(password);

    }

    public void setLoginBUtton() {
        loginBUtton.click();
    }

    public void setLogoutLink() {
        LogoutLink.click();

    }
}
