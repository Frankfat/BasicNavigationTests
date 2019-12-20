package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1WaitForVisible(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        //click on start
        driver.findElement(By.tagName("button")).click();

        //finding element that is not visible
        WebElement username = driver.findElement(By.id("username"));

        //Create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,10);

        //waiting for the specific element to be visible
        //actually wait
        wait.until(ExpectedConditions.visibilityOf(username));

        //click on the element that is not visible
        username.sendKeys("something");

    }
    @Test
    public void test2TobeEnabled(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enabe
        driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
//find the input field
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));

        WebDriverWait wait = new WebDriverWait(driver,10);

        //wait for element to be clickable/enabled
wait.until(ExpectedConditions.elementToBeClickable(input));


        input.sendKeys("Fatih Uruc");
    }
}
