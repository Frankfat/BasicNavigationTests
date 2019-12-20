package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class TitleVerification {
    public static void main(String[] args) throws InterruptedException{
      String [] list = new String[]{"http://practice.cybertekschool.com/",
        "http://practice.cybertekschool.com/dropdown",
        "http://practice.cybertekschool.com/login"};

        List<String> list1 = Arrays.asList(list);
String title = "";
String URL = "";

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (int i = 0;i<list1.size();i++) {
            driver.get(list1.get(i));
            sleep(1000);
            title = driver.getTitle();
            URL = driver.getCurrentUrl();

            if (driver.getTitle().equalsIgnoreCase(title) && driver.getCurrentUrl().equalsIgnoreCase(URL)) {
                if (URL.startsWith("http://practice.cybertekschool.com"))
                    System.out.println((i+1)+".case: "+"PASS");

            } else {
                System.out.println((i+1)+".case: "+"FAIL");
            }
        }
driver.quit();



    }
}
