package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.sql.Time;
import java.time.Duration;

public class WaitHelpr {
    WebDriver driver;

    public WaitHelpr(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForElement(WebElement element, Duration timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
