package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.AlertPage;
import pages.HomePage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());
        AlertMethods alertMethods = new AlertMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowsPage = new AlertFrameWindowsPage(getDriver());
        alertFrameWindowsPage.clickAlert();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertProcess("Test");




    }


}
