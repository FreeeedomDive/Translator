package com.company.Readers.Java;

import com.company.Readers.Reader;
import com.company.Token;

public class JavaSOutReader extends Reader {
    public JavaSOutReader() {
        super("System.out.println();");
    }

    @Override
    public Token tryReadToken(String input) {
        var start = "System.out.println(";
        var result = super.tryReadToken(input, start);
        if (result == null)
            return null;
        var content = result.substring(start.length(), result.indexOf(';') - 1);
        return new Token("sout", result, content);
    }
}
