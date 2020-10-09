import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class WishListTest {
    private WebDriver driver;

    //    5. Adăugati un test(o noua metoda) prin care să deschideți homepage-ul site-ului, apoi să navigați
//    la categoria "Sale", apoi să deschideți pagina de detalii a primului produs și să încercați să îl adăugați
//    în WishList, apăsând butonul Add to Wishlist. Pe viitor, după ce veți învăța să faceți și verificări,
//    veți putea reveni pentru a vă asigura că adăugarea în wishlist poate fi realizată doar de utilizatorii
//    autentificați. Apelati metoda aceasta in metoda main pentru a rula testul.

    @Before
    public void invokeDriver() {
        InvokeBrowser invoke = new InvokeBrowser();
        driver = invoke.invokeBrowser("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWIshListWithoutLogin() {
        String saleSelector = "li.nav-5 > a.level0";
        String ulSelector = "div.category-products > ul";
        String detailsButtonSelector = "a[title='View Details']";
        String addToWishlistSelector = "a.link-wishlist";

        driver.findElement(By.cssSelector(saleSelector)).click();
        WebElement firstItemSale = driver.findElement(By.cssSelector(ulSelector)).findElements(By.tagName("li")).get(0);
        WebElement firstItemDetails = firstItemSale.findElement(By.cssSelector(detailsButtonSelector));
        firstItemDetails.click();
        driver.findElement(By.cssSelector(addToWishlistSelector)).click();

        String checkValue = driver.findElement(By.cssSelector("div.page-title h1")).getText();
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT", checkValue);
    }

    @Test
    public void addToWishListWithLogin() {
        loginTest(driver);

        String saleSelector = "li.nav-5 > a.level0";
        String ulSelector = "div.category-products > ul";
        String detailsButtonSelector = "a[title='View Details']";
        String addToWishlistSelector = "a.link-wishlist";

        driver.findElement(By.cssSelector(saleSelector)).click();
        WebElement firstItemSale = driver.findElement(By.cssSelector(ulSelector)).findElements(By.tagName("li")).get(0);
        WebElement firstItemDetails = firstItemSale.findElement(By.cssSelector(detailsButtonSelector));
        firstItemDetails.click();
        driver.findElement(By.cssSelector(addToWishlistSelector)).click();

        String checkValue = driver.findElement(By.cssSelector("div.page-title h1")).getText();
        Assert.assertEquals("MY WISHLIST", checkValue);
    }

    @Test
    public void removeProductFromWishLIst() {
        loginTest(driver);

        String accountSelector = "div.account-cart-wrapper > a";
        driver.findElement(By.cssSelector(accountSelector)).click();
        driver.findElement(By.cssSelector("div#header-account a[title='My Account']")).click();
        driver.findElement(By.cssSelector("div.block-content li:nth-last-of-type(4) a")).click();

        List<WebElement> listLi = driver.findElements(By.cssSelector("#wishlist-table > tbody tr"));
        int count = listLi.size();
        driver.findElement(By.cssSelector("tr:first-of-type a[title='Remove Item']")).click();
        driver.switchTo().alert().accept();

        List<WebElement> listLiAfterRemove = driver.findElements(By.cssSelector("#wishlist-table > tbody tr"));
        Assert.assertThat(listLiAfterRemove.size(),is(count-1));
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
