package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;

    public AlertFrameWindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsSubmenu;

    public void clickAlert(){
        elementMethods.clickJSElement(alertsSubmenu);
    }
}
