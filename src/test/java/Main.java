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
        LoginTest login = new LoginTest();
        login.loginWithIncorrectCredentials();
        login.loginWithCorrectCredentials();
    }

    public static void wishListFunctionality() {
        WishListTest wishList = new WishListTest();
        wishList.addToWIshList();
    }
}
