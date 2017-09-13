package com.aojiaoo.dataStructure.tree;

//二叉搜索树
public class BinarySearchTree<Key extends Comparable<Key>, Value> extends BinaryTree<Key, Value> {


    public void insert(Key key, Value value) {

        doInsert(this.root, key, value);
        this.length++;
    }

    private void doInsert(Node<Key, Value> node, Key key, Value value) {

        if (node == null) {
            this.root = new Node<>(key, value, this.maxChildrenNode);
            return;
        }

        if (key.compareTo(node.getKey()) == 0) {
            node.set(key, value);
        } else if (key.compareTo(node.getKey()) < 0) {

            if (this.getLeftchild(node) == null) {
                node.setChildreNodesByIndex(0, new Node<>(key, value, this.maxChildrenNode));
            } else {
                doInsert(this.getLeftchild(node), key, value);
            }
        } else {

            if (this.getRightchild(node) == null) {
                node.setChildreNodesByIndex(1, new Node<>(key, value, this.maxChildrenNode));
            } else {
                doInsert(this.getRightchild(node), key, value);
            }
        }
    }

    public static void main(String[] args) {

        String[] arr = {"123", "456", "789", "111", "123"};
        BinarySearchTree<String, String> tree = new BinarySearchTree<>();


        tree.insert("a", "ccc");
        tree.insert("b", "bbb");
        tree.insert("c", "aaa");

        tree.printTree();
        //tree.traversal("sd");
    }
}
