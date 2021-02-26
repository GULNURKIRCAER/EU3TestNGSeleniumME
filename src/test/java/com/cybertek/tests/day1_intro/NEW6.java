package com.cybertek.tests.day1_intro;

import java.util.*;

public class NEW6 {

    public static void main(String[] args) {

        int[] A = new int[]{2, 4, 5, 4, 2};
        //System.out.println(solution(A));

    }
    public static int solution(int[] A) {

        List<Integer> list = new ArrayList<Integer>();
        int notHavePair = -999;
        for (int i : A) {
            list.add(i);
        }
        //System.out.println(list);
        Collections.sort(list);
        //System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1){

                notHavePair=list.get(i);
                break;
            }
            int left = list.get(i);
            int right = list.get(i + 1);

            if (left == right ) {
                i++;
            }else{
                notHavePair = left;
                break;
            }
        }
        return notHavePair;
    }
}

