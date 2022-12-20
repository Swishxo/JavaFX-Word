package com.example.demo1;

public class Word {

    private String wordDoc;
    private int numberDoc;

    public Word(String wordDoc, int numberDoc) {
        this.wordDoc = wordDoc;
        this.numberDoc = numberDoc;
    }

    public String getWordDoc() {

        return wordDoc;
    }

    public void setWordDoc(String wordDoc) {

        this.wordDoc = wordDoc;
    }

    public int getNumberDoc() {

        return numberDoc;
    }

    public void setNumberDoc(int numberDoc) {

        this.numberDoc = numberDoc;
    }
}
