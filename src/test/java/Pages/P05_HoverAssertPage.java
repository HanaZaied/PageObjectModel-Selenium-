package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P05_HoverAssertPage {
    WebDriver driver;
    public P05_HoverAssertPage(WebDriver d){
        this.driver=d;
    }

    private final By notFoundloc = By.tagName("h1");

    public void AssertHover(){
        boolean actual = driver.findElement(notFoundloc).isDisplayed();
        Assert.assertTrue(actual);
    }
}
