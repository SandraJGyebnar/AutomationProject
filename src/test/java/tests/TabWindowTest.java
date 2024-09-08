package tests;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest {

    public WebDriver driver;


    @Test

    public void metodaTest() {

        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browserul maximise
        driver.manage().window().maximize();

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",alertFrameWindowMenu);

        WebElement browserWindowsMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        js.executeScript("arguments[0].click();",browserWindowsMenu);

        WebElement newTabWindow = driver.findElement(By.id("tabButton"));
        js.executeScript("arguments[0].click();",newTabWindow);

        System.out.println("URL-ul paginii este: " + driver.getCurrentUrl());

        List<String> tabList  = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        System.out.println("URL-ul paginii este: " + driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(tabList.get(0));

        System.out.println("URL-ul paginii este: " + driver.getCurrentUrl());

        WebElement newWindowTab = driver.findElement(By.id("windowButton"));
        js.executeScript("arguments[0].click();",newWindowTab);

        List<String> windowsList  = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));


        System.out.println("URL-ul paginii este: " + driver.getCurrentUrl());

        driver.close();

        driver.quit();



















    }
}
