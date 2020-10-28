package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class homework12 {

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
    public void test1() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        Thread.sleep(6000);

        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("“wrong_dob");

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));

        Assert.assertTrue(warningMessage.isDisplayed(), "The date of birth is not valid");

        System.out.println(warningMessage.getText());

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        Thread.sleep(2000);

        List<WebElement> languages = driver.findElements(By.cssSelector("label[class='form-check-label']"));

        for (WebElement language : languages) {
            System.out.println(language.getText());
            Assert.assertTrue(language.isDisplayed(), "verify languages are displayed");
        }
    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("input[name='firstname']"));

        inputBox.sendKeys("g");

        Thread.sleep(6000);

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));

        Assert.assertTrue(warningMessage.isDisplayed(), "first name must be more than 2 and less than 64 characters long");

        System.out.println(warningMessage.getText());
    }

    @Test
    public void test4() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("input[name='lastname']"));

        inputBox.sendKeys("k");

        Thread.sleep(6000);

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));

        Assert.assertTrue(warningMessage.isDisplayed(), "The last name must be more than 2 and less than 64 characters long");

        System.out.println(warningMessage.getText());
    }

    @Test
    public void test5() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("gulnur");

        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("akkoch");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("gulnurakkoch");

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("gulnur@yahoo.com");

        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("gulakkoch");

        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("782-884-7362");

        driver.findElement(By.cssSelector("input[value='female']")).click();

        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("11/25/1984");

        WebElement department = driver.findElement(By.cssSelector("select[name='department']"));

        Select departmentOffice = new Select(department);
        departmentOffice.selectByIndex(5);

        WebElement jobTitle = driver.findElement(By.cssSelector("select[name='job_title']"));

        Select JobTitle = new Select(jobTitle);
        JobTitle.selectByIndex(5);

        driver.findElement(By.cssSelector("label[for='inlineCheckbox2']")).click();

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"content\"]//p"));

        Assert.assertTrue(successMessage.isDisplayed(), "You've successfully completed registration!");

        System.out.println(successMessage.getText());
    }

    @Test
    public void test6() throws InterruptedException {

        driver.get("https://www.tempmailaddress.com/");

        WebElement result = driver.findElement(By.id("email"));
        String resultEmail = result.getText();
        System.out.println("resultEmail = " + resultEmail);

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.cssSelector("input[name='full_name']")).sendKeys("gulnur");

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(resultEmail);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement warningMessage = driver.findElement(By.cssSelector("h3[name='signup_message']"));

        Assert.assertTrue(warningMessage.isDisplayed(), "Thank you for signing up. Click the button below to\n" +
                "return to the home page.");

        System.out.println(warningMessage.getText());
        Thread.sleep(2000);

        driver.navigate().to("https://www.tempmailaddress.com/");

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("td[class='from']>span")).isEnabled(),"an email from\n" +
                "do-not-reply@practice.cybertekschool.com");

        driver.findElement(By.cssSelector("td[class='from']>span")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("span[id='odesilatel']")).isDisplayed());

        System.out.println("email is from:"+driver.findElement(By.cssSelector("span[id='odesilatel']")).getText());

        Assert.assertTrue(driver.findElement(By.cssSelector("span[id='predmet']")).isDisplayed());

        System.out.println("subject is:"+driver.findElement(By.cssSelector("span[id='predmet']")).getText());

    }

    @Test
    public void test7() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/upload']")).click();

        WebElement uploadElement = driver.findElement(By.id("file-upload"));

        uploadElement.sendKeys("/Users/macbookpro/Downloads/class note.txt");

//        MAC
//        1.Right click on the file
//        2.Hold option key
//        3.Select option Copy "file.txt" as Pathname

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement warningMessage1 = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));

        Assert.assertTrue(warningMessage1.isDisplayed(), "File Uploaded!");

        System.out.println(warningMessage1.getText());

        WebElement warningMessage2 = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(warningMessage2.isDisplayed());

        System.out.println(warningMessage2.getText());
    }

    @Test
    public void test8() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/autocomplete']")).click();

        driver.findElement(By.cssSelector("input[id='myCountry']")).sendKeys("United States of America");

        driver.findElement(By.cssSelector("input[value='Submit']")).click();

        WebElement message = driver.findElement(By.cssSelector("p[id='result']"));

        Assert.assertTrue(message.isDisplayed());

        System.out.println(message.getText());
    }

    @Test
    public void test9() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/status_codes']")).click();

        driver.findElement(By.cssSelector("a[href='status_codes/200']")).click();

        String msg = driver.findElement(By.tagName("p")).getText();

        boolean contains = msg.contains("This page returned a 200 status code");
        Assert.assertTrue(contains);
    }
    @Test
    public void test10() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/status_codes']")).click();

        driver.findElement(By.cssSelector("a[href='status_codes/301']")).click();
        //String message = driver.findElement(By.xpath("//p[contains(text(),'301 status code')]")).getText();
       // System.out.println(message);

        WebElement messageElement = driver.findElement(By.xpath("//*[@class='example']/p"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = js.executeScript("return arguments[0].childNodes[0].textContent;",messageElement).toString();

        System.out.println(message);
    }
    @Test
    public void test11() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/status_codes']")).click();

        driver.findElement(By.cssSelector("a[href='status_codes/404']")).click();

        WebElement message= driver.findElement(By.cssSelector("div.example>p"));

        Assert.assertTrue(message.isDisplayed());

        System.out.println(message.getText());

    }
    @Test
    public void test12() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/status_codes']")).click();

        driver.findElement(By.cssSelector("a[href='status_codes/500']")).click();

        WebElement message= driver.findElement(By.cssSelector("div.example>p"));

        Assert.assertTrue(message.isDisplayed());

        System.out.println(message.getText());

    }
    @Test(dataProvider="getDatak")
    public void setData(String myPath) throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[.='Status Codes']/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(myPath)).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector(".example p")).isDisplayed());
        Thread.sleep(2000);driver.quit();
    }

    @DataProvider
    public Object[][] getDatak()
    {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[4][1];
        data[0][0] ="//*[.='200']/a";
        data[1][0] ="//*[.='301']/a";
        data[2][0] ="//*[.='404']/a";
        data[3][0] ="//*[.='500']/a";
        return data;
    }
    @Test(dataProvider = "getData")
    public void statCodes(String code, String message) throws InterruptedException {
        driver.findElement(By.linkText(code)).click();
        String msg = driver.findElement(By.tagName("p")).getText();
        boolean contains = msg.contains(message);
        Assert.assertTrue(contains);
    }
    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[4][2];
        //first column = > error code
        // second column => er¬ror message
        // test case 9
        data[0][0] = "200";
        data[0][1] = "This page returned a 200 status code";
        // test case 10
        data[1][0] = "301";
        data[1][1] = "This page returned a 301 status code";
        // test case 11
        data[2][0] = "404";
        data[2][1] = "This page returned a 404 status code";
        // test case 12
        data[3][0] = "500";
        data[3][1] = "This page returned a 500 status code";
        return data;
    }
    }

