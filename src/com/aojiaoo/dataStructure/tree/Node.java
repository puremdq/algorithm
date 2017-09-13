package com.aojiaoo.dataStructure.tree;

public class Node<Key, Value> {

    private Key key;

    private Value value;

    private Node<Key, Value>[] childreNodes = null;
    private int maxChildreNode;
    private Node parentNode = null;

    public Node(int maxChildreNode) {
        this.key = null;
        this.value = null;
        this.maxChildreNode = maxChildreNode;
        this.childreNodes = (Node<Key, Value>[]) new Node[maxChildreNode];
        for (int i = 0; i < maxChildreNode; i++) {
            this.childreNodes[i] = null;
        }
    }

    public Node(Key key, Value value, int maxChildreNode) {

        this.key = key;
        this.value = value;
        this.maxChildreNode = maxChildreNode;
        this.childreNodes = (Node<Key, Value>[]) new Node[maxChildreNode];
        for (int i = 0; i < maxChildreNode; i++) {
            this.childreNodes[i] = null;
        }
    }


    public Key getKey() {
        return key;
    }


    public Value getValue() {
        return value;
    }

//    public Node[] getChildreNodes() {
//        return childreNodes;
//    }

//    public Node getParentNode() {
//        return this.parentNode;
//    }

    public void set(Key key, Value value) {
        this.key = key;
        this.value = value;
    }



    public Node<Key,Value> getChildrenNodeByIndex(int index) {

        if (this.childreNodes == null || index >= this.childreNodes.length) {
            return null;
        }
        return this.childreNodes[index];
    }

    public void setChildreNodesByIndex(int index, Node<Key, Value> node) {

        if (index >= this.maxChildreNode) {
            return;
        }
        this.childreNodes[index] = node;
        this.childreNodes[index].parentNode = this;
    }

}