package com.company.Readers.Pascal;

import com.company.Readers.Reader;
import com.company.Token;

public class PascalPrintReader extends Reader {

    public PascalPrintReader() {
        super("println();");
    }

    @Override
    public Token tryReadToken(String input) {
        var start = "println(";
        var result = super.tryReadToken(input, start);
        if (result == null)
            return null;
        var content = result.substring(start.length(), result.indexOf(';') - 1);
        return new Token("sout", result, content);
    }
}
