package com.company.Languages;

import com.company.Readers.Reader;
import com.company.Translators.ITranslator;

import java.util.ArrayList;

public abstract class ILanguage {

    public ArrayList<ITranslator> translators;
    public ArrayList<Reader> readers;

    public ILanguage() {
        this.translators = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void register(ITranslator tr) {
        translators.add(tr);
    }

}
