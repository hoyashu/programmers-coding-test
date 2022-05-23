package study.tree;

/*
 *      (1)
 *   (2)   (3)
 *(4)  (5)

 * Inorder (left, root, right): 4 2 5 1 3
 * Preorder (root, left, right): 1 2 4 5 3
 * Postorder (left, right, root): 4 5 2 3 1
 */
class TreeA {
    Node root;

    public TreeA() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    // left root right
    public void inorder(Node node) {
        //제귀함수 종료
        if (node != null) {
            //System.out.println("검사하려는 값" + node.data);

            //왼쪽
            //System.out.println(node.data + "의 왼쪽" + node.left);
            inorder(node.left);
            //자기 자신
            System.out.println(node.data);
            //오른쪽
            //System.out.println(node.data + "의 오른쪽" + node.right);
            inorder(node.right);
        }
    }

    // root left right
    public void preorder(Node node) {
        //제귀함수 종료
        if (node != null) {
            //자기 자신
            System.out.println(node.data);
            //왼쪽
            inorder(node.left);
            //오른쪽
            inorder(node.right);
        }
    }

    // left right root
    public void postorder(Node node) {
        //제귀함수 종료
        if (node != null) {
            //왼쪽
            inorder(node.left);
            //오른쪽
            inorder(node.right);
            //자기 자신
            System.out.println(node.data);
        }
    }

}

class Node {
    int data;
    Node left;
    Node right;
}

public class BinaryTreePrintValue {
    public static void main(String[] args) {
        TreeA t = new TreeA();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);

        t.setRoot(n1);
        t.inorder(t.getRoot());
    }
}
