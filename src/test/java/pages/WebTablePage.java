package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablePage {
    public WebDriver driver;
    public ElementMethods elementMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    public List<WebElement> tableContentList;
    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departmentElement;
    @FindBy(id = "submit")
    public WebElement submitElement;
    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    public List<WebElement> newTableContentList;
    @FindBy(id = "edit-record-4")
    public WebElement editButtonElement;
    @FindBy(id = "firstName")
    public WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    public WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    public WebElement editEmailElement;
    @FindBy(id = "age")
    public WebElement editAgeElement;
    @FindBy(id = "salary")
    public WebElement editSalaryElement;
    @FindBy(id = "department")
    public WebElement editDepartmentElement;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void createProcess(String firstNameValue, String lastNameValue,String emailValue,String ageValue,String salaryValue,String departmentValue, int tableSize){
        Assert.assertEquals(tableContentList.size(), 3,"Default size for table is not 3");

        //definim un element

        elementMethods.clickElement(addElement);
        elementMethods.fillElement(firstNameElement,firstNameValue);
        elementMethods.fillElement(lastNameElement,lastNameValue);
        elementMethods.fillElement(emailElement,emailValue);
        elementMethods.fillElement(ageElement,ageValue);
        elementMethods.fillElement(salaryElement,salaryValue);
        elementMethods.fillElement(departmentElement,departmentValue);
        elementMethods.clickElement(submitElement);
        Assert.assertEquals(tableContentList.size(), tableSize + 1,"Default size for table is not " + tableSize + 1);

        //Validam valorile pe care le-am introdus
        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(firstNameValue),"The last row dosen't contain first name value");
        Assert.assertTrue(rowContent.contains(lastNameValue),"The last row dosen't contain last name value");
        Assert.assertTrue(rowContent.contains(emailValue),"The last row dosen't contain email name value");
        Assert.assertTrue(rowContent.contains(ageValue), "The last row dosen't contain age value");
        Assert.assertTrue(rowContent.contains(salaryValue), "The last row dosen't contain salary value");
        Assert.assertTrue(rowContent.contains(departmentValue),"The last row dosen't contain department value");

    }

    public void editeProcess(String editeFirstNameValue,String editLastNameValue,String  editeEmailValue,
                             String editAgeValue,String editSalaryValue,String editDepartmentValue, int tableSize){

        elementMethods.clickJSElement(editButtonElement);
        elementMethods.clearEditElement(editFirstNameElement,editeFirstNameValue);
        elementMethods.clearEditElement(editLastNameElement,editLastNameValue);
        elementMethods.clearEditElement(editEmailElement,editeEmailValue);
        elementMethods.clearEditElement(editAgeElement,editAgeValue);
        elementMethods.clearEditElement(editSalaryElement,editSalaryValue);
        elementMethods.clearEditElement(editDepartmentElement,editDepartmentValue);
        elementMethods.clickElement(submitElement);


        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(editeFirstNameValue),"The last row dosen't contain first name value");
        Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row dosen't contain last name value");
        Assert.assertTrue(rowContent.contains(editeEmailValue),"The last row dosen't contain email name value");
        Assert.assertTrue(rowContent.contains(editAgeValue), "The last row dosen't contain age value");
        Assert.assertTrue(rowContent.contains(editSalaryValue), "The last row dosen't contain salary value");
        Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row dosen't contain department value");
    }
    public void deleteProcess(int tableSize){
        elementMethods.clickJSElement(deleteElement);
        Assert.assertEquals(newTableContentList.size(),tableSize,"Default size for table is not 3");
    }

}
