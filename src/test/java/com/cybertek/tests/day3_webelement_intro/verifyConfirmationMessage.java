package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) {

//        Verify confirmation message
//        open browser
//        go to http://practice.cybertekschool.com/forgot_password  Links to an external site.
//        enter any email
//        verify that email is displayed in the input box
//        click on Retrieve password
//        verify that confirmation message says ‘Your e-mail’s been sent!’
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //go to page
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox=driver.findElement(By.name("email"));

        String expectedEmail ="gulnur@cybertek.com";

        emailInputBox.sendKeys(expectedEmail);

        //verify that email is displayed in the input box

        String actualEmail = emailInputBox.getAttribute("value");


        if(expectedEmail.equals(actualEmail)){
            System.out.println("email is displayed in the input box");
        }else{
            System.out.println("email is not displayed in the input box");
        }
        System.out.println();

        // click on Retrieve password
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        WebElement actualConfirmationMessage=driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = actualConfirmationMessage.getText();

       // verify that confirmation message says ‘Your e-mail’s been sent!’
        if(expectedMessage.equals(actualMessage)){
            System.out.println("confirmation message says ‘Your e-mail's been sent!");
        }else{
            System.out.println("confirmation message does not say  ‘Your e-mail's been sent!");
        }

        driver.quit();

    }
}
