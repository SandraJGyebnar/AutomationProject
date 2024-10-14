package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.HomePage;
import pages.NestedFramesPage;
import sharedData.Hooks;
import sharedData.SharedData;

public class NestedFramesTest extends Hooks {

    @Test
    public void metodaTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowPage = new AlertFrameWindowsPage(getDriver());
        alertFrameWindowPage.clickNestedFrameSubmenu();

        NestedFramesPage nestedFramePage = new NestedFramesPage(getDriver());
        nestedFramePage.dealFirstNestedFrame();
    }
}


