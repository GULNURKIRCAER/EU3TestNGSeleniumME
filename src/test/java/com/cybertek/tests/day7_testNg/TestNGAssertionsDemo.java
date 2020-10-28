package com.cybertek.tests.day7_testNg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");

    }
    @Test
    public void test1(){
        System.out.println("first Assertion");
        Assert.assertEquals("title","title");
        // there is error that's why program stopped

        System.out.println("second Assertion");
        Assert.assertEquals("url","url");
    }
    @Test
    public void test2(){
        Assert.assertEquals("test2","test2","verify test2");
    }
    @Test
    public void test3(){
        String ecpectedTitle="Cyb";
        String actualTitle="Cybertek";
        Assert.assertTrue(actualTitle.startsWith(ecpectedTitle),"verify title starts with Cub");
    }
    @Test
    public void test4() {
        String email="mike@smith.com";
        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }
    @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");
    }
    @Test
    public void test6(){
        Assert.assertNotEquals("ONE","TWO");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Close browser");
    }
    
}
