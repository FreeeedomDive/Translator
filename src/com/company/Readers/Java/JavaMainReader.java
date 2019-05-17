package com.company.Readers.Java;

import com.company.Lexer;
import com.company.Readers.Reader;
import com.company.Token;

public class JavaMainReader extends Reader {
    public JavaMainReader() {
        super("");
    }

    @Override
    public Token tryReadToken(String input) {
        var start = "public class Main{public static void main(String[] args){";
        var open_braces = 0;
        for (var c : input.toCharArray()) {
            if (c == '{')
                open_braces++;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(start);
        for (var i = 0; i < open_braces; i++) {
            builder.append("}");
        }
        this.coreSymbols = builder.toString();
        var result = super.tryReadToken(input, start);
        if (result == null)
            return null;
        var tokenContent = input.substring(start.length(), input.length() - 1);
        Lexer lexer = new Lexer();
        lexer.register(new JavaForReader());
        lexer.register(new JavaSOutReader());
        lexer.register(new JavaVariableReader());
        lexer.register(new JavaAssignmentReader());
        var subTokens = lexer.tokenize(tokenContent);
        return new Token("main", result, subTokens);
    }
}
