package com.cybertek.tests.day15_review;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Stale extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com");

        WebElement input= driver.findElement(By.name("q"));

        input.sendKeys("Selenium"+ Keys.ENTER);
        WebElement result = driver.findElement(By.id("result-stats"));

        Assert.assertTrue(result.isDisplayed());

        //GO BACK GOOGLE
        driver.navigate().back();

        input= driver.findElement(By.name("q"));
        input.sendKeys("Java"+Keys.ENTER);
    }
}
