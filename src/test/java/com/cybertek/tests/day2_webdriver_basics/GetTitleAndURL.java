package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetTitleAndURL {

    public static void main(String[] args) throws InterruptedException {

        //task open chrome and navigate to http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(4000);

       driver.navigate().to("http://practice.cybertekschool.com");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        //getting title with selenium
        //shortcut for creating variable
        //Option or ALT +enter enter
        //getTitle()-->get you the title of the page

        String title = driver.getTitle();

        //.soutv
        System.out.println("title = " + title);

        //driver.getCurrentUrl() +alt+enter+enter
        String currentUrl = driver.getCurrentUrl();

        //.soutv
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        //pageSource .soutv
        System.out.println("pageSource = " + pageSource);



    }
}
