package java.leetcode;

/*
 * 작성일 : 2022-05-30
 * https://leetcode.com/problems/longest-absolute-file-path/
 * [backTracking 공부]
 * stack을 사용해서 함 - 성공
 * */


import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode388_2 {

    //인텔리 제이 테스트 부분
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String[] a = input.split("\n");
        int max = 0;

        Integer result = back(a);
        System.out.println(result);
    }

    //리트코드 테스트 부분
    public static int lengthLongestPath(String input) {

        //String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String[] a = input.split("\n");
        int max = 0;

        Integer result = back(a);
        System.out.println(result);
        return result;
    }

    public static Integer back(String[] a) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int max = 0;
        //LinkedList<String> temp = new LinkedList<String>();
        for (int i = 0; i < a.length; i++) {
            int thisLevel = a[i].lastIndexOf("\t") + 2;
            String path = null;
            if (thisLevel != 0) {
                path = a[i].substring(a[i].lastIndexOf("\t") + 1);
            } else {
                path = a[i];
            }

            //같은 레벨의 것이 몇개인지 모르니까 while
            System.out.println("========" + path);
            System.out.println("thisLevel" + thisLevel);
            System.out.println("stack.size()" + stack.size());
            while (thisLevel < stack.size()) {
                //가자 위에 있는거 뺀다.
                System.out.println("빼자");
                stack.pop();
            }
            //System.out.println(path + "~" + thisLevel + "ㅋㅋ" + stack.size());
            //쌓여있던 글자들 개수 + 지금 커서의 글자 개수 + / 개수
            System.out.println(stack.peek() + "ll" + path.length());
            int sum = stack.peek() + path.length();
            System.out.println("sum~" + sum);

            //레벨 번째로 지금 것을 올려준다.
            stack.push(sum);

            if (a[i].contains(".")) {
                System.out.println(path + "~" + max + "!" + sum);
                max = Math.max(max, sum + thisLevel - 1);
            }

        }
        return max;
    }
}
