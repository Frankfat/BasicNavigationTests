package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox {
    WebDriver driver;

    @BeforeMethod
    public void Starter() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void checkTheBox(){
        driver.get("https://practice-cybertekschool.herokuapp.com/checkboxes");
      List<WebElement> element = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(element.size());
        int count=1;
        for(WebElement each : element){

            System.out.println(count+each.getText());
count++;

        }
    }
    @Test
    public void CheckBox2() throws InterruptedException {
        driver.get("https://learn.letskodeit.com/p/practice");
//      List<WebElement> element2 = driver.findElements(By.xpath("//input[@type='checkbox']"));
//      System.out.println(element2.size());
//       String some ="//*[@id=\"checkbox-example\"]/fieldset/label[";

        for (int i = 1; i < 4; i++) {
           WebElement element2 = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label["+i+"]"));
            System.out.println(element2.getText());

                    if(element2.getText().equalsIgnoreCase("BMW")){
                        element2.click();
                        Thread.sleep(3000);
                      }else{
                        driver.findElement(By.xpath("//*[@id=\"bmwcheck\"]")).click();
                    }
                  }

            }
        }

//
//        for (WebElement each1 : element2){
//        each1.click();
//        }


