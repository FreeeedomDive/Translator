package com.company.Readers.Pascal;

import com.company.Lexer;
import com.company.Readers.Reader;
import com.company.Token;

public class PascalForReader extends Reader {
    public PascalForReader() {
        super("");
    }

    @Override
    public Token tryReadToken(String input) {
        var start = "for";
        var open_braces = 0;
        var currentOpened = 0;
        for (var i = 0; i < input.length() - 5; i++) {
            if (input.substring(i, i + 5).equals("begin")) {
                currentOpened++;
                open_braces++;
            } else if (input.substring(i, i + 4).equals("end;")) {
                currentOpened--;
                if (currentOpened == 0)
                    break;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(start).append(" to do begin");
        for (var i = 0; i < open_braces; i++) {
            builder.append("end;");
        }
        this.coreSymbols = builder.toString();
        var result = super.tryReadToken(input, start);
        if (result == null)
            return null;
        Lexer lexer = new Lexer();
        lexer.register(new PascalVariableReader());
        var for_variable = result.substring(4, result.indexOf(" to ")) + ";";
        var token = lexer.tokenize(for_variable)[0];
        var predicate = result.substring(result.indexOf(" to ") + 4);
        predicate = predicate.substring(0, predicate.indexOf(' '));
        var content = result.substring(result.indexOf("begin") + 5);

        lexer.register(new PascalPrintReader());
        lexer.register(new PascalForReader());
        lexer.register(new PascalAssignmentReader());
        var subTokens = lexer.tokenize(content);

        return new Token("for", result, subTokens, token.var_name, token.var_value, predicate);
    }
}
