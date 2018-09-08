package com.lre.encode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String encode(String source){
        StringBuilder string = new StringBuilder();

        for(int i=0;i<source.length();i++) {
            int runLength = 1;
            while( (i+1 < source.length()) && source.charAt(i) ==  source.charAt(i+1)){
                runLength++;
                i++;
            }
            string.append(runLength);
            string.append(source.charAt(i));
        }

        return string.toString();
    }

    public static String decode(String source){
        StringBuilder string = new StringBuilder();

        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(source);

        while(matcher.find()){
            int runLength = Integer.parseInt(matcher.group());

            matcher.find();

            while(runLength-- !=0)
                string.append(matcher.group());
        }

        return string.toString();
    }
    public static void main(String[] args) {
	System.out.println(encode("AABCCFFJJIIKLM"));
        System.out.println(decode(encode("AABCCFFJJIIKLM")));
    }
}
