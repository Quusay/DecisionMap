package com.example.LetsBuildAPC;

public class Choice {
    private String text;
    private int nextPage;

    public Choice(String textId, int nextPage) {
        this.text = textId;
        this.nextPage = nextPage;
    }

    public String getText() {
        return text;
    }

    public void setTextId(String text) {
        this.text = text;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}