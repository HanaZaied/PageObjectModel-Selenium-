package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class P03_SuccessfullLoginAsser {
    WebDriver driver;
    public P03_SuccessfullLoginAsser(WebDriver d){
        this.driver = d;
    }

    private final By logoutBtnloc = By.className("button");
    private final By textloc = By.id("flash");

    public void AssertsuccessfulLogin(){
        SoftAssert soft = new SoftAssert();
        boolean actual = driver.findElement(logoutBtnloc).isDisplayed();
        soft.assertTrue(actual);
        boolean actual2 = driver.findElement(textloc).getText().contains(" You logged into a secure area!");
        soft.assertTrue(actual2);
        soft.assertAll();
    }
}
