package com.app.test;

public class WordWrapWithRecursion {
    StringBuffer wrappedSentence = new StringBuffer();

    public String wrapWord(String wrapword, int linelength) {
	if (wrapword.indexOf(" ") > 0 && wrapword.length() > linelength) {
	    if (wrapword.indexOf(" ") > linelength){
		String firstword = wrapword.substring(0, wrapword.indexOf(" "));
		wrappedSentence.append(firstword+" \n");
		String rem = wrapword.substring(wrapword.indexOf(" "),wrapword.length());
		return wrapWord(rem.trim(),linelength);
	    }
	    String pre = wrapword.substring(0, linelength);
	    String post = wrapword.substring(linelength, wrapword.length());
	    if (post.charAt(0) != ' ') {
		int pos = pre.lastIndexOf(" ");
		wrappedSentence.append(pre.substring(0, pos)+" \n");
		String appStr = pre.substring(pos, pre.length()).trim() + post;
		return wrapWord(appStr,linelength);
	    }
	    else {
		wrappedSentence.append(pre + " \n");
		wrapWord(post.trim(), linelength);
	    }
	}
	else {
	    wrappedSentence.append(wrapword.trim());
	}
        return wrappedSentence.toString();
    }

    public static void main(String []args){

	WordWrapWithRecursion wordWrapWithRecursion = new WordWrapWithRecursion();
	String wrapWord = wordWrapWithRecursion.wrapWord("back to india",4);
	System.out.println(wrapWord);
    }
}
