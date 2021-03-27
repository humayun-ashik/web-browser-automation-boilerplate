package test.automation;

import io.qameta.allure.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ExtentReports.*;
import test.automation.pages.BasePage;
import test.automation.pages.LoginPage;

/**
 * @author Humayun Ahmed Ashik
 *
 */

public class LoginTest extends BaseTest {

    @Test (priority = 0, description="Valid Login Scenario with correct username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test with valid user name and password")
    public void LoginWithValidPassword(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Valid Login Scenario with correct username and password.");
        homePage
                .goToHomePage()
                .goToLoginPage()
                .doLogin("john", "demo");
//                .verifySuccessfulLogin("Welcome John Smith");

        homePage .goToLoginPage().doLogout();


    }

}
