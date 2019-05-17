package com.company;

import com.company.Readers.Reader;

import java.util.ArrayList;

public class Lexer {

    public ArrayList<Reader> readers;

    public Lexer() {
        this.readers = new ArrayList<>();
    }

    public void register(Reader reader) {
        readers.add(reader);
    }

    public Token[] tokenize(String input) {
        ArrayList<Token> tokens = new ArrayList<>();
        for (var i = 0; i < input.length(); i++) {
            var currentString = input.substring(i);
            for (var reader : readers) {
                var result = reader.tryReadToken(currentString);
                if (result != null) {
                    tokens.add(result);
                    i += result.value.length() - 1;
                    break;
                }
            }
        }
        return tokens.toArray(new Token[tokens.size()]);
    }
}
