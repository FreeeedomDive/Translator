package com.company.Readers.Java;

import com.company.Readers.Reader;
import com.company.Token;

public class JavaAssignmentReader extends Reader {
    public JavaAssignmentReader() {
        super("=;");
    }

    @Override
    public Token tryReadToken(String input) {
        if (input.indexOf(';') == -1)
            return null;
        if (input.substring(0, input.indexOf(';')).indexOf('=') == -1 || input.substring(0, input.indexOf(';')).contains("int"))
            return null;
        if (input.charAt(0) == '\n')
            input = input.substring(1);
        var result = super.tryReadToken(input, "");
        if (result == null)
            return null;
        var var_name = result.substring(0, input.indexOf('='));
        var var_value = result.substring(result.indexOf('=') + 1, result.indexOf(';'));
        return new Token("assign", result, var_name, var_value);
    }
}
