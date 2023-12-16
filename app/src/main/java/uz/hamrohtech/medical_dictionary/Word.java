package uz.hamrohtech.medical_dictionary;

import androidx.annotation.NonNull;

public class Word {
    private String word;
    private String definition;

    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}

