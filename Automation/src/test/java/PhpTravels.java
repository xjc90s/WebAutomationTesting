import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PhpTravels{
    @Test
    public void testGoogleSearch() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        try{
            WebDriver driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get("https://www.phptravels.com/");
            // Store the current window handle
            String winHandleBefore = driver.getWindowHandle();

            Thread.sleep(5000);  // Let the user actually see something!
            WebElement login = driver.findElement(By.linkText("Login"));
            login.click();
            // Switch to new window opened
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username"))));
            WebElement email =  driver.findElement(By.name("username"));
            email.sendKeys("user@phptravels.com");
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("demouser");
            WebElement checkbox = driver.findElement(By.name("rememberme"));
            checkbox.click();
            WebElement captchaLogin = driver.findElement(By.xpath(("//*[@role='presentation']")));
            captchaLogin.click();
            Thread.sleep(5000);  // Let the user actually see something!
            WebElement submit = driver.findElement(By.id("login"));
            submit.submit();
// Switch back to original browser (first window)
            driver.switchTo().window(winHandleBefore);
            driver.quit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
