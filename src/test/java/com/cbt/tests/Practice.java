package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice {
    WebDriver driver;
    Actions actions;

     @BeforeMethod
    public void setUp(){
driver= BrowserFactory.getDriver("chrome");
driver.get("http://practice.cybertekschool.com/hovers");
        actions= new Actions(driver);
    }
    @Test
    public void Test1() throws InterruptedException {
        //go to each image
        //verify text user1, user2, user3
        String text="";
        for (int i = 1; i < 4; i++) {

            WebElement image =  driver.findElement(By.xpath("//div[@class='figure']"+"["+i+"]"));
            actions.moveToElement(image).perform();
            Thread.sleep(2000);
            text+=image.getText();

            System.out.println(i+"==>"+text);
        }


    }
    @AfterMethod
    public void tearDown(){
         driver.quit();

    }
}
