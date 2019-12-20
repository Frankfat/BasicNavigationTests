package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
    WebDriver driver ;
    @BeforeMethod
    public void setupMethod() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement element = driver.findElement(By.linkText("File Upload"));
        element.click();

    }
    @Test
    public void upload() throws InterruptedException {
       WebElement element =  driver.findElement(By.id("file-upload"));
        System.out.println(element);
        System.out.println("sasaasasa");
       element.sendKeys("C:\\Users\\Frank\\Desktop\\HTML.txt");
       driver.findElement(By.id("file-submit")).click();
       Thread.sleep(5000);
       String expected = "HTML.txt";
       String actual = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual,expected,"Kralllllll");

    }
}
