import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    public void loginWithIncorrectCredentials() {
        InvokeBrowser invoke = new InvokeBrowser();
        WebDriver driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();;
        driver.findElement(By.cssSelector("#email")).sendKeys("someoneelse@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.quit();
    }

//   11. Adăugați în clasa LoginTest un test în care să automatizați pașii necesari pentru logarea cu succes a unui utilizator.
    public void loginWithCorrectCredentials() {
        InvokeBrowser invoke = new InvokeBrowser();
        WebDriver driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();;
        driver.findElement(By.cssSelector("#email")).sendKeys("someoneelse@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("1234567");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.quit();
    }
}
