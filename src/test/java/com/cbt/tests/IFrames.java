package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrames {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
     driver = BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void Test1(){
        driver.get("http://practice.cybertekschool.com/iframe");

        //switch to iframe
        //1.ID or NAME
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("Hello");

        //go back to previous frame/first frame,   Useful when we have switched multiple frames
        //and want to come to main content
        driver.switchTo().defaultContent();

        //2.INDEX
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).sendKeys("Hellooooo");


        // go back to parent frame
        driver.switchTo().parentFrame();


        //3. WEBELEMENT--> Locate the iframe elemnt and pass as argument
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.id("tinymce")).sendKeys("Hiiiiiii");

    }
    @Test
    public void manyManyFrames(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //top frame
        driver.switchTo().frame("frame-top");

        //switch to middle frame
        driver.switchTo().frame("frame-middle");

        //go back to parent
        driver.switchTo().parentFrame();
        // switch to right frame
        driver.switchTo().frame("frame-right");

//go back to original frame
        driver.switchTo().defaultContent();
    }

    }
