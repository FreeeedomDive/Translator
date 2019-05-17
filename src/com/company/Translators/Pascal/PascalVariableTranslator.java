package com.company.Translators.Pascal;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class PascalVariableTranslator implements ITranslator {

    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("int"))
            return null;
        return "var " + token.var_name + ":=" + token.var_value + ";";
    }

}
