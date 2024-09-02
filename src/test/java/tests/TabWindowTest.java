package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

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
    }
}
