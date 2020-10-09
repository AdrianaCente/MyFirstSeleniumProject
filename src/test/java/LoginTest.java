import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    public LoginTest() {}

    LoginTest(WebDriver driver) {
      this.driver = driver;
    }

    @Test
    public void loginWithIncorrectCredentials() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();;
        driver.findElement(By.cssSelector("#email")).sendKeys("someoneelse@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("#send2")).click();
    }

//   11. Adăugați în clasa LoginTest un test în care să automatizați pașii necesari pentru logarea cu succes a unui utilizator.
    @Test
    public void loginWithCorrectCredentials() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper > a")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();;
        driver.findElement(By.cssSelector("#email")).sendKeys("someoneelse@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("1234567");
        driver.findElement(By.cssSelector("#send2")).click();

        String helloText = driver.findElement(By.cssSelector("p.hello > strong")).getText();
        Assert.assertEquals("Hello, Emma Thomson!", helloText);
        Assert.assertTrue(helloText.equals("Hello, Emma Thomson!"));
    }

    @Before
    public void invokeDriver() {
        InvokeBrowser invoke = new InvokeBrowser();
        driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");
    }

    @After
    public void quitTest() {
        driver.quit();
    }
}
