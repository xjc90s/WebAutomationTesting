import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PhpTravelsNet{
    WebDriver driver = null;
    @Before
    public void setup(){
    WebDriver driver = new ChromeDriver();
    }
    @Test
    public void LoadPhpTravelsNet() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get("https://www.phptravels.net/");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
