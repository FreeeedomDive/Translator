package com.company.Readers.Java;

import com.company.Readers.Reader;
import com.company.Token;

public class JavaVariableReader extends Reader {

    public JavaVariableReader() {
        super("int=;");
    }

    @Override
    public Token tryReadToken(String input) {
        var result = super.tryReadToken(input, "int");
        if (result == null)
            return null;
        var var_name = result.substring(4, input.indexOf('='));
        var var_value = result.substring(result.indexOf('=') + 1, result.indexOf(';'));
        return new Token("int", result, var_name, var_value);
    }
}
