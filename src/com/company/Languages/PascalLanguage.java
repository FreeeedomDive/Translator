package com.company.Languages;

import com.company.Readers.Pascal.*;
import com.company.Translators.Pascal.*;

public class PascalLanguage extends ILanguage {

    public PascalLanguage() {
        super();
        this.readers.add(new PascalMainReader());
        this.readers.add(new PascalAssignmentReader());
        this.readers.add(new PascalForReader());
        this.readers.add(new PascalPrintReader());
        this.readers.add(new PascalVariableReader());
        this.register(new PascalMainTranslator());
        this.register(new PascalAssignmentTranslator());
        this.register(new PascalForTranslator());
        this.register(new PascalPrintTranslator());
        this.register(new PascalVariableTranslator());
    }
}
