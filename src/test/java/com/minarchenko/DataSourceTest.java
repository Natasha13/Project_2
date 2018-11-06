package com.minarchenko;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DataSourceTest {
    @Test
    public void testReadFile() throws Exception {
        String fileContent=DataSource.readFile( "testText.csv");
        String fileContentForComparing="  But the new watches are flatter too. sofeedback as it's turned.";
        Assert.assertEquals(fileContent,fileContentForComparing);
    }

    @Test
    public void testGetSentence() throws Exception {

        List<String> sentencesForComparing = Arrays.asList("  But the new watches are flatter too"," sofeedback as it's turned");
        List<String> sentences =DataSource.getSentence("  But the new watches are flatter too. sofeedback as it's turned.");
        Assert.assertEquals(sentences,sentencesForComparing);
    }

    @Test
    public void testGetSentencesWithout() throws Exception {
        List<String> sentencesForComparing = Arrays.asList(" But the new watches are flatter too"," sofeedback as it's turned");
        List<String> sentences =DataSource.getSentencesWithout(Arrays.asList("  But the new watches are flatter too"," sofeedback as it's turned"));
        Assert.assertEquals(sentences,sentencesForComparing);
    }

    @Test
    public void testMaxString() throws Exception {
        List<String> sentencesForComparing = Arrays.asList(" But thoo"," sofurned");
        List<String> sentences =DataSource.maxString(Arrays.asList(" But the new watches are flatter too"," sofeedback as it's turned"),'e','t');
        Assert.assertEquals(sentences,sentencesForComparing);

    }

}