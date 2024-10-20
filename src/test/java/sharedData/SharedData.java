package sharedData;

import org.openqa.selenium.WebDriver;
import sharedData.browserService.ChromeService;
import sharedData.browserService.EdgeServices;

public class SharedData {

    private WebDriver driver;

    public void setUpDriver() {
        String browser = System.getProperty("browser");

        switch (browser){
            case "edge":
                EdgeServices edgeService = new EdgeServices();
                edgeService.openBrowser();
                driver = edgeService.getDriver();
                break;
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser();
                driver = chromeService.getDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
