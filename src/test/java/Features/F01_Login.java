package Features;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Pages.P03_SuccessfullLoginAsser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F01_Login {
    ChromeDriver driver;
    P01_HomePage Hp;
    P02_LoginPage Lp;
    P03_SuccessfullLoginAsser Ap;

    @BeforeMethod
    void setUP(){
        driver = new ChromeDriver();
        Hp = new P01_HomePage(driver);
        Lp = new P02_LoginPage(driver);
        Ap = new P03_SuccessfullLoginAsser(driver);
        driver.get("https://the-internet.herokuapp.com");
        Hp.clickFormAuth();
    }
    @Test
    void ValidLogin(){
        Lp.login("tomsmith", "SuperSecretPassword!");
        Ap.AssertsuccessfulLogin();
    }
    @Test(priority = 1)
    void InvalidLogin(){
        Lp.login("tomsmith","1234");
        Lp.AssertPasswordFailure();
    }

    @AfterMethod
    void cleanUp(){
        driver.quit();
    }
}
