package com.company.Translators.Pascal;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class PascalAssignmentTranslator implements ITranslator {

    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("assign"))
            return null;
        return token.var_name + ":=" + token.var_value + ";";
    }
}
