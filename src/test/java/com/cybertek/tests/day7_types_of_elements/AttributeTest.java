package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadiopButton=driver.findElement(By.id("blue"));

        blueRadiopButton.getAttribute("value");

        //get the value of type attribute.
        System.out.println(blueRadiopButton.getAttribute("type"));


        //get the value of name attribute
        System.out.println(blueRadiopButton.getAttribute("name"));

        //get the value of checked attribute.it does not keep any value ,it
        //will return true or false
        System.out.println(blueRadiopButton.getAttribute("checked"));

        //trying to get attribute that does not exist.answer is null
        System.out.println(blueRadiopButton.getAttribute("href"));


        //all atrribute AS A STRING
        blueRadiopButton.getAttribute("outerHTML");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2=driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));

   //     String outerHTML=button2.getAttribute("outerHTM");
   //     Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("inner HTML: "+button2.getAttribute("innerHTML"));

        driver.quit();

    }
}
