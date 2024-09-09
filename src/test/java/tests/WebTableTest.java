package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;

    @Test

    public void metodaTest() {

        //deschidem un browser
        driver = new EdgeDriver();

        // accesam un URL
        driver.get("https://demoqa.com/");

        //facem Browserul maximaze
        driver.manage().window().maximize();
        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickJSElement(elementsMenu);

        WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickJSElement(webTablesSubMenu);


        //validam dimensiunea initiala a tabelului
        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3,"Default size for table is not 3");

        //definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addElement);


        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Sandra";
        elementMethods.fillElement(firstNameElement,firstNameValue);


        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Gyebnar";
        elementMethods.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "gyebnar.sandra@yahoo.com";
        elementMethods.fillElement(emailElement,emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "31";
        elementMethods.fillElement(ageElement,ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "30000";
        elementMethods.fillElement(salaryElement,salaryValue);


        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Testing";
        elementMethods.fillElement(departmentElement,departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickElement(submitElement);


        //validam noua dimensiune a tabelului
        List<WebElement> newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3,"Default size for table is not 4");

        //Validam valorile pe care le-am introdus
        String rowContent = newTableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(firstNameValue),"The last row dosen't contain first name value");
        Assert.assertTrue(rowContent.contains(lastNameValue),"The last row dosen't contain last name value");
        Assert.assertTrue(rowContent.contains(emailValue),"The last row dosen't contain email name value");
        Assert.assertTrue(rowContent.contains(ageValue), "The last row dosen't contain age value");
        Assert.assertTrue(rowContent.contains(salaryValue), "The last row dosen't contain salary value");
        Assert.assertTrue(rowContent.contains(departmentValue),"The last row dosen't contain department value");

        //function edit
        WebElement editButtonElement = driver.findElement(By.id("edit-record-4"));
        elementMethods.clickJSElement(editButtonElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editeFirstNameValue = "Sandra";
        elementMethods.clearEditElement(editFirstNameElement,editeFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Gyebnar";
        elementMethods.clearEditElement(editLastNameElement,editLastNameValue);


        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String  editeEmailValue= "gyebnar.sandrajss@yahoo.com";
        elementMethods.clearEditElement(editEmailElement,editeEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "20 ";
        elementMethods.clearEditElement(editAgeElement,editAgeValue);


        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "100001";
        elementMethods.clearEditElement(editSalaryElement,editSalaryValue);


        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Testing";
        elementMethods.clearEditElement(editDepartmentElement,editDepartmentValue);


        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        elementMethods.clickElement(editSubmitElement);

        //validam valorile modificate din tabel
        rowContent = newTableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(editeFirstNameValue),"The last row dosen't contain first name value");
        Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row dosen't contain last name value");
        Assert.assertTrue(rowContent.contains(editeEmailValue),"The last row dosen't contain email name value");
        Assert.assertTrue(rowContent.contains(editAgeValue), "The last row dosen't contain age value");
        Assert.assertTrue(rowContent.contains(editSalaryValue), "The last row dosen't contain salary value");
        Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row dosen't contain department value");

        //delete function
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementMethods.clickJSElement(deleteElement);

        newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[class = 'rt-tr -odd'"));
        Assert.assertEquals(newTableContentList.size(),3,"Default size for table is not 3");

        driver.quit();

    }


}
