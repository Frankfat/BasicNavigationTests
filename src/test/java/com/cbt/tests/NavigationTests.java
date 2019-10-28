package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
        firefox("firefox");
       chrome("chrome");
        safari("safari");

    }
    public static void chrome(String browserType){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
    String title = driver.getTitle();
        driver.navigate().to("https://etsy.com");
    String title1 = driver.getTitle();

        driver.navigate().back();
    //String actual = driver.getTitle();
        if(driver.getTitle().equals(title));{
        driver.navigate().forward();
        if (driver.getTitle().equals(title1)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
        driver.quit();

}

public static void firefox(String browserType){
    WebDriver driver = BrowserFactory.getDriver("firefox");
    driver.get("https://google.com");
    String title = driver.getTitle();
    driver.navigate().to("https://etsy.com");
    String title1 = driver.getTitle();

    driver.navigate().back();
    //String actual = driver.getTitle();
    if(driver.getTitle().equals(title));{
        driver.navigate().forward();
        if (driver.getTitle().equals(title1)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
    driver.quit();

}
public static String safari(String browserType){

return  null;
    }
}

