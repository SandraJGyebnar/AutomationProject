package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.FramesPages;
import pages.HomePage;
import sharedData.Hooks;

import static java.sql.DriverManager.getDriver;

public class FrameTest extends Hooks {

    @Test
    public void metodaTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowPage = new AlertFrameWindowsPage(getDriver());
        alertFrameWindowPage.clickFramesSubMenu();

        FramesPages framesPage = new FramesPages(getDriver());
        framesPage.dealFirstFrame();
        framesPage.dealSecondFrame();
    }
}
