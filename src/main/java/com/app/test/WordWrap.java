package com.app.test;

public class WordWrap {
    public  String wrapWord(final String sentenceToWrap, final int linelength) {
	StringBuffer wrappedSentence = new StringBuffer();
	String  wordsArr[] = sentenceToWrap.split(" ");
	int size = 0;
	for (int i = 0;i<wordsArr.length;i++) {
	    size = size  + wordsArr[i].length();
	    if (i== 0 || size<=linelength) {
		wrappedSentence.append(wordsArr[i]);
		if (i != wordsArr.length-1) {
		    wrappedSentence.append(" ");
		}
		size = size+1;
	    }
	    else {
		wrappedSentence.append("\n");
		wrappedSentence.append(wordsArr[i]);
		if (i != wordsArr.length-1) {
		    wrappedSentence.append(" ");
		}
		size = 0;
		size = size + wordsArr[i].length() + 1;
	    }
	}
	return wrappedSentence.toString();
    }
}
