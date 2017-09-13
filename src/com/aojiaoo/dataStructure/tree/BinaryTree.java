package com.aojiaoo.dataStructure.tree;

public class BinaryTree<Key, Value> extends Tree<Key, Value> {

    public BinaryTree() {
        super(2);
    }

    public BinaryTree(Value[] arr) {
        super(arr, 2);
    }


    //进行遍历
    public void traversal(String type) {

        switch (type) {

            case "preorder"://前序
                this.doPreorderTraversal(this.root);
                break;
            case "inorder"://中序
                this.doInorderTraversal(this.root);
                break;
            case "postorder"://后序
                this.doInorderTraversal(this.root);
                break;

            default://前序
                this.doPreorderTraversal(this.root);
                break;
        }
        System.out.println();
    }


    //进行前序遍历
    private void doPreorderTraversal(Node node) {

        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + "   ");
        doPreorderTraversal(this.getLeftchild(node));
        doPreorderTraversal(this.getRightchild(node));
    }

    //进行中序遍历
    private void doInorderTraversal(Node node) {

        if (node == null) {
            return;
        }
        doInorderTraversal(this.getLeftchild(node));
        System.out.print(node.getValue() + "   ");
        doPreorderTraversal(this.getRightchild(node));
    }

    //后序遍历
    private void doPostorderTraversal(Node node) {

        if (node == null) {
            return;
        }
        doPostorderTraversal(this.getLeftchild(node));
        doPreorderTraversal(this.getRightchild(node));

        System.out.print(node.getValue() + "   ");
    }

    protected Node<Key,Value> getLeftchild(Node node) {
        return node.getChildrenNodeByIndex(0);
    }

    protected Node<Key,Value> getRightchild(Node node) {
        return node.getChildrenNodeByIndex(1);

    }



    public static void main(String[] args) {

        String[] arr = {"123", "456", "789", "111", "999"};
        BinaryTree<Integer, String> tree = new BinaryTree<>(arr);
        tree.traversal("af");
    }
}
