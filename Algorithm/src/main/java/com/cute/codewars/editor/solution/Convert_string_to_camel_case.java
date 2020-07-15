package com.cute.codewars.editor.solution;
//Complete the method/function so that it converts dash/underscore delimited words
// into camel casing. The first word within the output should be capitalized only if
// the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
//
//        Examples
//        toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"
//
//        toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Convert_string_to_camel_case {
    public static void main(String[] args){
        System.out.println(toCamelCase("the-stealth_Warrior"));
    }
    static String toCamelCase(String s){
        char[] ch = s.toCharArray();
        for (int i=0;i<ch.length;i++){
            if(ch[i] == '-' || ch[i] == '_'){
                String tmp= String.valueOf(ch[i+1]);
                tmp = tmp.toUpperCase();
                ch[i+1]=tmp.charAt(0);
            }
        }
        StringBuilder res = new StringBuilder();
        for (char i:ch) { res.append(i); }

        return res.toString().replaceAll("-|_","");
    }


    /**
     * 正则表达式底层
     * @param s
     * @return
     */
    static String toCamelCase2(String s){
        Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        return m.appendTail(sb).toString();
    }

    /**
     * 正则表达式底层2
     * @param s
     * @return
     */
//    static String toCamelCase6(String s){
//        return Pattern.compile("[-|_](.)").matcher(s).replaceAll(r -> r.group(1).toUpperCase());
//    }

    /**
     * 流
     * @param str
     * @return
     */
    static String toCamelCase3(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }

    /**
     * 流2
     * @param s
     * @return
     */
    static String toCamelCase5(String s){
        String[] stringArray = s.split("[-|_]");

        return stringArray[0] + Arrays.stream(stringArray).skip(1).map(i -> i.substring(0,1).toUpperCase()+i.substring(1))
                .collect(Collectors.joining());
    }
    /**
     * 循环加流
     * @param s
     * @return
     */
    static String toCamelCase4(String s){
        String[] words = s.split("[_\\-]");
        s=words[0];
        for(int i=1; i<words.length; i++)
            s+=words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
        return s;
    }
}

