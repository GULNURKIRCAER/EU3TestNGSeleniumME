package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //getOptions --> returns all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();

        //print size of the options
        System.out.println("options.size() = " + options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        //String expectedOption="Select a State";

        //String actualOption=stateDropdown.getFirstSelectedOption().getText();

        //System.out.println("actualOption = " + actualOption);

        //Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN ?
        //1.SELECT USING VISIBLE TEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

//        expectedOption = "Virginia";
//        actualOption = stateDropdown.getFirstSelectedOption().getText();
//        Assert.assertEquals(actualOption,expectedOption,"verify first selection");
//
//        //2.SELECT USING TEXT
//        Thread.sleep(2000);
//        stateDropdown.selectByIndex(51);
//
//        expectedOption = "Wyoming";
//        actualOption = stateDropdown.getFirstSelectedOption().getText();
//        Assert.assertEquals(actualOption,expectedOption,"verify first selection");
//        Thread.sleep(2000);
//
//        //3.SELECT USING BY VALUE
//        stateDropdown.selectByValue("TX");
//        Thread.sleep(2000);
//
//        expectedOption = "Texas";
//        actualOption = stateDropdown.getFirstSelectedOption().getText();
//        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

    }
}
