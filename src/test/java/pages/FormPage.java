package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public FormPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//h5[text()= 'Forms']")
    public WebElement formsMenu;
    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormSubMenu;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement userEmailElement;
    @FindBy(xpath = "//input[@name='gender']")
    public List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    public WebElement mobileNumberElement;
    @FindBy(id = "subjectsInput")
    public WebElement subjectElement;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthElement;
    @FindBy(className = "react-datepicker__month-select")
    public WebElement mothElement;
    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearElement;
    @FindBy(xpath = "//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]")
    public List<WebElement> daysList;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    public List<WebElement> hobbiesOptionsList;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressElement;
    @FindBy(xpath = "//div[text()= 'Select State']")
    public WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    public WebElement stateInputElement;
    @FindBy(xpath = "//div[text()= 'Select City']")
    public WebElement cityElement;
    @FindBy(id = "react-select-4-input")
    public WebElement cityInputElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement thankYouElement;
    @FindBy(xpath = "//table[@class='table table-dark table-striped-borderedt table-hover']//td[1]")
    public List<WebElement> lableList;
    @FindBy(xpath = "//table[@class='table table-dark table-striped-borderedt table-hover']//td[1]")
    public List<WebElement> valueList;




}
