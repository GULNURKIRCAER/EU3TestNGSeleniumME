package com.cybertek.tests.day1_intro;

 import com.github.javafaker.CreditCardType;
 import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {

       // System.out.println("hello world");

        Faker faker=new Faker();

        System.out.println(faker.name().fullName());

        System.out.println(faker.harryPotter().character());

        System.out.println(faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS));

        System.out.println(faker.finance().creditCard());
        System.out.println(faker.address().country());








    }
}
