package com.cybertek.tests.day1_intro;

import java.util.Arrays;

public class NEW2 {
    public static void main(String[] args) {

        String T = "MSSLS";
        String K = "LLMS";
        String L = "SMS";
        System.out.println(getSmall(L));
    }
    public static String getSmall(String A) {

        char [] tChar=A.toCharArray();
        Arrays.sort(tChar);
        String newT = new String(tChar);

        StringBuilder result = new StringBuilder(newT);

        String finalResult = result.reverse().toString();

        return finalResult;
    }
}
