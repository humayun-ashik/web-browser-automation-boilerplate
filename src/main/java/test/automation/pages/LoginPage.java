package test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author Humayun Ahmed Ashik
 *
 */
public class LoginPage extends BasePage {
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginbtn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    private By logOutBtn = By.linkText("Log Out");
    public By welcomeTextClass = By.className("smallText");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // return the user name
    public WebElement getUserName() {
        return getElementBy(username);
    }

    // return the password
    public WebElement getPassword() {
        return getElementBy(password);
    }

    /**
     * @return the loginbtn
     */
    public WebElement getLoginbtn() {
        return getElementBy(loginbtn);
    }

    public WebElement getLogoutBtn() {
        return getElementBy(logOutBtn);
    }

    public LoginPage doLogin(String username, String password) {

        System.out.println("Logging you in ...\n\n");
        getUserName().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginbtn().click();
        return this;
    }

    /**
     * Method Overloading
     * @return
     */
    public void doLogin() {
        getUserName().sendKeys("");
        getPassword().sendKeys("");
        getLoginbtn().click();

    }

    public void doLogin(String userCred) {
        if(userCred.contains("username")) {
            getUserName().sendKeys(userCred.split(":")[1].trim());
        }
        else if(userCred.contains("password")) {
            getPassword().sendKeys(userCred.split(":")[1].trim());
        }

    }

    public void doLogout() {
        System.out.println("\nLogging you out ...\n");
        getLogoutBtn().click();
    }
    public LoginPage verifySuccessfulLogin(String expected){
        waitVisibility(welcomeTextClass);
        Assert.assertTrue(readText(welcomeTextClass).contains(expected));
        //Assert.assertEquals(readText(welcomeTextClass), expected);
        return this;
    }

}
