package com.company.Translators.Java;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class JavaVariableTranslator implements ITranslator {

    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("int"))
            return null;
        return "int " + token.var_name + "=" + token.var_value + ";";
    }

}
