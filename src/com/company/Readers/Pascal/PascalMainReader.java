package com.company.Readers.Pascal;

import com.company.Lexer;
import com.company.Readers.Reader;
import com.company.Token;

public class PascalMainReader extends Reader {


    public PascalMainReader() {
        super("");
    }

    @Override
    public Token tryReadToken(String input) {
        var start = "begin";
        var open_braces = 0;
        for (var i = 0; i < input.length() - 5; i++) {
            if (input.substring(i, i + 5).equals("begin"))
                open_braces++;
        }
        StringBuilder builder = new StringBuilder();
        for (var i = 0; i < open_braces; i++) {
            builder.append("end;");
        }
        this.coreSymbols = builder.toString();
        var result = super.tryReadToken(input, start);
        if (result == null)
            return null;

        var tokenContent = input.substring(start.length(), input.length() - 4);
        Lexer flexer = new Lexer();
        flexer.register(new PascalForReader());
        flexer.register(new PascalPrintReader());
        flexer.register(new PascalVariableReader());
        flexer.register(new PascalAssignmentReader());
        var subTokens = flexer.tokenize(tokenContent);
        return new Token("main", result, subTokens);
    }
}
