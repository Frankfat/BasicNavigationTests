package com.Kesiye;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/*
<tables>
   <thead>
       <tr>
            <th>
            <th>
            <th>
            <th>
            <th>
            <th>
   <tbody>
        <tr>
        <tr>
        <tr>
        <tr>
   </tables>


 */
public class WebTables {
WebDriver driver;
@BeforeMethod
    public void setUp(){
    driver = BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/tables");


}
@Test
public void Test1(){
    WebElement element = driver.findElement(By.xpath("//table[1]/thead/tr"));
    System.out.println(element.getText());
List<WebElement> element1 = driver.findElements(By.xpath("//table[1]/thead/tr/th"));
    System.out.println(element1.size());
    for (WebElement each:element1){
 System.out.print(each.getText().toUpperCase()+" ,");
    if (each.getText().equals("Action")){
        System.out.println("That's what u looking for"+each.getText());
    }
}

}

@Test
public void Test2(){
    // this is how you find row under tbody
    WebElement element  = driver.findElement(By.xpath("//table[1]/tbody/tr[2]"));
   System.out.println("Line of frank"+element.getText());

   //this how you find specific  cell
   WebElement element1 = driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td[2]"));
    System.out.println("Frank ==>"+element1.getText());

    //That 's how you print all body
    List<WebElement> body = driver.findElements(By.xpath("//table[1]/tbody/tr"));

//Print each cell at a time in the Table Body  (that's what she said)
    for (int i = 1; i <5 ; i++) {
        for (int j = 1;j<7;j++){
          WebElement element2 =   driver.findElement(By.xpath("//table[1]/tbody/tr["+i+"]/td["+j+"]"));
            System.out.print(element2.getText().toUpperCase() + ", ");

        }
        System.out.println();


    }
}
@Test
public void Test3(){
    //check and see salak fatih
    int count  = 0;
    List<WebElement> element = driver.findElements(By.xpath("//table[1]/tbody/tr/td[2]"));

    for (WebElement each : element){
        count++;
        System.out.println(count+each.getText());
    }
}
@AfterMethod
    public void tearDown(){
    driver.quit();
}

}
