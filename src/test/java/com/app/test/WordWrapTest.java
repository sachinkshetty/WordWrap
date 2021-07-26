package com.app.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordWrapTest {

    WordWrap wordWrap = null;

    @Before
    public void setup() {
	wordWrap = new WordWrap();
    }

    @Test
    public void testWordWrap() {
	final String wrappedWord = wordWrap.wrapWord("i would like", 10);
	Assert.assertEquals("i would \nlike", wrappedWord);
    }

    @Test
    public void testWordWrapWithMoreWords() {
	final String wrappedWord = wordWrap.wrapWord("i would like to", 10);
	Assert.assertEquals("i would \nlike to", wrappedWord);
    }

    @Test
    public void testWordWrapWithMoreWordsAgain() {
	final String wrappedWord = wordWrap.wrapWord("i would like to wrap", 10);
	Assert.assertEquals("i would \nlike to \nwrap", wrappedWord);
    }

    @Test
    public void testWordWrapWithMoreWordsAgain1() {
	final String wrappedWord = wordWrap.wrapWord("i would like to wrap the", 10);
	Assert.assertEquals("i would \nlike to \nwrap the", wrappedWord);
    }

    @Test
    public void testWordWrapWithMoreWordsAgain2() {
	final String wrappedWord = wordWrap.wrapWord("i would like to wrap the sentence", 10);
	Assert.assertEquals("i would \nlike to \nwrap the \nsentence", wrappedWord);
    }

    // despite the word 'would' being longer then line length , i am wrapping it to new line as the word is second word of the
    // sentencee
    @Test
    public void testWordWrapWithDiffLineLength() {
	final String wrappedWord = wordWrap.wrapWord("i would like", 4);
	Assert.assertEquals("i \nwould \nlike", wrappedWord);
    }

    // if the first word  is greather  then  line  length
    @Test
    public void testWordWrapWithStartingWordGreaterThenLineLength() {
	final String wrappedWord = wordWrap.wrapWord("Sachin lives in London", 4);
	Assert.assertEquals("Sachin \nlives \nin \nLondon", wrappedWord);
    }
}
