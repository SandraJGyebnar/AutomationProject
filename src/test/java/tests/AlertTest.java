package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.AlertPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    @Test

    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browser-ul maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        AlertMethods alertMethods = new AlertMethods(driver);


        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        alertFrameWindowsPage.clickAlert();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.dealAlertProcess("Test");




        driver.quit();


    }


}
