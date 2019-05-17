package com.company.Readers;

import java.util.HashMap;

public class KDA {

    String alphabet, template;
    HashMap<Integer, HashMap<Character, Integer>> transitions;

    KDA(String template) {
        this.template = template;
        this.alphabet = "";
        for (int i = 0; i < this.template.length(); i++) {
            if (this.alphabet.indexOf(this.template.charAt(i)) == -1)
                this.alphabet += this.template.charAt(i);
        }
        this.transitions = new HashMap<>();
        for (int i = 0; i <= this.template.length(); i++) {
            this.transitions.put(i, new HashMap<>());
        }
        for (int i = 0; i < this.alphabet.length(); i++) {
            this.transitions.get(0).put(this.alphabet.charAt(i), 0);
        }
        for (int i = 0; i < this.template.length(); i++) {
            var previous = this.transitions.get(i).get(template.charAt(i));
            this.transitions.get(i).put(template.charAt(i), (i + 1));
            for (int s = 0; s < this.alphabet.length(); s++) {
                this.transitions.get(i + 1).put(this.alphabet.charAt(s),
                        this.transitions.get(previous).get(this.alphabet.charAt(s)));
            }
        }
    }

    public String getTableOfKDA() {
        var result = "    ";
        for (int i = 0; i < this.alphabet.length(); i++) {
            result += i + " ";
        }
        result += "\n";
        for (int i = 0; i <= this.template.length(); i++) {
            result += i + " | ";
            for (int s = 0; s < this.alphabet.length(); s++)
                result += this.transitions.get(i).get(this.alphabet.charAt(s)) + " ";
            result += "\n";
        }
        return result;
    }
}
