package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P02_LoginPage {
    WebDriver driver;
    public P02_LoginPage(WebDriver d){
        this.driver=d;
    }

    private final By usernameloc = By.cssSelector("#username");
    private final By passwordloc = By.xpath("//input[@name=\"password\"]");
    private final By loginBtnloc = By.className("fa-sign-in");
    private final By errormsgloc = By.className("error");

    public void login(String username, String password){
        driver.findElement(usernameloc).sendKeys(username);
        driver.findElement(passwordloc).sendKeys(password);
        driver.findElement(loginBtnloc).click();
    }

    public void AssertPasswordFailure(){
        boolean actual = driver.findElement(errormsgloc).getText().contains("Your username is invalid!");
        Assert.assertTrue(actual);
    }
}
