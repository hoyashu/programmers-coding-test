package study.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MakeTreeBasic {
    public static void main(String[] args) {

        Integer[] a = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};

        Node myNode1 = new Node(a.length);

        Tree myTree = new Tree(myNode1);
        for (int i = 0; i < a.length; i++) {
            myTree.insertData(a[i]);
        }
        myTree.printTree();

    }

    static class Tree {

        private Node root;
        private int maxLevel = 0;

        Tree(Node root) {
            this.root = root;
            this.root.setLevel(0);
        }

        int getMaxLevel() {
            return maxLevel;
        }

        void setMaxLevel(int i) {
            if (maxLevel < i) {
                maxLevel = i;
            }
        }

        Node getRoot() {
            return root;
        }

        void printTree() {

            Queue<Node> Q = new LinkedList<Node>();
            Q.offer(root);

            int nowLevel = 0;
            int nowCount = 0;

            while (!Q.isEmpty()) {

                Node n = Q.peek();

                if (n.getLeft() != null) {
                    Q.offer(n.getLeft());
                }
                if (n.getRight() != null) {
                    Q.offer(n.getRight());
                }

                Node m = Q.poll();
                if (nowLevel < m.getLevel()) {
                    nowCount = printX(nowCount, Math.pow(2, maxLevel + 1) - 1);
                    nowLevel = nowLevel + 1;
                    nowCount = 0;
                    System.out.println();
                }
                nowCount = printX(nowCount, Math.pow(2, maxLevel - nowLevel) * (2 * m.getIntCount() + 1) - 1);
                System.out.print(m.getData());
                nowCount = nowCount + 1;
            }
            nowCount = printX(nowCount, Math.pow(2, maxLevel + 1) - 1);

        }

        int printX(int start, double end) {
            while (start < end) {
                System.out.print(".");
                start = start + 1;
            }
            return start;
        }

        void insertNode(Node node) {

            insertNode(root, node);

        }

        private Node insertNode(Node root, Node node) {

            if (root == null) {
                root = node;
                return root;
            }

            if (node.getData() == root.getData()) {
                System.out.println("You put the same Data");
            } else if (node.getData() < root.getData()) {

                root.setLeft(insertNode(root.getLeft(), node));
                root.getLeft().setLevel(root.getLevel() + 1);
                root.getLeft().setCount(root.getStringCount() + 0);
                this.setMaxLevel(root.getLevel() + 1);

            } else if (node.getData() > root.getData()) {

                root.setRight(insertNode(root.getRight(), node));
                root.getRight().setLevel(root.getLevel() + 1);
                root.getRight().setCount(root.getStringCount() + 1);
                this.setMaxLevel(root.getLevel() + 1);

            }

            return root;
        }

        void insertData(Integer i) {

            Node dataNode = new Node(i);
            insertNode(dataNode);

        }

    }


    static class Node {

        private Node Left;
        private Node Right;
        private int level;
        private String count;

        private Integer data;

        Node(Integer i) {
            Left = null;
            Right = null;
            data = i;
            level = -1;
            count = "0";
        }

        String getStringCount() {
            return count;
        }

        int getIntCount() {
            return Integer.parseInt(count, 2);
        }

        void setCount(String s) {
            count = s;
        }

        Integer getData() {
            return data;
        }

        void setData(Integer i) {
            data = i;
        }

        int getLevel() {
            return level;
        }

        void setLevel(Integer i) {
            if (level < i) {
                level = i;
            }
        }

        Node getLeft() {
            return Left;
        }

        void setLeft(Node node) {
            Left = node;
        }

        Node getRight() {
            return Right;
        }

        void setRight(Node node) {
            Right = node;
        }

    }

}
