package com.company.Languages;

import com.company.Readers.Java.*;
import com.company.Translators.Java.*;

public class JavaLanguage extends ILanguage {

    public JavaLanguage() {
        super();
        this.readers.add(new JavaMainReader());
        this.readers.add(new JavaAssignmentReader());
        this.readers.add(new JavaForReader());
        this.readers.add(new JavaSOutReader());
        this.readers.add(new JavaVariableReader());
        this.register(new JavaMainTranslator());
        this.register(new JavaAssignmentTranslator());
        this.register(new JavaForTranslator());
        this.register(new JavaSOutTranslator());
        this.register(new JavaVariableTranslator());
    }
}
