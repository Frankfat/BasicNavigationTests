package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class TitleVerification2 {
    public static void main(String[] args) throws InterruptedException {
        String [] list = new String[]{"https://www.luluandgeorgia.com/",
                "https://wayfair.com/", "https://walmart.com","https://westelm.com/"};
        List<String> list1 = Arrays.asList(list);
        WebDriver driver = BrowserFactory.getDriver("chrome");
        String URL = "";
        String title = "";
        boolean a = true;
        String title1="";

        for (int i = 0;i<list1.size();i++) {
            driver.get(list1.get(i));
            sleep(1000);
            URL = driver.getCurrentUrl().toLowerCase();
            title = driver.getTitle().toLowerCase();
           title1=title.replaceAll(" ","");
            a = URL.contains(title1);

            System.out.println(URL);
            System.out.println(title1);
            if (a == true) {

                System.out.println((i + 1) + ".case: " + "PASS");

            } else {
                System.out.println((i + 1) + ".case: " + "FAIL");
            }
        }
driver.quit();
    }
}
