package com.cybertek.tests.day1_intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NEW {
    public static void main(String[] args) {

        int[] A = {1, 9, 8, 7, 6, 4, 2, 3};
        int B[] = {-7, -5, -9};
        int C[] = {1, -2, 3};
        int D[] = {1, 2, 3};
        int E[] = {-1};
        int F[] = {0};
        int G[] = {-1000000};
        System.out.println(getSmall(B));
    }

    public static int getSmall(int[] A) {
        int smallestInt = 1;

        if(A.length == 0) return smallestInt;

        Arrays.sort(A);

        if(A[0] > 1) return smallestInt;
        if(A[ A.length - 1] <= 0 ) return smallestInt;

        for(int i = 0; i < A.length; i++){
            if(A[i] == smallestInt){
                smallestInt++;
            }
        }

        return smallestInt;
    }
}