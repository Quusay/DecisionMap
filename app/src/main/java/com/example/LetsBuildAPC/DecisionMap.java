package com.example.LetsBuildAPC;

import java.io.*;


//import CustomExceptions.UnexpectedType;

import static java.lang.Integer.*;

public class DecisionMap {

    DecisionNode head;
    DecisionNode tail;


    public DecisionMap(BufferedReader csvRead) throws FileNotFoundException {

        //This breaks down the file into its parts by commas
        buildUnorderedList(csvRead);
        buildOrderedMap();

    }

    private void append(DecisionNode newNode) {

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode(null);

            return;
        }

        this.tail.setLinkedNode(newNode);
        this.tail = newNode;
    }

    public void buildUnorderedList(BufferedReader br) {
        DecisionNode node;
        String line = "";

        try{
            while((line = br.readLine()) != null){
                node = buildNode(line);
                append(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void buildOrderedMap() {

        if (head == null) {
            return;
        }

        DecisionNode nodeLinker;
        nodeLinker = head;

        while (nodeLinker != null) {

            int firstChoiceID = nodeLinker.getChoice1ID();
            int secondChoiceID = nodeLinker.getChoice2ID();

            DecisionNode firstChoiceNode = nodeFetch(firstChoiceID);
            DecisionNode secondChoiceNode = nodeFetch(secondChoiceID);

            nodeLinker.setChoice1Node(firstChoiceNode);
            nodeLinker.setChoice2Node(secondChoiceNode);

            nodeLinker = nodeLinker.getLinkedNode();

        }

        cleanup();

    }

    private void cleanup(){
        if (head == null) {return;}

        DecisionNode currentNode = head;
        DecisionNode nextNode = head.getLinkedNode();

        while (nextNode != null) {

            currentNode.setLinkedNode(null);

            currentNode = nextNode;
            nextNode = currentNode.getLinkedNode();
        }
    }

    //this takes each line and turns it into an array
    //then splits it up.
    private DecisionNode buildNode(String line) {
            String[] stringArray = line.split(",");
            DecisionNode n = new DecisionNode();


            //n.setNodeID(parseInt(stringArray[0]));

            //the methods below are using the integer class
            //since there is a static in the import we don't need
            //to use integer.valeOf.
            n.setNodeID(valueOf(stringArray[0]));
            n.setChoice1ID(valueOf(stringArray[1]));
            n.setChoice2ID(valueOf(stringArray[2]));

            n.setChoice1(stringArray[3]);
            n.setChoice2(stringArray[4]);
            n.setDescription(stringArray[5]);

            return n;
    }

    public DecisionNode entryPoint() {
        return head;
    }

    private DecisionNode nodeFetch(int nodeID) {

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            if(nodeLinker.getNodeID() == nodeID){
                break ;
            }
            nodeLinker = nodeLinker.getLinkedNode();
        }

        return nodeLinker;
    }


    private boolean isEmpty() {
        return this.head == null;
    }
}
