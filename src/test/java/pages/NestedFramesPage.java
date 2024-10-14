package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsMenu;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement frameSubMenu;
    @FindBy(tagName = "iFrame")
    private WebElement childFrameElement;
    @FindBy(tagName = "p")
    private WebElement childSampleTextElement;

    public void dealFirstNestedFrame(){
        frameMethods.switchToParentIFrame();
        loggerUtility.infoLog("The user switches the focus to a specific parent iframe");

        System.out.println(childFrameElement.getText());
        frameMethods.switchToParentIFrame();
        loggerUtility.infoLog("The user switches the focus to a specific child iframe");

    }

    public void dealSecondNestedFrame(){
        frameMethods.switchToSpecificFrame("p");
        System.out.println(childSampleTextElement.getText());
        loggerUtility.infoLog("The user interacts with an element within iframe");


    }

}
