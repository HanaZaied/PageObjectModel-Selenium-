package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class P01_HomePage {
    WebDriver driver;
    public P01_HomePage(WebDriver d){
        this.driver = d;
    }

    private final By FormAuthLoc = By.linkText("Form Authentication");
    private final By HoversLoc = By.linkText("Hovers");
    private final By DropDownLoc = By.linkText("Dropdown");

    public void clickFormAuth(){
        driver.findElement(FormAuthLoc).click();
    }
    public void clickHoversLink(){
        driver.findElement(HoversLoc).click();
    }
    public  void clickDropDownLink(){
        driver.findElement(DropDownLoc);
    }
}
