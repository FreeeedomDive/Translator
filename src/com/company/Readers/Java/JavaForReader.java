package com.company.Readers.Java;

import com.company.Lexer;
import com.company.Readers.Reader;
import com.company.Token;

public class JavaForReader extends Reader {

    public JavaForReader() {
        super("");
    }

    @Override
    public Token tryReadToken(String input) {
        var start = "for(";
        var open_braces = 0;
        var currentOpened = 0;
        for (var c : input.toCharArray()) {
            if (c == '{') {
                open_braces++;
                currentOpened++;
            } else if (c == '}') {
                currentOpened--;
                if (currentOpened == 0)
                    break;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(start).append(";;){");
        for (var i = 0; i < open_braces; i++) {
            builder.append("}");
        }
        this.coreSymbols = builder.toString();
        var result = super.tryReadToken(input, start);
        if (result == null)
            return null;
        Lexer lexer = new Lexer();
        lexer.register(new JavaVariableReader());
        var first_semicolon = result.indexOf(';');
        var for_variable = result.substring(4, first_semicolon + 1);
        var token = lexer.tokenize(for_variable)[0];
        var substring = result.substring(first_semicolon + 1);
        var second_semicolon = substring.indexOf(';');
        var for_predicate = substring.substring(0, second_semicolon);
        var for_end = for_predicate.substring(for_predicate.indexOf('<') + 1);
        var open_brace = result.indexOf('{');
        var content = result.substring(open_brace + 1);
        lexer.register(new JavaSOutReader());
        lexer.register(new JavaForReader());
        lexer.register(new JavaAssignmentReader());
        var subTokens = lexer.tokenize(content);
        return new Token("for", result, subTokens, token.var_name, token.var_value, for_end);
    }
}
