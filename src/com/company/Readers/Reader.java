package com.company.Readers;

import com.company.Token;

public abstract class Reader {

    public abstract Token tryReadToken(String input);

    protected String coreSymbols;

    public Reader(String symbols) {
        this.coreSymbols = symbols;
    }

    protected String tryReadToken(String input, String start) {
        if (!input.startsWith(start))
            return null;
        var kda = new KDA(coreSymbols);
        var tokenLength = 0;
        var posOfKDA = 0;
        for (int i = 0; i < input.length(); i++) {
            var symbol = input.charAt(i);
            for (var s = 0; s < kda.alphabet.length(); s++) {
                if (symbol == kda.alphabet.charAt(s)) {
                    var pos = kda.transitions.get(posOfKDA).get(symbol);
                    posOfKDA = pos == 0 ? posOfKDA : pos;
                }
            }
            tokenLength++;
            if (posOfKDA == this.coreSymbols.length())
                break;
        }
        return input.substring(0, tokenLength);
    }

}
