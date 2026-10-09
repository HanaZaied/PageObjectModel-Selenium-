package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class P04_HoverPage {
    WebDriver driver;
    public P04_HoverPage(WebDriver d){
        this.driver = d;
    }

    private final By imageloc = By.xpath("//img[@src=\"/img/avatar-blank.jpg\"]");
    private final By viewProfileloc = By.linkText("View profile");

    public void hoverOnImage(){
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(imageloc)).perform();
    }

    public void clickViewProfile(){
        driver.findElement(viewProfileloc).click();
    }
}
