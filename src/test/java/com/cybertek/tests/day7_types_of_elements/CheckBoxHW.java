package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxHW {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("CHROME");

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBox=driver.findElement(By.id("txtAge"));

        Assert.assertFalse(checkBox.isDisplayed(),"\"Success – Check box is checked\" message is NOT displayed");

        WebElement checkBox1=driver.findElement(By.id("isAgeSelected"));

        checkBox1.click();

        Assert.assertTrue(checkBox.isDisplayed(),"\"Success – Check box is checked\" message is displayed.");

        Thread.sleep(2000);
        

    }
    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("CHROME");

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBox2=driver.findElement(By.id("check1"));
        
        String text= checkBox2.getAttribute("value");

        Assert.assertTrue(text.equals("Check All"),"Verify the text is Check All");

        System.out.println("\"Check All\" button text is " + text);

        checkBox2.click();

        WebElement checkAll=driver.findElement(By.id("isChkd"));

       // System.out.println(checkAll.getAttribute("value"));

       if(checkAll.getAttribute("value").equals("true")){
            System.out.println("All check boxes are checked");
       }else{
            System.out.println("All check boxes are NOT checked");
        }

        String text2= checkBox2.getAttribute("value");

        System.out.println("button text changed to \"" + text2+"\"");

        driver.quit();
    }
}
