package com.example.guoshijie.words.Word;

public class word {
    private double partchapter;
    private String word;
    private String translation;
    public word(){

    }
    public word(double partchapter, String word, String translation){
        this.partchapter=partchapter;
        this.word=word;
        this.translation=translation;
    }


    public double getPartchapter() {
        return partchapter;
    }

    public void setPartchapter(float partchapter) {
        this.partchapter = partchapter;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
