package com.company.Translators.Pascal;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class PascalPrintTranslator implements ITranslator {

    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("sout"))
            return null;
        return "println(" + token.var_value + ");";
    }
}
