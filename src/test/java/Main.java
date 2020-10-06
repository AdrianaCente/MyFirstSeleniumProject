import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        registerFunctionality();
        loginFunctionality();
        wishListFunctionality();
    }

    public static void registerFunctionality() {
        RegisterTest register = new RegisterTest();
        register.registerWithValidDetails();
    }

    public static void loginFunctionality() {
        Login login = new Login();
        login.loginWithIncorrectCredentials();
        login.loginWithCorrectCredentials();
    }

    public static void wishListFunctionality() {
        WishListTest wishList = new WishListTest();
        wishList.addToWIshList();
    }
}
