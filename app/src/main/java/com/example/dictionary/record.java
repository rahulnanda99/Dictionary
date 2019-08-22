package com.example.dictionary;

public class record
{
    String word;
    String meaning;
    String description;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public record(String word, String meaning, String description)
    {
        this.word = word;
        this.meaning = meaning;
        this.description = description;
    }

    public record()
    {

    }

}
