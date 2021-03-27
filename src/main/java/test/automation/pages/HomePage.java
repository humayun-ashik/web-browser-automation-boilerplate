package test.automation.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    /**Variables*/
    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    /**Page Methods*/
    public HomePage goToHomePage() {
        driver.get(baseURL);
        return this;
    }

    public LoginPage goToLoginPage() {
        /**
         * write code if any action required to go login page
         */
        return new LoginPage(driver);
    }
}
