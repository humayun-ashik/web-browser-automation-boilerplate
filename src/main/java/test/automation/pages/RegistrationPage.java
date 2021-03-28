package test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.github.javafaker.Faker;

public class RegistrationPage extends BasePage{
    Faker faker = new Faker();
    String userNameValue, passwordValue;
    private By registrationLink = By.linkText("Register");
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lasName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipcode = By.id("customer.address.zipcode");
    private By phoneNumber = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By userName = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");
    private By registerButton = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    private By welcomeText = By.className("title");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage doFillUpRegistrationInfo(){

        waitVisibility(firstName);
        writeText(firstName, faker.name().firstName());
        waitVisibility(lastName);
        writeText(lastName, faker.name().lastName());
        waitVisibility(address);
        writeText(address, faker.address().fullAddress());
        waitVisibility(city);
        writeText(city, faker.address().city());

        waitVisibility(state);
        writeText(state, faker.address().state());

        waitVisibility(zipcode);
        writeText(zipcode, faker.address().zipCode());

        waitVisibility(phoneNumber);
        writeText(phoneNumber, faker.phoneNumber().phoneNumber());

        waitVisibility(ssn);
        writeText(ssn, faker.idNumber().ssnValid());

        waitVisibility(ssn);
        writeText(ssn, faker.idNumber().ssnValid());

        waitVisibility(userName);
        userNameValue = faker.superhero().name();
        writeText(userName, userNameValue);

        waitVisibility(password);
        passwordValue = faker.internet().password(3, 8, true, false);
        writeText(password, passwordValue);

        waitVisibility(confirmPassword);
        writeText(confirmPassword, passwordValue);

        System.out.println("Username & Password: "+ userNameValue + " & "+ passwordValue);


        //Assert.assertTrue(readText(welcomeTextClass).contains(expected));
        //Assert.assertEquals(readText(welcomeTextClass), expected);
        return this;
    }
    public RegistrationPage clickOnRegisterButton(){
        click(registerButton);
        return this;

    }
}
