package study.tree;

import java.util.List;

class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(Integer val) {
        this.val = val;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}


class TreeB {
    TreeNode root;
    int left = 0;
    int right = 0;
    int leftSum = 0;
    int rightSum = 0;

    //처음
    public void makeTree(Integer[] a) {
        this.root = makeTreeB(a, 0, 1, 1);
    }

    public TreeNode makeTreeB(Integer[] a, int start, int end, int isleft) {
        //재귀함수 종료
        //int end = a.length-1;

        if (start < 0 || start > a.length - 1) return null;

        //int mid = (start + end) / 2;
        System.out.println(a.length + ":" + start);


        //for(int i = start; i<a.length; i++){
        Integer cusor = null;
        if (isleft == 0) {
            cusor = a[end];
        } else {
            cusor = a[start];
        }

        if (cusor == null) return null;
        TreeNode tree = new TreeNode(cusor);
        tree.left = makeTreeB(a, start * 2 + 1, start * 2 + 2, 1);
        tree.right = makeTreeB(a, start * 2 + 1, start * 2 + 2, 0);
        //}


        //재귀함수 시작

        return tree;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //left = root.val + root.left.val;
        //right = root.val + root.right.val;

        System.out.println("Dd");
        return null;


    }
}

public class PathSumII {
    public static void main(String[] args) {

        Integer[] a = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};

        //TreeNode treeNode = new TreeNode();

        TreeB treeB = new TreeB();
        treeB.makeTree(a);
        treeB.pathSum(treeB.root, 22);
    }
}
