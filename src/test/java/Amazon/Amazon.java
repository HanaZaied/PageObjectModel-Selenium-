package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Amazon {
    WebDriver driver;

    private final By searchField = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");
    private  final  By searchResloc = By.className("puis-card-border");
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.eg/?&tag=egtxabkgode-21&ref=pd_sl_7p2aq4fe2v_e&adgrpid=152488092398&hvpone=&hvptwo=&hvadid=666798652278&hvpos=&hvnetw=g&hvrand=15802861044207170112&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9253833&hvtargid=kwd-10573980&hydadcr=334_2589534&language=en_AE");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void search(){
        driver.findElement(searchField).sendKeys("laptop");
        driver.findElement(searchButton).click();
        List<WebElement> results = new ArrayList<>();
        results = driver.findElements(searchResloc);

        for(int i=0 ; i < results.size(); i++){
            String text = results.get(i).getText().toLowerCase();

            softAssert.assertTrue(text.contains("laptop"),
                    "product number: " +i);
        }
        softAssert.assertAll();

    }




}
