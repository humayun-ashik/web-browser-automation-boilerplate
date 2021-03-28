package test.automation;

import ExtentReports.ExtentTestManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RegistrationTest extends BaseTest{
    @Test(priority = 0, description="Registration with valid data")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Registration test with valid")
    public void RegistrationWithValidData(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Registration with valid data");
        homePage
                .goToHomePage()
                .goToRegistrationPage()
                .doFillUpRegistrationInfo()
                .clickOnRegisterButton();

                // .verifySuccessfulLogin("Welcome John Smith");


    }
}
