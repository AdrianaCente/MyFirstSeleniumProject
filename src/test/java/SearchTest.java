import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void invokeDriver() {
        InvokeBrowser invoke = new InvokeBrowser();
        driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void searchExistingItem() {
        driver.findElement(By.id("search")).sendKeys("pearl");
        driver.findElement(By.cssSelector("button[title='Search']")).click();
        String checkValue = driver.findElement(By.cssSelector("div.page-title h1")).getText();
        Assert.assertEquals("SEARCH RESULTS FOR 'PEARL'", checkValue);
    }

    @Test
    public void searchInexistentItem() {
        driver.findElement(By.id("search")).sendKeys("gjhg");
        driver.findElement(By.cssSelector("button[title='Search']")).click();
        String checkValue = driver.findElement(By.cssSelector(".note-msg")).getText();
        Assert.assertEquals("Your search returns no results.", checkValue);
    }

    @After
    public void quitTest() {
        driver.quit();
    }
}
