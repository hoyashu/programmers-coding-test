package java.leetcode;

/*
 * 작성일 : 2022-05-30
 * https://leetcode.com/problems/longest-absolute-file-path/
 * [backTracking 공부]
 * tree구조를 만들어서 해야한다고 생각함 - 시도 중 실패
 * */

import java.util.LinkedList;

public class leetcode388 {

    Node2 root;

    public static void main(String[] args) {
        LinkedList<String> b = new LinkedList<String>();
        String input = "dir\n\tsubdir1\n\t\tfile.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tfile.ext";
        String[] a = input.split("\n");
        int max = 0;

        LinkedList<String> result = back(a, 0, b, 0, max);
        System.out.println(result);
    }

    public static int lengthLongestPath(String input) {
        return 0;
    }

    public static LinkedList<String> back(String[] a, int idx, LinkedList<String> b, int prevLevel, int max) {
        if (idx == a.length) return null;

        //dir
        int thisLevel = a[idx].lastIndexOf("\t") + 2;
        System.out.println(prevLevel + ":" + thisLevel);

        //최대 레벨인 경우
        if (prevLevel + 1 != thisLevel) {
            System.out.println("잎파리에요");
            return null;
        }
        //1

        String path = null;
        if (thisLevel != 0) {
            path = a[idx].substring(a[idx].lastIndexOf("\t") + 1);
            System.out.println(path);
            System.out.println(thisLevel);
        } else {
            path = a[idx];
            System.out.println(path);
            System.out.println(thisLevel);
        }

        int thisMax = max + path.length() + (thisLevel - 1);
        //이걸 더한 값이 더 크면
        if (thisMax > max) {
            b.add(path);
            max = thisMax;
        } else {
            //이전 max값이 더 크면 넘길 필요 없이 그냥 나감
        }
        System.out.println(max);

        System.out.println("첫번째 시작");
        back(a, idx + 1, b, thisLevel, max);
        //System.out.println("두번째 시작" + idx);
        //back(a, idx + 2, b, thisLevel, max, idx);


        return b;

        //int maxLength = 0;


//        for (int i = 0; i < a.length; i++) {
//            //level : 0 - 1단계, 1 - 2단계
//            int level = a[i].lastIndexOf("\t");
//
//            String path = null;
//            if (level != -1) {
//                path = a[i].substring(a[i].lastIndexOf("\t") + 1);
//                System.out.println(path);
//                System.out.println(level);
//            }
//
//
//        }
    }

    public Node2 makeNode(Node2 left, int data, Node2 right) {
        Node2 node = new Node2();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    //제귀함수 (중간 찾아서 반쪼개서 트리만들어서 최종값node돌려주기)
    public Node2 makeTreeRGo(int[] a, int start, int last) {
        //제귀함수 중단
        if (start > last) return null;

        //중간 찾기
        //int mid = (int) Math.floor((start + last) / 2);
        int mid = (start + last) / 2;

        Node2 node = new Node2(a[mid]);
        node.left = makeTreeRGo(a, start, mid - 1);
        node.right = makeTreeRGo(a, mid + 1, last);

        return node;
    }

    class Node2 {
        int data;
        Node2 left;
        Node2 right;

        Node2() {
        }

        Node2(int data) {
            this.data = data;
        }
    }
}
