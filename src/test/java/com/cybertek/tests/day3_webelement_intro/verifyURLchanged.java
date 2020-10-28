package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {

//        Verify URL changed
//        open chrome browser
//        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
//        enter any email
//        click on Retrieve password
//        verify that url changed to http://practice.cybertekschool.com/email_sent

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //go to page
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox=driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard action to the webelement
        emailInputBox.sendKeys("gulnur@cybertek.com");

        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        Thread.sleep(3000);

        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        String actualURL = driver.getCurrentUrl();


        Thread.sleep(3000);
        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");
        }
        System.out.println("expectedUrl = " + expectedURL);
        System.out.println("actualUrl = " + actualURL);
        driver.quit();



    }
}
