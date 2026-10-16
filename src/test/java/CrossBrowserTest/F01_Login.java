package CrossBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class F01_Login {
    WebDriver driver;
    @BeforeMethod
    @Parameters({"browser","websiteURL"})
    void setUp(String browser,String websiteURL){
        if(browser.equals("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }

        driver.get(websiteURL);
    }
    @Test
    void validLogin(){
        WebElement userNameField =  driver.findElement(By.id("username"));  // datatype webelement
        userNameField.sendKeys("tomsmith");

        WebElement userPasswordField = driver.findElement(By.name("password"));
        userPasswordField.sendKeys("SuperSecretPassword!");

        WebElement loginField = driver.findElement(By.className("fa-sign-in"));
        loginField.click();

        // assert , assertequals
        WebElement textloc = driver.findElement(By.xpath("//h4[.=\"Welcome to the Secure Area. When you are done click logout below.\"]"));
        boolean actual = textloc.getText().contains("Welcome to the Secure Area. When you are done click logout below.");

        Assert.assertEquals(actual,true, "apear once failure");
        Assert.assertTrue(actual);
        Assert.assertFalse(actual);
    }
}
