import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterTest {

//   8. Adăugați în clasa RegisterTest un test(o noua metoda) în care să automatizați pașii necesari pentru
//   înregistrarea cu succes a unui utilizator nou (deschideți homepage-ul, apăsați pe Account, apăsați pe Register,
//   completați toate câmpurile de pe pagina Register - atenție ca email-ul să fie unic, bifați opțiunea pentru
//   primirea newsleterr-ului). Folosiți identificatori diferiți pentru câmpurile de pe pagina Register
//   (id, name, className). Pe viitor, după învățarea altor identificatori, veți reveni pentru a apăsa și butonul Register.
//   Apelati metoda aceasta in metoda main din clasa pentru a rula testul.

    public void registerWithValidDetails() {
            InvokeBrowser invoke = new InvokeBrowser();
            WebDriver driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");
        try {

            String accountSelector = "#header > div > div.skip-links > div > a";

            driver.findElement(By.cssSelector(accountSelector)).click();
            driver.findElement(By.linkText("Register")).click();
            driver.findElement(By.id("firstname")).sendKeys("Emma");
            driver.findElement(By.id("lastname")).sendKeys("Thomson");
            driver.findElement(By.id("email_address")).sendKeys("someoneelse@gmail.com");
            driver.findElement(By.name("password")).sendKeys("1234567");
            driver.findElement(By.name("confirmation")).sendKeys("1234567");
            driver.findElement(By.id("is_subscribed")).click();
            driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        } finally {
            driver.quit();
        }
    }
}
