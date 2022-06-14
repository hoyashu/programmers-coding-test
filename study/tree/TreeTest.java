package study.tree;

class Tree {
    Node root; //트리가 시작하는 루트 노트 / 최상위 노드를 기본으로 가르키고 있음

    //트리를 만드는 일을 시작해주는 함수
    //재귀함수를 시작하기 앞서 필요한 변수를 던져주는 역할은 한다. (처음 시작시킴)
    public void makeTree(int[] a) {
        //처음부터 마지막 index를 알려준다.
        this.root = makeTreeR(a, 0, a.length - 1);
        System.out.println(root);
    }

    //반쪼개고 중간 값을 찾는 작업
    public Node makeTreeR(int[] a, int start, int last) {
        //재귀함수를 종료 시킬 조건
        if (start > last) return null;

        int middle = (last + start) / 2;
        System.out.println(middle);
        //중간 지점에 저장된 값으로 node를 생성한다.
        //다른 클래스의 객세 생성에는 new를 통해야 한다.
        Node node = new Node(a[middle]);
        node.left = makeTreeR(a, start, middle - 1);
        node.right = makeTreeR(a, middle + 1, last);
        return node;
    }

    //n 검색을 할 시작 노드, find 찾을 인자
    public void searchBTree(Node n, int find) {
        //찾아야 하는 값이 현재 노드의 값보다 작은지를 비교하고
        if (find < n.data) {
            System.out.println("small data! " + n.data);
            //왼쪽 (더 작은 값)을 검색해야함
            searchBTree(n.left, find);
        } else if (find > n.data) {
            System.out.println("big data! " + n.data);
            //오른쪽 (더 큰 값)을 검색해야함
            searchBTree(n.right, find);
        } else { //같을 때
            System.out.println("same data! " + n.data);
        }
    }

    class Node {
        int data;
        Node left; //왼쪽 오른쪽 값을 저장할 노드 값
        Node right;

        //생성자에서 데이터를 받아 node data에 저장한다.
        Node(int data) {
            this.data = data;
        }
    }
}

public class TreeTest {
    public static void main(String[] args) {

        int[] a = new int[5];
        //int[] a = {5, 2, 3, 1, 4};
        int k = 1;
        for (int i = 0; i < a.length; i++) {
            a[i] = k;
            k++;
        }

        Tree tree = new Tree();
        tree.makeTree(a);

        //0~9까지의 숫자를 트리로 두었을때 5는 찾아보자
        tree.searchBTree(tree.root, 2);
        /*
        (4)
       /    \
      /      \
     /        \
   (1)        (7)
  /   \      /   \
(0)   (2)   (5)  (8)
        \      \    \
        (3)    (6)  (9)
   */
    }
}
