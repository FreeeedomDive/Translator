package com.company.Translators.Pascal;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class PascalForTranslator implements ITranslator {

    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("for"))
            return null;
        StringBuilder builder = new StringBuilder();
        builder.append("for ").append("var ").append(token.for_variable).append(":=").append(token.for_start).append(" to ").append(Integer.parseInt(token.for_end) - 1).append(" do begin\n");
        for (var subToken : token.subTokens) {
            for (var tr : lang.translators) {
                var res = tr.translate(lang, subToken);
                if (res != null)
                    builder.append(res).append("\n");
            }
        }
        builder.append("end;");
        return builder.toString();
    }
}
