package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {
    WebDriver driver;
    @BeforeMethod
   public void letsStart(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        WebElement element = driver.findElement(By.linkText("Registration Form"));
        element.click();

    }
    @Test
    public void DropDown2(){
        WebElement element = driver.findElement(By.xpath("//select[@name='department']"));
        Select select = new Select(element);
        List<WebElement> fatih = select.getOptions();
        String as = "";

        for(WebElement each : fatih){
            if(each.getText().equals("MCR")){
                System.out.println(each.getText());
            }else{
                as+=each.getText();
            }
            System.out.println();
            System.out.print(as);
        }

    }
    @AfterMethod
    public void closeeeeeeeeeeeeeeeeeeee(){
        driver.quit();
        //And driver.never.come.back();

    }
}
