package com.company.Translators.Java;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class JavaSOutTranslator implements ITranslator {

    @Override
    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("sout"))
            return null;
        return "System.out.println(" + token.var_value + ");";
    }
}
