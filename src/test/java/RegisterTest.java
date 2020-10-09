import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class RegisterTest {

    private WebDriver driver;

//   8. Adăugați în clasa RegisterTest un test(o noua metoda) în care să automatizați pașii necesari pentru
//   înregistrarea cu succes a unui utilizator nou (deschideți homepage-ul, apăsați pe Account, apăsați pe Register,
//   completați toate câmpurile de pe pagina Register - atenție ca email-ul să fie unic, bifați opțiunea pentru
//   primirea newsleterr-ului). Folosiți identificatori diferiți pentru câmpurile de pe pagina Register
//   (id, name, className). Pe viitor, după învățarea altor identificatori, veți reveni pentru a apăsa și butonul Register.
//   Apelati metoda aceasta in metoda main din clasa pentru a rula testul.

    @Before
    public void invokeDriver() {
        InvokeBrowser invoke = new InvokeBrowser();
        driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registerWithValidDetails() {
        String accountSelector = "div.account-cart-wrapper > a";

        driver.findElement(By.cssSelector(accountSelector)).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("firstname")).sendKeys("Emma");
        driver.findElement(By.id("lastname")).sendKeys("Thomson");
        driver.findElement(By.id("email_address")).sendKeys("someoneelsetest@googl.com");
        driver.findElement(By.name("password")).sendKeys("1234567");
        driver.findElement(By.name("confirmation")).sendKeys("1234567");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        String checkValue = driver.findElement(By.cssSelector("div.page-title h1")).getText();
        Assert.assertEquals("MY DASHBOARD", checkValue);
    }

    @Test
    public void registerWithUnmatchedPasswords() {
        String accountSelector = "div.account-cart-wrapper > a";

        driver.findElement(By.cssSelector(accountSelector)).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("firstname")).sendKeys("Emma");
        driver.findElement(By.id("lastname")).sendKeys("Thomson");
        driver.findElement(By.id("email_address")).sendKeys("someoneelse@ya.com");
        driver.findElement(By.name("password")).sendKeys("1234567");
        driver.findElement(By.name("confirmation")).sendKeys("123");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        String checkValue = driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation")).getText();
        Assert.assertEquals("Please make sure your passwords match.", checkValue);
    }

    @Test
    public void registerWithTheSameEmail() {
        String accountSelector = "div.account-cart-wrapper > a";

        driver.findElement(By.cssSelector(accountSelector)).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("firstname")).sendKeys("Emma");
        driver.findElement(By.id("lastname")).sendKeys("Thomson");
        driver.findElement(By.id("email_address")).sendKeys("someoneelse@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("1234567");
        driver.findElement(By.name("confirmation")).sendKeys("1234567");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        String checkValue = driver.findElement(By.cssSelector("li.error-msg span")).getText().split("\\. ")[0];
        Assert.assertEquals("There is already an account with this email address", checkValue);
    }

    @After
    public void quitTest() {
        driver.quit();
    }
}
