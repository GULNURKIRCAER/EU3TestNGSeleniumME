package com.cybertek.tests.day10_actions_js;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTestHW {

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

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(2000);
        List<WebElement> myProducts = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        // List<WebElement> myProducts = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[@src='/img/avatar-blank.jpg']")));
        Actions actions = new Actions(driver);
        for (WebElement product : myProducts) {
            actions.moveToElement(product).perform();
            WebElement viewLink = driver.findElement(By.linkText("View profile"));
            Assert.assertTrue(viewLink.isDisplayed(), "user text is displayed");

        }
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> myProducts = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[@src='/img/avatar-blank.jpg']")));

        boolean res = false;

        for (int i = 0; i < myProducts.size(); i++) {
            Actions action = new Actions(driver);

            action.moveToElement(myProducts.get(i)).build().perform();

            WebElement user = driver.findElement(By.xpath("//div[@class='figcaption']/h5"));
            
            if (user.isDisplayed())
                res = true;
            System.out.println("user text is displayed");
        }
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> imgs = driver.findElements(By.tagName("img"));
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'name: ')]"));

        Actions actions = new Actions(driver);

        for (int i = 0; i < imgs.size(); i++) {
            actions.moveToElement(imgs.get(i)).perform();
            Assert.assertTrue(elements.get(i).isDisplayed(), "verify 'name: user' text is displayed");
            System.out.println(elements.get(i).getText());
        }
    }
    @Test
    public void test4() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {

            String xpathImg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user"+i+"']";
            WebElement text1 = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(),"verify user "+i+" is displayed");
        }
    }
}
