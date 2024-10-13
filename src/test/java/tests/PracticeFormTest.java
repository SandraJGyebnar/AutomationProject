package tests;

import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
    public void metodaTest() {
        PracticeFormModel testData = new PracticeFormModel("src/test/resources/inputData/PracticeFormResource.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubmenu();

        PracticeFormPage practiceFormsPage = new PracticeFormPage(getDriver());
        practiceFormsPage.fillEntireForm(testData);
        practiceFormsPage.validateFormValues(testData);
    }
}