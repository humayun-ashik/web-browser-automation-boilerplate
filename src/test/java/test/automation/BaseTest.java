package test.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import test.automation.pages.BasePage;
import test.automation.pages.Page;
import test.automation.utils.ReadExcelFile;

/**
 * @author Humayun Ahmed Ashik
 *
 */

public class BaseTest {
    WebDriver driver;
    public Page page;

    private String url = "";

    public BaseTest(String url) {
        this.url = url;
    }

    @BeforeClass
    @Parameters(value= {"browser"})
    public void setupTest(String browser) {
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if(browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("No Browser is Defined in xml");
        }



//		driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
//
//
        // Default value 0 Seconds implicit timeout
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        // Default value 300 Seconds pageload timeout
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);



        driver.get(this.url);


//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}


        System.out.println("URL: " + this.url);

        page = new BasePage(driver);
    }
    @DataProvider(name="dmslogindata")
    public Object[][] TestDataFeed(){
        ReadExcelFile readExcelObj = new ReadExcelFile("./Datafiles/users.xlsx");

        int sheet_index = 1;

        int rows = readExcelObj.getRowCount(sheet_index);

        Object[][] credentials = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            credentials[i][0] = readExcelObj.getData(sheet_index,i,0);
            credentials[i][1] = readExcelObj.getData(sheet_index,i,1);
        }

        return credentials;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
