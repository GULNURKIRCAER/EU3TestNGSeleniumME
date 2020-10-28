package com.cybertek.tests.day12_properties_driver_tests;


import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class VyTruckUS13 {// extends de yapabilirim

    @Test
    public void SalesManager() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));// chrome

        driver.get(ConfigurationReader.get("url"));//web page

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement TablePage = driver.findElement(By.className("oro-subtitle"));

        Thread.sleep(2000);
        String page = TablePage.getText();

        System.out.println("user can see " + page + " page");

        WebElement quickLanchPad = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(quickLanchPad).perform();

        Thread.sleep(2000);
        WebElement vehiclesModel = driver.findElement(By.xpath("//span[text()='Vehicles Model']"));

        Assert.assertTrue(vehiclesModel.isDisplayed());

        vehiclesModel.click();

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement lastPage=driver.findElement(By.className("oro-subtitle"));

        String lastPage2= lastPage.getText();

        System.out.println("--------------------");

        if(driver.findElement(By.className("oro-subtitle")).getText().equals(lastPage2)){
            System.out.println("sales manager can access Vehicle model page");
            System.out.println("PASS");
        }else {
            System.out.println("sales manager can not access Vehicle model page.it is a bug");
            System.out.println("FAIL");
        }
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void StoreManager() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));// chrome

        driver.get(ConfigurationReader.get("url"));//web page

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement Dashboard = driver.findElement(By.className("oro-subtitle"));

        String page = Dashboard.getText();

        System.out.println("user can see " + page + " page");

        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(fleet).perform();

        WebElement vehiclesModel = driver.findElement(By.xpath("//span[text()='Vehicles Model']"));

        vehiclesModel.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement lastPage=driver.findElement(By.className("oro-subtitle"));

        String lastPage2= lastPage.getText();

        System.out.println("--------------------");

        if(driver.findElement(By.className("oro-subtitle")).getText().equals(lastPage2)){
            System.out.println("Store Manager can access Vehicle model page and see all Vehicle modules.");
            System.out.println("PASS");
        }else {
            System.out.println("Store Manager can not access should be able to access Vehicle model page and see all \n" +
                    "Vehicle modules.it is a bug");
            System.out.println("FAIL");
        }
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void truckDriver() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));// chrome

        driver.get(ConfigurationReader.get("url"));//web page

        String username = ConfigurationReader.get("truckdriver_username");
        String password = ConfigurationReader.get("truckdriver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement quickLaunchPad = driver.findElement(By.xpath("//h1[.='Quick Launchpad']"));

        String page = quickLaunchPad.getText();

        System.out.println("user can see " + page + " page");

        WebElement quickLanchPad = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(quickLanchPad).perform();
        
        WebElement warningMessage = driver.findElement(By.xpath("//span[text()='Vehicles Model']"));

        Assert.assertTrue(warningMessage.isDisplayed());

        warningMessage.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement lastPage=driver.findElement(By.className("oro-subtitle"));

        String lastPage2= lastPage.getText();

        System.out.println("--------------------");

        if(driver.findElement(By.className("oro-subtitle")).getText().equals(lastPage2)){
            System.out.println("truck driver can access Vehicle model page");
            System.out.println("FAIL");
        }else {
            System.out.println("truck driver can not access Vehicle model page");
            System.out.println("PASS");
        }
        Thread.sleep(3000);
        driver.quit();
    }
//    browser=chrome
//            url=https://qa2.vytrack.com/user/login
//    truckdriver_username=user7
//            truckdriver_password=UserUser123
//    salesmanager_username=salesmanager107
//            salesmanager_password=UserUser123
//    storemanager_username=storemanager55
//            storemanager_password=UserUser123

}