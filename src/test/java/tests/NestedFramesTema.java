package tests;

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

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);


        WebElement frameSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        js.executeScript("arguments[0].click();", frameSubMenu);

        driver.switchTo().frame("frame1");

        WebElement childFrameElement = driver.findElement(By.tagName("iFrame"));
        driver.switchTo().frame(childFrameElement);

        WebElement childSampleTextElement = driver.findElement(By.tagName("p"));
        System.out.println(childSampleTextElement.getText());


    }



}
