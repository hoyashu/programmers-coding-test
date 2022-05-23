package study.tree;

import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
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
        this.root = makeTreeB(a, 0, a.length - 1);
    }

    public TreeNode makeTreeB(Integer[] a, int start, int end) {
        //제귀함수 종료
        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode tree = new TreeNode(a[mid]);
        //제귀함수 시작
        tree.left = makeTreeB(a, start, mid - 1);
        tree.right = makeTreeB(a, mid + 1, end);
        return tree;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        left = root.val + root.left.val;
        right = root.val + root.right.val;


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
