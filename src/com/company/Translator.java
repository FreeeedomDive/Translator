package com.company;

import com.company.Languages.ILanguage;

import java.util.HashMap;

public class Translator {

    public HashMap<String, ILanguage> languages;

    Translator() {
        languages = new HashMap<>();
    }

    public void register(String name, ILanguage language) {
        languages.put(name, language);
    }

    public String translate(String initial, String target, String source) {
        var originalLang = languages.get(initial);
        var targetLang = languages.get(target);
        var code = source.replaceAll("\n", "");
        Lexer lexer = new Lexer();
        for (var reader : originalLang.readers) {
            lexer.register(reader);
        }
        var tokens = lexer.tokenize(code);
        var mainTranslator = targetLang.translators.get(0);
        var result = mainTranslator.translate(targetLang, tokens[0]);
        return result;
    }

}
