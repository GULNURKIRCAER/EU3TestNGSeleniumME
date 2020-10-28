package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {
//            //we have to enter this line every time we want to open chrome
//            // can you make chrome ready for me for automation
//        WebDriverManager.chromedriver().setup();
//
//            //object creation from chrome driver
//            //WebDriver represent the browser
//            //new ChromeDriver ()-->this part will open chrome browser
//        WebDriver driver=new ChromeDriver();
//
//            //.get method used for navigation to page
//        driver.get("https://cybertekschool.com");
                //this line will allow selenium to automate firefox browser
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();

        driver.get("https://google.com");
    }
}
