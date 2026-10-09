package Features;

import Pages.P01_HomePage;
import Pages.P06_DropdownPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F03_DropDown {
    ChromeDriver driver;
    P01_HomePage Hp;
    P06_DropdownPage Dp;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        Hp = new P01_HomePage(driver);
        Dp = new P06_DropdownPage(driver);
        driver.get("https://the-internet.herokuapp.com");
    }
    @Test
    void dropDown(){
        Hp.clickDropDownLink();
        Dp.selectOption();
        Dp.AssertDropDown();
    }

}
