package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class P06_DropdownPage {
    WebDriver driver;
    public P06_DropdownPage(WebDriver d){
        this.driver = d;
    }

    private final By dropdownloc = By.id("dropdown");
    private final By optionloc = By.cssSelector("option[value=\"2\"]");

    public void AssertDropDown(){
        boolean actual = driver.findElement(optionloc).isDisplayed();
        Assert.assertTrue(actual);
    }

    public void selectOption(){
        Select sel =new Select(driver.findElement(dropdownloc));
        sel.selectByVisibleText("Option 2");
    }
}
