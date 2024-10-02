package pages;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabWindowPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public TabMethods tabMethods;

    public TabWindowPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(id = "tabButton")
    public WebElement tabButtonElement;
    @FindBy(id = "windowButton")
    public WebElement windowButtonElement;
}

