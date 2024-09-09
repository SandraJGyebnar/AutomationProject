package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browserul maximise
        driver.manage().window().maximize();
        ElementMethods elementMethods = new ElementMethods(driver);

        //identificarea unui element dupa text - xpath (tag, atribut, valoare) - identificare relativa // sau absoluta /- nu facem absolut (ex://h5[text()= "Elements"])

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()= 'Forms']"));
        elementMethods.clickJSElement(formsMenu);


        WebElement practiceFormSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickJSElement(practiceFormSubMenu);


        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Sandra";
        elementMethods.fillElement(firstNameElement,firstNameValue);


        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Gyebnar";
        elementMethods.fillElement(lastNameElement,lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "gsandrajss@gmail.com";

        elementMethods.fillElement(userEmailElement,userEmailValue);

        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
        String genderValue = "Female";

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

        WebElement mobileNumberElement = driver.findElement(By.id("userNumber"));
        String mobileNumberlValue = "0724567567";
        mobileNumberElement.sendKeys(mobileNumberlValue);

        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "English");
        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectElement,subjectValues.get(index),Keys.ENTER);

        }

        //date of birth
        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        elementMethods.clickJSElement(dateOfBirthElement);


        WebElement mothElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(mothElement);
        String monthValue = "January";
        monthSelect.selectByVisibleText(monthValue);

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearElement);
        String yearValue = "2030";
        yearSelect.selectByVisibleText(yearValue);

        String dayValue = "15";
        List<WebElement> daysList = driver.findElements(By.xpath("//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]"));
        for (int index = 0; index < daysList.size(); index ++){
            if (daysList.get(index).getText().equals(dayValue)){

                elementMethods.clickElement();
                break;
            }
        }

        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        List<WebElement> hobbiesOptionsList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));

        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)){
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));

            }
        }

//        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
//        File file = new File("src/test/resources/messages.txt");
//        pictureElement.sendKeys(file.getAbsolutePath());



        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Sacalaz 445";
        mobileNumberElement.sendKeys(currentAddressValue);

        WebElement stateElement = driver.findElement(By.xpath("//div[text()= 'Select State']"));
        elementMethods.clickJSElement(stateElement);


        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);
        // pentru dropdown am facut metoda asta

        WebElement cityElement = driver.findElement(By.xpath("//div[text()= 'Select City']"));
        elementMethods.clickJSElement(cityElement);


        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickJSElement(submitElement);


        //validam datele introduse

        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouElement.getText(),"Thanks for submitting the form");

        List<WebElement> lableList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped-borderedt table-hover']//td[1]"));
        List<WebElement> valueList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped-borderedt table-hover']//td[1]"));

        Assert.assertEquals(lableList.get(0).getText(),"Student Name");
        Assert.assertEquals(lableList.get(1).getText(),"Student Email");
        Assert.assertEquals(lableList.get(2).getText(),"Gender");
        Assert.assertEquals(lableList.get(3).getText(),"Mobile");
        Assert.assertEquals(lableList.get(4).getText(),"Date of Birth");
        Assert.assertEquals(lableList.get(5).getText(),"Subjects");
        Assert.assertEquals(lableList.get(6).getText(),"Hobbies");
        Assert.assertEquals(lableList.get(7).getText(),"Picture");
        Assert.assertEquals(lableList.get(8).getText(),"Address");
        Assert.assertEquals(lableList.get(9).getText(),"State and City");

        Assert.assertEquals(valueList.get(0).getText(), firstNameValue + " " + lastNameValue);
        Assert.assertEquals(valueList.get(1),userEmailValue);
        Assert.assertEquals(valueList.get(2),genderValue);
        Assert.assertEquals(valueList.get(3),mobileNumberlValue);
        Assert.assertEquals(valueList.get(4),dateOfBirthElement);
        Assert.assertEquals(valueList.get(5),subjectValues);
        Assert.assertEquals(valueList.get(6),hobbiesValues);
        //Assert.assertEquals(valueList.get(7),picture);
        Assert.assertEquals(valueList.get(8),currentAddressValue);
        Assert.assertEquals(valueList.get(9),stateValue, cityValue);



        driver.quit();

    }

}

