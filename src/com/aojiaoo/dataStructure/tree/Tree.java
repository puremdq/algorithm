package com.aojiaoo.dataStructure.tree;


import com.aojiaoo.dataStructure.Queue.Queue;

public class Tree<Key, Value> {


    protected Node<Key, Value> root;  // 根节点
    protected int length;  // 树中的节点个数
    protected int maxChildrenNode;  // 该树某个节点的最大节点树


    /*构造一个空树*/
    public Tree(int maxChildrenNode) {
        this.root = null;
        this.length = 0;
        this.maxChildrenNode = maxChildrenNode;
    }

    /*给定数组按层次构造一个完全n叉树*/
    public Tree(Value[] arr, int maxChildrenNode) {
        this.length = arr.length;
        this.maxChildrenNode = maxChildrenNode;


        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node<>(i, arr[i], maxChildrenNode);
        }

        Queue<Node> nodeQueue = new Queue<>(arr.length);
        nodeQueue.enqueue(nodes[0]);

        Node currentNode;
        int currentIndex = 1;

        while (currentIndex < nodes.length) {

            currentNode = nodeQueue.dequeue();

            int currentIndexTemp = currentIndex;

            for (; currentIndex < nodes.length && (currentIndex - currentIndexTemp + 1 <= this.maxChildrenNode); currentIndex++) {
                currentNode.setChildreNodesByIndex(currentIndex - currentIndexTemp, nodes[currentIndex]);
                nodeQueue.enqueue(nodes[currentIndex]);
            }
        }
        this.root = nodes[0];

    }

    //按层遍历树
    public void printTree() {

        Queue<Node> nodeQueue = new Queue<>(this.length);

        nodeQueue.enqueue(this.root);

        Node currentNode=null;
        while ((currentNode = nodeQueue.dequeue()) != null) {
            System.out.print("  " + currentNode.getValue());

            for (int i = 0; i < this.maxChildrenNode; i++) {
                if (currentNode.getChildrenNodeByIndex(i) != null) {
                    nodeQueue.enqueue(currentNode.getChildrenNodeByIndex(i));
                }
            }
        }
    }


    // 返回二分搜索树的节点个数
    public int size() {
        return length;
    }

    // 返回树是否为空
    public boolean isEmpty() {
        return length == 0;
    }

//    public Node getRoot() {
//        return root;
//    }

    public static void main(String[] args) {

        String[] arr = {"123", "456", "789", "111", "123"};
        Tree<Integer, String> tree = new Tree<>(arr, 1);

        //System.out.println(tree.root.getChildrenNodeByIndex(0).getChildrenNodeByIndex(0).getValue());
        tree.printTree();
    }

}
