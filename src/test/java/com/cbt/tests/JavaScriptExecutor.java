package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }
@Test
    public void click(){
        driver.get("http://practice.cybertekschool.com/");
    WebElement element = driver.findElement(By.linkText("Home"));
    //This is how JavaScriptExecutor object is created

    JavascriptExecutor jse = (JavascriptExecutor) driver;

    //executeScript ==> method used to pass js command
    //first string argument is the JavaScript code
    //second argument is the webelement on which the action will be take
    jse.executeScript("arguments[0].click();",element);

}
@Test
    public void type() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement element = driver.findElement(By.cssSelector("input[disabled]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        String str = "hello";

     //   element.sendKeys("Hello");
    Thread.sleep(2000);
    jse.executeScript("arguments[0].setAttribute('value',' "+str+"')",element);
    }
    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
     //   WebElement element = driver.findElement(By.cssSelector("input[disabled]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
Thread.sleep(2000);
        jse.executeScript("scroll(0,250);");

    }

}
