package com.minarchenko;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {

    public static String readFile(String filename) {
       String content = null;
       File file = new File(DataSource.class.getClassLoader().getResource(filename).getFile());
       try (FileReader reader = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static List<String> getSentence(String textInLine) {
        List<String> sentences = Arrays.asList(textInLine.split("\\."));
        return sentences;
    }

    public static List<String> getSentencesWithout(List<String> sentencesWith) {
        List<String> sentencesWithout = new ArrayList<>();

        for (String sentenceWith : sentencesWith) {
            sentencesWithout.add(sentenceWith.replaceAll("  +|\\t\\t+", " "));
        }
        return sentencesWithout;
    }

    public static List<String> maxString(List<String> sentencesList,char firstLeter, char lastLetter) {

        List<String> sentencesListResult = new ArrayList<>();
        int firstLetterIndex = 0;
        int lastLetterIndex = 0;

        for (String sentenceWith : sentencesList) {

            firstLetterIndex = sentenceWith.indexOf(firstLeter);
            lastLetterIndex = sentenceWith.lastIndexOf(lastLetter);

            if (lastLetterIndex > firstLetterIndex && firstLetterIndex >= 0) {
                if (firstLetterIndex > 0 && sentenceWith.length() != lastLetter) {
                    sentencesListResult.add(sentenceWith.substring(0, firstLetterIndex) + sentenceWith.substring(lastLetterIndex + 1, sentenceWith.length()));
                } else if (firstLetterIndex == 0 && sentenceWith.length() != lastLetter) {
                    sentencesListResult.add(sentenceWith.substring(lastLetterIndex + 1, sentenceWith.length()));
                } else if (firstLetterIndex != 0 && sentenceWith.length() == lastLetter) {
                    sentencesListResult.add(sentenceWith.substring(0, firstLetterIndex));
                }
            }
        }
        return sentencesListResult;
    }

}