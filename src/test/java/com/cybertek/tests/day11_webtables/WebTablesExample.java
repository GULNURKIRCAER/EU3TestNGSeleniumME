package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllHeaders() {
        //how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println(headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize() {
        //how many columns we have? sutun
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());

        //number of rows satir
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithOutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithOutHeader.size());
    }

    @Test
    public void getRow() {
        WebElement Row2 = driver.findElement(By.xpath("//table[@id='table1']//tr[2]"));
        System.out.println(Row2.getText());

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i < numRows.size(); i++) {

            WebElement Row = driver.findElement(By.xpath("//table[@id='table1']//tr["+i+"]"));
            System.out.println(i+"-"+Row.getText());
        }
    }
    @Test
    public void getAllCellInOneRow(){

        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void getSingleCellByIndex() {

       WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
    }
    @Test
    public void printAllCellByIndex() {
    int rowNumber=getNumberOfRows();
    int colNumber=getNumberOfColumns();
        System.out.println("colNumber="+colNumber);
        System.out.println("rowNumber="+rowNumber);

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= colNumber; j++) {

                String singleCell = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";

                //System.out.println(singleCell);

                WebElement cell = driver.findElement(By.xpath(singleCell));

                System.out.println(cell.getText());
            }
        }
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName="Jason";

        String xpath ="//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithOutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        return allRowsWithOutHeader.size();
    }
}
