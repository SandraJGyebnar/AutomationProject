package pages;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        frameMethods = new FrameMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsFrameWindowsMenu;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement frameSubMenu;
    @FindBy(tagName = "iFrame")
    public WebElement childFrameElement;
    @FindBy(tagName = "p")
    public WebElement childSampleTextElement;

    public void dealFirstNestedFrame(){
        frameMethods.switchToParentIFrame();
        System.out.println(childFrameElement.getText());
        frameMethods.switchToParentIFrame();
    }

    public void dealSecondNestedFrame(){
        frameMethods.switchToSpecificFrame("p");
        System.out.println(childSampleTextElement.getText());

    }

}
