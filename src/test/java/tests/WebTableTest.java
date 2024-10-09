package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

import java.util.List;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        //validam dimensiunea initiala a tabelului
        List<WebElement> tableContentList = getDriver().findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3,"Default size for table is not 3");

        //definim un element
        String firstNameValue = "Sandra";
        String lastNameValue = "Gyebnar";
        String emailValue = "gyebnar.sandra@yahoo.com";
        String ageValue = "31";
        String salaryValue = "30000";
        String departmentValue = "Testing";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.createProcess(firstNameValue,lastNameValue,emailValue,ageValue,salaryValue,departmentValue,3);

        String editeFirstNameValue = "Sandra";
        String editLastNameValue = "Gyebnar";
        String  editeEmailValue= "gyebnar.sandrajss@yahoo.com";
        String editAgeValue = "20";
        String editSalaryValue = "100001";
        String editDepartmentValue = "Testing";

        webTablePage.editeProcess(editeFirstNameValue,editLastNameValue,editeEmailValue,editAgeValue,editSalaryValue,editDepartmentValue,3);

        webTablePage.deleteProcess(3);

    }


}
