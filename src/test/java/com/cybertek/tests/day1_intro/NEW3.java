package com.cybertek.tests.day1_intro;

public class NEW3 {

    public static void main(String[] args) {

        String sentence = "We test coders. Give us a try?";
        String basePhrase = "Forget  CVs..Save time . x x";
        System.out.println(solution(sentence));
    }
    public static int solution(String S) {
        String[] sentences = S.split("[.?!]");
        String[] words;
        int maxWords=-1;
        int currentWords;
        for(String sen : sentences) {
            words = sen.split(" ");

            currentWords = words.length;
            for(String w : words) {
                if(w.trim().length() == 0)
                    currentWords--;
            }

            maxWords = maxWords < currentWords ? currentWords : maxWords;
        }
        return maxWords;
    }

}