package tests;

import helpMethods.ElementMethods;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubmenu();

        String firstNameValue = "Sandra";
        String lastNameValue = "Gyebnar";
        String userEmailValue = "gsandrajss@gmail.com";
        String genderValue = "Female";
        String mobileNumberlValue = "0724567567";
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "English");
        String monthValue = "January";
        String yearValue = "2030";
        String dayValue = "15";
        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        String currentAddressValue = "Sacalaz 445";
        String stateValue = "NCR";
        String cityValue = "Delhi";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue,userEmailValue,genderValue,mobileNumberlValue,monthValue,yearValue,dayValue,
                subjectValues,hobbiesValues,currentAddressValue,stateValue,cityValue);

        practiceFormPage.validateFormValues(firstNameValue,lastNameValue,userEmailValue,genderValue,
                mobileNumberlValue,subjectValues,hobbiesValues,currentAddressValue,stateValue,cityValue);

    }

}

