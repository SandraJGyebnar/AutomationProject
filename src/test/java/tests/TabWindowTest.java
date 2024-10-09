package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class TabWindowTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());
        TabMethods tabMethods = new TabMethods(getDriver());

        WebElement alertFrameWindowMenu = getDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertFrameWindowMenu);

        WebElement browserWindowsMenu = getDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickJSElement(browserWindowsMenu);

        WebElement newTabWindow = getDriver().findElement(By.id("tabButton"));
        elementMethods.clickJSElement(newTabWindow);

        tabMethods.switchSpecificTab(1);

        tabMethods.closeCurrentTab();

        tabMethods.switchSpecificTab(0);

        WebElement newWindowTab = getDriver().findElement(By.id("windowButton"));
        elementMethods.clickJSElement(newWindowTab);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();

        getDriver().quit();



















    }
}
