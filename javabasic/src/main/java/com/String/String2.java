package com.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName String2
 * @Description TODO
 * @Author tommy
 * @Date 7/31/2020 12:25 PM
 **/
public class String2 {
    public static void main(String[] args) {
//        String string = "\""+"“"+"”";
//        StringBuffer str = new StringBuffer(string);
//        System.out.println(str);
//        System.out.println("\\");
//        String string1= string.replaceAll("”","\\"+"”");
//        String string2= string.replaceAll("\"","\\"+"\"");
//        String string3= string.replaceAll("“","\\"+"“");
//        System.out.println(string3);



        String t = "\"world\"";
        String p = "\"([^\"]*)\"" ;
        Pattern P=Pattern.compile(p);
        Matcher matcher1=P.matcher(t);
        if(matcher1.find())
        {
            System.out.println(matcher1.group(0).replaceAll(p, "$1"));
        }

        String string = "\"11\""+" “"+"22 ”";
        String string1 =" \" \\ \" “/” ";
        String string2 ="&quot;/&quot; &ldquo;\\&rdquo; ";

        System.out.println(string.replaceAll("\"","\\\\\"").replaceAll("“","\\\\“").replaceAll("”","\\\\”"));
        if (string1.contains("\"")||string1.contains("“")||string1.contains("”")) {
            System.out.println(string1.replaceAll("\"", "\\\\\"").replaceAll("“", "\\\\“").replaceAll("”", "\\\\”"));
        }

        System.out.println(string2.replaceAll("&quot;","\"")
                .replaceAll("&ldquo;","“").replaceAll("&rdquo;","”")
                .replaceAll("&lsquo;","‘").replaceAll("&rsquo;","’")
                .replaceAll("&#39;","`").replaceAll("&amp;","&")
                .replaceAll("&middot;","·").replaceAll("&hellip;","…"));
    }
}
