package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.HomePage;
import pages.NestedFramesPage;
import sharedData.SharedData;

public class NestedFramesTest extends SharedData {

    @Test
    public void metodaTest() {

//        ElementMethods elementMethods = new ElementMethods(getDriver());
//        TabMethods tabMethods = new TabMethods(getDriver());
//        FrameMethods frameMethods = new FrameMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(getDriver());
        alertFrameWindowsPage.clickNestedFrameSubmenu();

//        WebElement nestedFrameSubMenu = getDriver().findElement(By.xpath("//span[text()='Nested Frames']"));
//        elementMethods.clickJSElement(nestedFrameSubMenu);

        NestedFramesPage nestedFramesPage = new NestedFramesPage(getDriver());
        nestedFramesPage.dealFirstNestedFrame();
        nestedFramesPage.dealSecondNestedFrame();




    }



}
