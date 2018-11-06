package com.minarchenko;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String fileContent=DataSource.readFile( "text.csv");
        List<String> sentencesWith=DataSource.getSentence(fileContent);
        List<String> sentences=DataSource.getSentencesWithout(sentencesWith);

        System.out.println(fileContent);
        for (String sentence:sentences) {
            System.out.println(sentence);
        }
        System.out.println();

        List<String> stringsWithoutMax=DataSource.maxString(sentences,'h','l');
        for (String sentence:stringsWithoutMax) {
            System.out.println(sentence);
        }
    }
}
