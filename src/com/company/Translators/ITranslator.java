package com.company.Translators;

import com.company.Languages.ILanguage;
import com.company.Token;

public interface ITranslator {

    String translate(ILanguage lang, Token token);

}
