package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //make browser fullscreen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput=driver.findElement(By.name("full_name"));

        fullNameInput.sendKeys("Mike Smith");

        Thread.sleep(3000);

        //proper way
        WebElement fullemailInput=driver.findElement(By.name("email"));

        fullemailInput.sendKeys("gulnur@yahoo.com");

        Thread.sleep(3000);
        //lazy way
        //driver.findElement(By.name("email")).sendKeys("gulnur@yahoo.com");
       // driver.findElement(By.name("email")).click();

        WebElement signInButton=driver.findElement(By.name("wooden_spoon"));

        //lazy way
        //driver.findElement(By.name("wooden_spoon")).click();

        signInButton.click();

        Thread.sleep(3000);

        driver.quit();


    }
}
