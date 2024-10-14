package tests;

import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.AlertPage;
import pages.HomePage;
import sharedData.Hooks;

import static java.sql.DriverManager.getDriver;

public class AlertTest extends Hooks {

    @Test
    public void metodaTest() {
        AlertModel testData = new AlertModel("src/test/resources/inputData/AlertTestResource.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowsPage alertFrameWindowPage = new AlertFrameWindowsPage(getDriver());
        alertFrameWindowPage.clickAlert();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertProcess(testData);
    }
}
