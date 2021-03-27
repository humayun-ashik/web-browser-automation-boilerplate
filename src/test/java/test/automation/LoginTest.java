package test.automation;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import test.automation.pages.LoginPage;
import test.automation.utils.Constant;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    public LoginTest(String url) {
        super("https://parabank.parasoft.com/parabank/index.htm");
    }


    @Test (priority = 0, description="Valid Login Scenario with correct username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test with valid user name and password")

    //@Test(priority = 1, enabled=true)
    public void LoginWithValidPassword() throws Exception{
        page
                .getInstance(LoginPage.class)
                .doLogin("john", "demo");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        page.getInstance(LoginPage.class).doLogout();

    }

}
