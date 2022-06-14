package java.programmers;

/*
 * 작성일 : 2022-05-13
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 찍는 방법을 만들 필요없이 쓰면 되는데, 배열을 따로 만들어서 작성 시간이 많이 소요되었음.
 * 그리고 가장 많이 푼 사람을 담으면 되는 것 뿐인데, 그게 막혀서 오래걸림 - 실패
 * */

import java.util.LinkedList;

public class 모의고사 {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        solution(ar);
    }

    public static int[] solution(int[] answers) {

        //int[] one = new int[answers.length];
        int one = 0;
        int two = 0;
        int three = 0;
        int[] ar = {3, 1, 2, 4, 5};
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 0; i < answers.length; i++) {
            //System.out.println(a);
            if (answers[i] == a) {
                one++;
            }
            //one[i] = a;
            a++;
            if (a == 6) {
                a = 1;
            }


            if ((i + 1) % 2 == 0) {
                if (b == 2) {
                    b++;
                }
                //System.out.println(i + 1 + "번째");
                //ystem.out.println(b);

                if (answers[i] == b) {
                    ///System.out.println(answers[i] + "같아요" + b);
                    two++;
                }
                b++;
            } else {
                //System.out.println(i + 1 + "번째");
                //System.out.println(2);

                if (answers[i] == 2) {
                    //System.out.println(answers[i] + "같아요" + 2);
                    two++;
                }
//                if (i + 1 == 1) {
//                    System.out.println(b);
//                }
            }
            if (b == 6) {
                b = 1;
            }


            //짝수
            int k = i;
            boolean flog = false;
            if (i > 4) {
                k = i - 5;
                flog = true;
            }
            System.out.println("하아" + k);
            if ((i + 1) % 2 == 0) {
                //c = ar[i];
                //System.out.println(i + "작수");
                //System.out.println(c);
                if (answers[i] == c) {
                    three++;
                }
            } else {
                if (!flog && k == 0) {
                    c = ar[k];
                } else {
                    if (k == 0) {
                        c = ar[k];
                    } else {
                        c = ar[k - 1];
                    }

                }
                if (answers[i] == c) {
                    three++;
                }
                // System.out.println(c);
            }
        }
        System.out.println("one:" + one);
        System.out.println("two:" + two);
        System.out.println("three:" + three);

        //5,0,5
        int[] answer = {one, two, three};

        //5
        int max = 0;
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
            if (max < answer[i]) {
                max = answer[i];
            }
        }

        LinkedList list = new LinkedList<>();
        int[] answer1 = new int[3];
        for (int i = 0; i < answer.length; i++) {
            if (max == answer[i]) {
                answer1[i] = answer[i];
                //5,,5
            }
        }

        // 문제점 : 3번 답변 방식이 틀림, 최고점을 확인하고 해당 점을 받은 사람을 배열에 담아야 하는데, 못함(문제를 정확히 읽고 할 것)
        return answer1;
    }
}
