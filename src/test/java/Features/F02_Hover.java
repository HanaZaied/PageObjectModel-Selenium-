package Features;

import Pages.P01_HomePage;
import Pages.P04_HoverPage;
import Pages.P05_HoverAssertPage;
import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(TestNG_Listeners.Listeneres.class)

public class F02_Hover {
    ChromeDriver driver;
    P01_HomePage Hp;
    P04_HoverPage HvP;
    P05_HoverAssertPage Avp;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        Hp = new P01_HomePage(driver);
        HvP = new P04_HoverPage(driver);
        Avp = new P05_HoverAssertPage(driver);
        driver.get("https://the-internet.herokuapp.com/hovers");
        Hp.clickHoversLink();
    }

    @Test
    @Epic("Product Epic")
    @Feature("Checkout Feature")
    @Description("Test that user can hover on image")
    @Severity(SeverityLevel.BLOCKER)
    void testHover(){
        HvP.hoverOnImage();
        HvP.clickViewProfile();
        Avp.AssertHover();
    }
}
