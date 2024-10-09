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
        System.out.println(sampleTextElement.getText());
        frameMethods.switchToParentIFrame();
    }

    public void dealSecondFrame(){
        frameMethods.switchToSpecificFrame("frame2");
        System.out.println(secondSampleTextElement.getText());

    }
}
