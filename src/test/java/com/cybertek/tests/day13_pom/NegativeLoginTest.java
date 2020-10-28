package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void OpenBrowserWithConf(){

        LoginPage loginPage=new LoginPage(); // locator kullanmadik burada diger siniftan cagirdik

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        //driver.findElement(By.id("prependedInput")).sendKeys("user1");
        //driver.findElement(By.id("prependedInput2")).sendKeys("somepassword"+ Keys.ENTER);

        //Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        if(driver.getCurrentUrl().equals("https://qa1.vytrack.com/user/login")){
            System.out.println("wrong password");
        }else
            System.out.println("true password");

    }
    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        //Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        if(driver.getCurrentUrl().equals("https://qa1.vytrack.com/user/login")){
            System.out.println("wrong username");
        }else
            System.out.println("true username");

    }

}
