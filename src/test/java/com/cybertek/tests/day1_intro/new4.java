package com.cybertek.tests.day1_intro;
import java.util.*;
public class new4 {


        public static void main(String []args){

            String S="example@gmail.com";

            System.out.println(solution(S));
        }
        public static boolean solution(String S) {

            if (!S.contains("@")){
                return false;
            }

            if (!S.contains(".")){
                return false;
            }
            String [] word = S.split("@");
            char[] letters = word[0].toCharArray();
            if(letters.length == 0){
                return false;
            }

            if (!word[1].contains(".com")){
                return false;
            }


            return true;
        }

    }

