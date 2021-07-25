package com.example.LetsBuildAPC;

public class Page {
    //private int imageId;
    //private int nodeId;
    private String text;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage = false;

//    public Page(int imageId, int textId) {
//        this.imageId = imageId;
//        this.textId = textId;
//        isFinalPage = true;
//    }

    public Page(String text, Choice choice1, Choice choice2) {
        //this.imageId = imageId;
        //this.nodeId = nodeId;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

//    public int getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(int imageId) {
//        this.imageId = imageId;
//    }

//    public int getNodeId(){
//        return nodeId;
//    }
//
//    public void setNodeid(int nodeId){
//        this.nodeId = nodeId;
//    }

    public String getText() {
        return text;
    }

    public void setTextId(String text) {
        this.text = text;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }
}