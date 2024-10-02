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
import pages.HomePage;
import pages.NestedFramesPage;

import javax.swing.text.AsyncBoxView;
import java.time.Duration;

public class NestedFramesTema {

    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver =new EdgeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(driver);
        alertFrameWindowsPage.clickNestedFrameSubmenu();



        WebElement nestedFrameSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(nestedFrameSubMenu);

        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        nestedFramesPage.dealFirstNestedFrame();
        nestedFramesPage.dealSecondNestedFrame();


        tabMethods.closeCurrentTab();


    }



}
