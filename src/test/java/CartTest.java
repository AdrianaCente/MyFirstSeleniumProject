import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CartTest {
    private WebDriver driver;

    @Before
    public void invokeDriver() {
        InvokeBrowser invoke = new InvokeBrowser();
        driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addProductToCart() {
        WebElement hoverElementAccessory = driver.findElement(By.cssSelector("#nav .nav-3 > a"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverElementAccessory).perform();
        driver.findElement(By.cssSelector(".nav-3-2")).click();
        driver.findElement(By.cssSelector("ul.products-grid li:first-of-type button[title='Add to Cart']")).click();
        String checkedText = driver.findElement(By.cssSelector(".success-msg span")).getText();
        Assert.assertEquals("Pearl Stud Earrings was added to your shopping cart.", checkedText);
    }

    @Test
    public void addProductToCartWhileLoggedIn() {
        loginTest(driver);

        WebElement hoverElementAccessory = driver.findElement(By.cssSelector("#nav .nav-3 > a"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverElementAccessory).perform();
        driver.findElement(By.cssSelector(".nav-3-2")).click();
        driver.findElement(By.cssSelector("ul.products-grid li:first-of-type button[title='Add to Cart']")).click();

        String checkedText = driver.findElement(By.cssSelector(".success-msg span")).getText();
        Assert.assertEquals("Pearl Stud Earrings was added to your shopping cart.", checkedText);
    }

    @Test
    public void updateQuality() {
        WebElement hoverElementAccessory = driver.findElement(By.cssSelector("#nav .nav-3 > a"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverElementAccessory).perform();
        driver.findElement(By.cssSelector(".nav-3-2")).click();
        driver.findElement(By.cssSelector("ul.products-grid li:first-of-type button[title='Add to Cart']")).click();

        WebElement replaceValue = driver.findElement(By.cssSelector("[title='Qty']"));
        String valueQty = replaceValue.getText();
        replaceValue.sendKeys(Keys.chord(Keys.CONTROL, "a"), "3");

        driver.findElement(By.cssSelector("tr:first-of-type td.product-cart-actions button[title='Update']")).click();

        WebElement replaceNewValue = driver.findElement(By.cssSelector("[title='Qty']"));
        String valueNewQty = replaceNewValue.getText();
        Assert.assertEquals(valueQty, valueNewQty);
    }

    @Test
    public void updateWithBiggerQuality() {
        WebElement hoverElementAccessory = driver.findElement(By.cssSelector("#nav .nav-3 > a"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverElementAccessory).perform();
        driver.findElement(By.cssSelector(".nav-3-2")).click();
        driver.findElement(By.cssSelector("ul.products-grid li:first-of-type button[title='Add to Cart']")).click();
        WebElement replaceValue = driver.findElement(By.cssSelector("[title='Qty']"));
        replaceValue.sendKeys(Keys.chord(Keys.CONTROL, "a"), "20");
        driver.findElement(By.cssSelector("tr:first-of-type td.product-cart-actions button[title='Update']")).click();

        String checkedValue = driver.findElement(By.cssSelector(".item-msg")).getText();
        Assert.assertEquals("* The requested quantity for \"Pearl Stud Earrings\" is not available.",checkedValue);
    }

    public void loginTest(WebDriver driver) {
        LoginTest login = new LoginTest(driver);
        login.loginWithCorrectCredentials();
    }

    @After
    public void quitTest() {
        driver.quit();
    }
}
