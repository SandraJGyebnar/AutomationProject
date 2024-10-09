package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement okAlertElement;
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement confirmAlertElement;
    @FindBy(id = "promtButton")
    private WebElement promtAlertElement;



    public void dealAlertProcess(String text){
        elementMethods.clickElement(okAlertElement);
        alertMethods.acceptAlert();
        elementMethods.clickElement(timerAlertButtonElement);
        alertMethods.acceptAlert();
        elementMethods.clickElement(confirmAlertElement);
        alertMethods.acceptAlert();
        elementMethods.clickElement(promtAlertElement);
        alertMethods.acceptAlert();

    }
}