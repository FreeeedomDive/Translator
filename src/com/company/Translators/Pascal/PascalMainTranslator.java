package com.company.Translators.Pascal;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class PascalMainTranslator implements ITranslator {

    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("main"))
            return null;
        StringBuilder builder = new StringBuilder();
        var contentBuilder = new StringBuilder();
        for (var subToken : token.subTokens) {
            for (var tr : lang.translators) {
                var res = tr.translate(lang, subToken);
                if (res != null)
                    contentBuilder.append(res).append("\n");
            }
        }
        builder.append("begin\n").append(contentBuilder).append("end.");
        return builder.toString();
    }
}
