package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.FramesPages;
import pages.HomePage;

import java.time.Duration;

public class FrameTest {
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
        TabMethods tabMethods = new TabMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        alertFrameWindowsPage.clickFramesSubMenu();

        FramesPages framesPages = new FramesPages(driver);
        framesPages.dealFirstFrame();
        framesPages.dealSecondFrame();


        driver.quit();

    }
}
