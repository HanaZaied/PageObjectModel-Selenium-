package Features;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Pages.P03_SuccessfullLoginAsser;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F01_Login {
    ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
    WebDriver driver;
    P01_HomePage Hp;
    P02_LoginPage Lp;
    P03_SuccessfullLoginAsser Ap;

    @BeforeMethod
    void setUP(){
        driver = ThreadGuard.protect(new ChromeDriver());
        localDriver.set(driver);
        localDriver.get().get("https://the-internet.herokuapp.com/login");

        Hp = new P01_HomePage(localDriver.get());
        Lp = new P02_LoginPage(localDriver.get());
        Ap = new P03_SuccessfullLoginAsser(localDriver.get());


    }
    @Test
    @Epic("Authentication Epic")
    @Feature("Login Feature")
    @Description("Test that user can login with valid credential")
    @Severity(SeverityLevel.CRITICAL)
    void ValidLogin(){
//        Hp.clickFormAuth();
        Lp.login("tomsmith", "SuperSecretPassword!");
        Ap.AssertsuccessfulLogin();
    }
    @Test(priority = 1)
    @Epic("Authentication Epic")
    @Feature("Login Feature")
    @Description("Test that user cannot login with Invalid credential")
    @Severity(SeverityLevel.TRIVIAL)
    void InvalidLogin(){
       Hp.clickFormAuth();
        Lp.login("tomsmith","1234");
        Lp.AssertPasswordFailure();
    }

    @AfterMethod
    void cleanUp(){
        localDriver.get().quit();
    }
}
