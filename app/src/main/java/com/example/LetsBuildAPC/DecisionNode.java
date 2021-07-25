package com.example.LetsBuildAPC;

public class DecisionNode {

    int nodeID;
    int choice1ID;
    int choice2ID;
    String choice1;
    String choice2;
    String description;
//    String question;

    //the yesNode and noNode is going to be made
    //from the nodeID, yesID, noID, description and question
    //those are the linked nodes
    DecisionNode choice1Node;
    DecisionNode choice2Node;

    DecisionNode linkedNode;

    public DecisionNode() {}


    public DecisionNode getLinkedNode(){
        return linkedNode;
    }
    public void setLinkedNode(DecisionNode linkedNode){
        this.linkedNode = linkedNode;
    }
    public int getNodeID() {
        return nodeID;
    }
    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }
    public int getChoice1ID(){
        return choice1ID;
    }
    public void setChoice1ID(int choice1ID) {
        this.choice1ID = choice1ID;
    }
    public int getChoice2ID() {
        return choice2ID;
    }
    public void setChoice2ID(int choice2ID) {
        this.choice2ID = choice2ID;
    }
    public String getChoice1(){
        return choice1;
    }
    public void setChoice1(String choice1){
        this.choice1 = choice1;
    }
    public String getChoice2(){
        return choice2;
    }
    public void setChoice2(String choice2){
        this.choice2 = choice2;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public DecisionNode getChoice1Node() {
        return choice1Node;
    }
    public void setChoice1Node(DecisionNode choice1Node) {
        this.choice1Node = choice1Node;
    }
    public DecisionNode getChoice2Node() {
        return choice2Node;
    }
    public void setChoice2Node(DecisionNode choice2Node) {
        this.choice2Node = choice2Node;
    }
}

