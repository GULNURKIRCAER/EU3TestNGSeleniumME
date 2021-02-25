package com.cybertek.tests.day1_intro;

import java.util.ArrayList;
import java.util.List;

public class new5 {

        public static void main(String [] args){

            int[] a={5,3,1,3,2,3};
            int[] b={10,1,3,1,2,2,1,0,4};
            int[] c={9,9,9,9,9};
            int[] d={1,5,2,4,3,3};

            System.out.println(solution(a));
            System.out.println(solution(b));
            System.out.println(solution(c));
            System.out.println(solution(d));
        }
        public static int solution(int[] array) {

            List<Integer> countList = new ArrayList<Integer>();

            for (int i = 0; i < array.length; i++) {
                int sum = 0;
                int count = 1;
                if (i + 1 == array.length) {
                    break;
                }
                sum = array[i] + array[i + 1];

                for (int j = i + 2; j < array.length; j++) {
                    if (j + 1 == array.length) {
                        break;
                    }
                    if (sum == array[j] + array[j + 1]) {
                        j = j + 1;
                        count++;
                    }
                }
                countList.add(count);
            }
            int maxCount = -999;
            for (Integer elem : countList) {
                if (elem > maxCount) {
                    maxCount = elem;
                }
            }
            return maxCount;
        }
    }

