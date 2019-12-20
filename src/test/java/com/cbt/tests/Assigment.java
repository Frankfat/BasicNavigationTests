package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Assigment {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement element = driver.findElement(By.linkText("Registration Form"));
        element.click();
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test(priority = 1, description = "Verifiying Error Message")
    public void testCase1() {

        WebElement element2 = driver.findElement(By.xpath("//input[@class='form-control'][@name='birthday']"));
        element2.sendKeys("wrong_dob");
        WebElement element3 = driver.findElement(By.xpath("//*[@class='help-block'][@data-bv-result=\"INVALID\"]"));
        Assert.assertTrue(element3.isDisplayed());


    }

    @Test(priority = 2, enabled = true)
    public void testCase2() {
        List<WebElement> tr = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));
        String empty = "";
        for (WebElement each : tr) {
            //  each.getText();
            empty += each.getText();
            System.out.println(each.getText());
            if (empty.contains(each.getText())) {
                System.out.println(true);
            }


        }


    }

    @Test(priority = 3)
    public void testCase3() {
       // String actual = "";

        WebElement element = driver.findElement(By.xpath("//input[@data-bv-field='firstname']"));
        element.sendKeys("a");
        WebElement element1 = driver.findElement(By.xpath("//small[@data-bv-for='firstname'][@data-bv-result='INVALID']"));
      //  actual += element1.getText();
        //String expected = element1.getText();
//        Assert.assertEquals(actual, expected, "Yessirrr");

        Assert.assertTrue(element1.isDisplayed());


    }


    @Test(priority = 4)
    public void testCase4() {
        WebElement element = driver.findElement(By.xpath("//input[@data-bv-field='lastname']"));
        element.sendKeys("s");
        WebElement element1 = driver.findElement(By.xpath("//small[@data-bv-for='lastname'][@data-bv-result='INVALID']"));
        System.out.println(element1.getText());
        Assert.assertTrue(element1.isDisplayed());

    }
    @Test(priority = 5)
    public void TestCase5() throws InterruptedException {
        Faker fatih = new Faker();
        String name = fatih.name().firstName();
        String lastName = fatih.name().lastName();
        String userName = fatih.name().username();
        String pass = "Weatherhot";
        String phoneNumber = fatih.phoneNumber().cellPhone();

        String dob = fatih.date().birthday().toString();

        WebElement element = driver.findElement(By.xpath("//input[@data-bv-field='firstname']"));
element.sendKeys(name);

        WebElement element1= driver.findElement(By.xpath("//input[@data-bv-field='lastname']"));
element1.sendKeys(lastName);

WebElement element2 = driver.findElement(By.xpath("//input[@data-bv-field='username']"));
element2.sendKeys(userName);


WebElement element3 = driver.findElement(By.xpath("//input[@data-bv-field='password']"));
element3.sendKeys(pass);

WebElement element4 = driver.findElement(By.xpath("//input[@data-bv-field='phone']"));
element4.sendKeys(phoneNumber);


WebElement element5 = driver.findElement(By.xpath("//input[@value='male']"));
element5.click();


WebElement element6 = driver.findElement(By.xpath("//input[@data-bv-field='birthday']"));
element6.click();





        WebElement dropDown = driver.findElement(By.xpath("//select[@name='department']"));
        Select select = new Select(dropDown);


        List<WebElement> option = select.getOptions();
        for (WebElement each : option){


            if (each.getText().equals("MCR")){


                each.click();
            }

        }
        WebElement dropDown1 = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select select1 = new Select(dropDown1);


        List<WebElement> option1 = select1.getOptions();


        for (WebElement each1 : option1){

            if (each1.getText().equals("QA")){


                each1.click();
            }
        }
        WebElement click  = driver.findElement(By.xpath("//input[@value='java']"));
        click.click();


        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();


    }

}