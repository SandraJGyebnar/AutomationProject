package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import helpMethods.TabMethods;
import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.FramesPages;
import pages.HomePage;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(getDriver());
        alertFrameWindowsPage.clickFramesSubMenu();

        FramesPages framesPages = new FramesPages(getDriver());
        framesPages.dealFirstFrame();
        framesPages.dealSecondFrame();

    }
}
