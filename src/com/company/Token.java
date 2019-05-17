package com.company;

public class Token {

    public String value;
    public String type;
    public Token[] subTokens;
    public String var_name;
    public String var_value;
    public String for_variable;
    public String for_start;
    public String for_end;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
        this.subTokens = null;
    }

    public Token(String type, String value, Token[] subTokens) {
        this.type = type;
        this.value = value;
        this.subTokens = subTokens;
    }

    public Token(String type, String value, String subValue) {
        this.type = type;
        this.value = value;
        this.var_value = subValue;
    }

    public Token(String type, String value, String var_name, String var_value) {
        this.type = type;
        this.value = value;
        this.var_name = var_name;
        this.var_value = var_value;
    }

    public Token(String type, String value, Token[] subTokens, String for_variable, String for_start, String for_end) {
        this.type = type;
        this.value = value;
        this.subTokens = subTokens;
        this.for_variable = for_variable;
        this.for_start = for_start;
        this.for_end = for_end;
    }
}
