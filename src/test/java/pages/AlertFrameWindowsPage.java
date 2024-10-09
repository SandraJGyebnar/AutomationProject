package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowsPage extends BasePage {


    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsSubmenu;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frameSubMenu;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFrameSubMenu;

    public AlertFrameWindowsPage(WebDriver driver) {
        super(driver);
    }


    public void clickAlert(){
        elementMethods.clickJSElement(alertsSubmenu);
    }

    public void browserWindowsMenu(){
        elementMethods.clickJSElement(browserWindowSubMenu);
    }

    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(frameSubMenu);

    }
    public void clickNestedFrameSubmenu(){
        elementMethods.clickJSElement(nestedFrameSubMenu);
    }
}
