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

import java.time.Duration;

public class FrameTest {
    public WebDriver driver;


    @Test

    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browser-ul maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertsFrameWindowsMenu);

        WebElement frameSubMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementMethods.clickJSElement(frameSubMenu);

        //ne mutam la iFrame
        frameMethods.switchToSpecificFrame("frame1");

        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());

       frameMethods.switchToParentIFrame();

        frameMethods.switchToSpecificFrame("frame2");

        WebElement secondSampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondSampleTextElement.getText());

        driver.quit();

        //tema - nested frame






    }
}
