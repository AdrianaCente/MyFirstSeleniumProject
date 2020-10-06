import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        loginFunctionality();
    }

    public static void loginFunctionality() {
        Login login = new Login();
        login.loginWithIncorrectCredentials();
    }
}
