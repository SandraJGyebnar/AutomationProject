package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage{

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTableSubMenu;

    public void clickWebTable(){
        elementMethods.clickJSElement(webTableSubMenu);
        loggerUtility.infoLog("The user clicks on Web Table subMenu");

    }

}
