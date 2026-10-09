package Features;

import Pages.P01_HomePage;
import Pages.P04_HoverPage;
import Pages.P05_HoverAssertPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.get("https://the-internet.herokuapp.com");
        Hp.clickHoversLink();
    }

    @Test
    void testHover(){
        HvP.hoverOnImage();
        HvP.clickViewProfile();
        Avp.AssertHover();
    }
}
