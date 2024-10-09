package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabWindowPage extends BasePage{

    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement tabButtonElement;
    @FindBy(id = "windowButton")
    private WebElement windowButtonElement;

}

