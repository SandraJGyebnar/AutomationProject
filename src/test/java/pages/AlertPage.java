package pages;

import modelObject.AlertModel;
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



    public void dealAlertProcess(AlertModel testData){
        elementMethods.clickElement(okAlertElement);
        loggerUtility.infoLog("The user clicks on alertOk element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickElement(timerAlertButtonElement);
        loggerUtility.infoLog("The user clicks on alertTimer element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickElement(confirmAlertElement);
        loggerUtility.infoLog("The user clicks on alertConfirm element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user dismisses the alert");

        elementMethods.clickElement(promtAlertElement);
        loggerUtility.infoLog("The user clicks on alertPrompt element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user fills the alert displayed with "+testData.getAlertText()+" value and accepts it");


    }
}