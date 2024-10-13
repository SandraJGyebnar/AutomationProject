package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AlertFrameWindowsPage;
import pages.HomePage;
import pages.TabWindowPage;
import sharedData.Hooks;
import sharedData.SharedData;

public class TabWindowTest extends Hooks {

    @Test
    public void metodaTest() {

            HomePage homePage = new HomePage(getDriver());
            homePage.clickAlertFrameWindow();

            AlertFrameWindowsPage alertFrameWindowPage = new AlertFrameWindowsPage(getDriver());
            alertFrameWindowPage.clickAlert();

            TabWindowPage tabWindowPage = new TabWindowPage(getDriver());
            tabWindowPage.dealTabProcess();
            tabWindowPage.dealWindowProcess();
        }

}
