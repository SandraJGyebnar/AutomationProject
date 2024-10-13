package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPages extends BasePage {

    @FindBy(id = "sampleHeading")
    private WebElement sampleTextElement;
    @FindBy(id = "sampleHeading")
    private WebElement secondSampleTextElement;

    public FramesPages(WebDriver driver) {
        super(driver);
    }

    public void dealFirstFrame(){
        frameMethods.switchToSpecificFrame("frame1");
        loggerUtility.infoLog("The user switches to specific iframe");

        frameMethods.switchToParentIFrame();
        loggerUtility.infoLog("The user interacts with an element within iframe");

    }

    public void dealSecondFrame(){
        frameMethods.switchToSpecificFrame("frame2");
        loggerUtility.infoLog("The user switches to specific iframe");

        System.out.println(secondSampleTextElement.getText());
        loggerUtility.infoLog("The user interacts with an element within iframe");

    }
}
