import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public void loginWithIncorrectCredentials() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();

        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();;

        driver.findElement(By.cssSelector("#email")).sendKeys("adrianamarcu12@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("123");

        driver.findElement(By.cssSelector("#send2")).click();

        driver.quit();
    }

}
