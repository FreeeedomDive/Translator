package com.company.Translators.Java;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class JavaForTranslator implements ITranslator {

    @Override
    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("for"))
            return null;
        StringBuilder builder = new StringBuilder();
        builder.append("for(").append("int ").append(token.for_variable).append("=").append(token.for_start).append(";");
        builder.append(token.for_variable).append("<").append(Integer.parseInt(token.for_end) + 1).append(";").append(token.for_variable).append("++){\n");
        for (var subToken : token.subTokens) {
            for (var tr : lang.translators) {
                var res = tr.translate(lang, subToken);
                if (res != null)
                    builder.append(res).append("\n");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
