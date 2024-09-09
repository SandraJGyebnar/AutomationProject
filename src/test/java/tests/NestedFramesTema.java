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

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertsFrameWindowsMenu);


        WebElement frameSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(frameSubMenu);

        driver.switchTo().frame("frame1");


        WebElement childFrameElement = driver.findElement(By.tagName("iFrame"));
        frameMethods.switchToSpecificIFrameByElement(childFrameElement);

        WebElement childSampleTextElement = driver.findElement(By.tagName("p"));
        System.out.println(childSampleTextElement.getText());

        tabMethods.closeCurrentTab();


    }



}
