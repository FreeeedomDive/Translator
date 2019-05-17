package com.company;

import com.company.Languages.JavaLanguage;
import com.company.Languages.PascalLanguage;

public class Main {

    static String javacode = "public class Main{\n" +
            "public static void main(String[] args){\n" +
            "int a=0;\n" +
            "System.out.println(a);\n" +
            "for(int i=0;i<10;i++){\n" +
            "for(int j=0;j<10;j++){\n" +
            "a=a+1;\n" +
            "}\n" +
            "}\n" +
            "for(int j=0;j<10;j++){\n" +
            "a=a+1;\n" +
            "}\n" +
            "int k=3;\n" +
            "System.out.println(k);\n" +
            "System.out.println(a);\n" +
            "}\n" +
            "}";

    static String pascalcode = "begin\n" +
            "var a:=0;\n" +
            "println(a);\n" +
            "for var i:=0 to 9 do begin\n" +
            "for var j:=0 to 9 do begin\n" +
            "a:=a+1;\n" +
            "end;\n" +
            "end;\n" +
            "for var j:=0 to 9 do begin\n" +
            "a:=a+1;\n" +
            "end;\n" +
            "var k:=3;\n" +
            "println(k);\n" +
            "println(a);\n" +
            "end.";

    public static void main(String[] args) {
        System.out.println(pascalcode);
        var translator = new Translator();
        translator.register("java", new JavaLanguage());
        translator.register("pascal", new PascalLanguage());
        System.out.println("===============");
        var j1 = translator.translate("pascal", "java", pascalcode);
        System.out.println(j1);
        System.out.println("===============");
        var p1 = translator.translate("java", "pascal", j1);
        System.out.println(p1);
        System.out.println("===============");
        var j2 = translator.translate("pascal", "java", p1);
        System.out.println(j2);
        System.out.println("===============");
        var p2 = translator.translate("java", "pascal", j2);
        System.out.println(p2);
        System.out.println(pascalcode.equals(p2));
        System.out.println("===============");
    }
}
