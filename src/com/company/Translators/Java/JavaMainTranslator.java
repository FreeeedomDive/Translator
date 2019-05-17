package com.company.Translators.Java;

import com.company.Languages.ILanguage;
import com.company.Token;
import com.company.Translators.ITranslator;

public class JavaMainTranslator implements ITranslator {


    @Override
    public String translate(ILanguage lang, Token token) {
        if (!token.type.equals("main"))
            return null;
        StringBuilder builder = new StringBuilder();
        builder.append("public class Main{\n")
                .append("public static void main(String[] args){\n");
        var content = new StringBuilder();
        for (var subToken : token.subTokens) {
            for (var tr : lang.translators) {
                var res = tr.translate(lang, subToken);
                if (res != null)
                    content.append(res).append("\n");
            }
        }
        builder.append(content).append("}\n}");
        return builder.toString();
    }
}
