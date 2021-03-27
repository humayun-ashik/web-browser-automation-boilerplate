package test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage{
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }
    //Click Method
    public void click(By elementLocation) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText(By elementLocation) {
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }

    //Wait
    public void waitVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeader(By locator) {
        return getElementBy(locator).getText();
    }

    public WebElement getElementBy(By locator) {
        WebElement element = null;

        try {
            element = driver.findElement(locator);
            return element;
        }catch(Exception e) {
            System.out.println("Some Error Occured while creating element"+locator.toString());
            e.printStackTrace();
        }

        return element;
    }

    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch(Exception e) {
            System.out.println("some exception occured while waiting for the element "+locator.toString());
        }

    }

    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        }catch(Exception e) {
            System.out.println("some exception occured while waiting for the title "+title);
        }
    }

}
