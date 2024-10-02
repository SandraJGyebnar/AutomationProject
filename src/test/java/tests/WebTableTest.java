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
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

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

        HomePage homePage = new HomePage(driver);
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickWebTable();



        //validam dimensiunea initiala a tabelului
        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3,"Default size for table is not 3");

        //definim un element

        String firstNameValue = "Sandra";
        String lastNameValue = "Gyebnar";
        String emailValue = "gyebnar.sandra@yahoo.com";
        String ageValue = "31";
        String salaryValue = "30000";
        String departmentValue = "Testing";

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.createProcess(firstNameValue,lastNameValue,emailValue,ageValue,salaryValue,departmentValue,3);

        String editeFirstNameValue = "Sandra";
        String editLastNameValue = "Gyebnar";
        String  editeEmailValue= "gyebnar.sandrajss@yahoo.com";
        String editAgeValue = "20";
        String editSalaryValue = "100001";
        String editDepartmentValue = "Testing";

        webTablePage.editeProcess(editeFirstNameValue,editLastNameValue,editeEmailValue,editAgeValue,editSalaryValue,editDepartmentValue,3);

        webTablePage.deleteProcess(3);

        driver.quit();

    }


}
