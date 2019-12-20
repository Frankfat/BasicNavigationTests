package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsExamplesTest {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= BrowserFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
//Actions ==> class that contains all the user interactions
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
//moveToElement() ==> moves the mouse on top of the given element
        //perform()==> complete the action
        actions.moveToElement(img1).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed());


    }
    @Test
    public void dragDropTest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
//==>drag the element
        WebElement source = driver.findElement(By.id("draggable"));
        //==>drop here
        WebElement target = driver.findElement(By.id("droptarget"));

            Actions actions = new Actions(driver);
            Thread.sleep(2000);

            //dragAndDrop ==> drags the source to arget
        actions.dragAndDrop(source,target).perform();
    }
    @Test
    public void dragDropByChaningTest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
//==>drag the element
        WebElement source = driver.findElement(By.id("draggable"));
        //==>drop here
        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
       //build ==> is chain the actions
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();

    }
}
