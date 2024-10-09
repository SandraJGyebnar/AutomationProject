package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormSubMenu;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(xpath = "//input[@name='gender']")
    private List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    private WebElement mobileNumberElement;
    @FindBy(id = "subjectsInput")
    private WebElement subjectElement;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(className = "react-datepicker__month-select")
    private WebElement mothElement;
    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearElement;
    @FindBy(xpath = "//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]")
    private List<WebElement> daysList;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesOptionsList;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressElement;
    @FindBy(xpath = "//div[text()= 'Select State']")
    private WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;
    @FindBy(xpath = "//div[text()= 'Select City']")
    private WebElement cityElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement submitElement;
    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    private WebElement thankYouElement;
    @FindBy(xpath = "//table[@class='table table-dark table-striped-borderedt table-hover']//td[1]")
    private List<WebElement> lableList;
    @FindBy(xpath = "//table[@class='table table-dark table-striped-borderedt table-hover']//td[1]")
    private List<WebElement> valueList;

    public void fillEntireForm(String firstNameValue, String lastNameValue,String userEmailValue, String genderValue,
                               String mobileNumberlValue,String monthValue,String yearValue,String dayValue,
                               List<String> subjectValues,List<String> hobbiesValues,String currentAddressValue,
                               String stateValue, String cityValue){

        elementMethods.fillElement(firstNameElement,firstNameValue);
        elementMethods.fillElement(lastNameElement,lastNameValue);
        elementMethods.fillElement(userEmailElement,userEmailValue);
        switch (genderValue) {
            case "Male":
                elementMethods.clickJSElement(genderOptionsList.get(0));

                break;
            case "Female":
                elementMethods.clickJSElement(genderOptionsList.get(1));
                break;
            case "Other":
                elementMethods.clickJSElement(genderOptionsList.get(2));
                break;


        }
        mobileNumberElement.sendKeys(mobileNumberlValue);

        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectElement,subjectValues.get(index), Keys.ENTER);

        }

        elementMethods.clickJSElement(dateOfBirthElement);

        for (int index = 0; index < daysList.size(); index ++){
            if (daysList.get(index).getText().equals(dayValue)){

                elementMethods.clickElement(daysList.get(index));
                break;
            }
        }

        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)){
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));

            }
        }

        mobileNumberElement.sendKeys(currentAddressValue);
        elementMethods.clickJSElement(stateElement);
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);
        elementMethods.clickJSElement(cityElement);
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);
        elementMethods.clickJSElement(submitElement);

    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String userEmailValue, String genderValue, String mobileNumberlValue,
                                   List<String> subjectValues, List<String> hobbiesValues, String currentAddressValue,
                                   String stateValue, String cityValue){
        elementMethods.waitVisibleElement(thankYouElement);
        Assert.assertEquals(thankYouElement.getText(),"Thanks for submitting the form");

        Assert.assertEquals(lableList.get(0).getText(),"Student Name");
        Assert.assertEquals(lableList.get(1).getText(), "Student Email");
        Assert.assertEquals(lableList.get(2).getText(), "Gender");
        Assert.assertEquals(lableList.get(3).getText(), "Mobile");
        Assert.assertEquals(lableList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(lableList.get(5).getText(), "Subjects");
        Assert.assertEquals(lableList.get(6).getText(), "Hobbies");
        Assert.assertEquals(lableList.get(7).getText(), "Address");
        Assert.assertEquals(lableList.get(8).getText(), "State and City");

        Assert.assertEquals(valueList.get(0).getText(), firstNameValue + " " + lastNameValue);
        Assert.assertEquals(valueList.get(1).getText(), userEmailValue);


        Assert.assertEquals(valueList.get(2).getText(), genderValue);

        Assert.assertEquals(valueList.get(3).getText(), mobileNumberlValue);
        Assert.assertEquals(valueList.get(4).getText(), "15 January,2030");

        String subjectValue = String.join(", ", subjectValues);
        Assert.assertEquals(valueList.get(5).getText(), subjectValue);

        String hobbyValue = String.join(", ", hobbiesValues);
        Assert.assertEquals(valueList.get(6).getText(), hobbyValue);

        Assert.assertEquals(valueList.get(7).getText(), currentAddressValue);
        Assert.assertEquals(valueList.get(8).getText(), stateValue +" "+ cityValue);
    }





}
