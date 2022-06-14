package java.programmers;

/*
 * 작성일 : 2022-05-13
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 3번의 답변 방식을 배열로 단순하게 변경함
 * array의 크기를 유동적으로 잡아야해서, ArrayList사용 - 성공
 * */

import java.util.ArrayList;
import java.util.List;

public class 모의고사_2 {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        solution(ar);
    }

    public static int[] solution(int[] answers) {
        int one = 0;
        int two = 0;
        int three = 0;
        int[] ar = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a) {
                one++;
            }
            a++;
            if (a == 6) {
                a = 1;
            }
            if ((i + 1) % 2 == 0) {
                if (b == 2) {
                    b++;
                }
                if (answers[i] == b) {
                    two++;
                }
                b++;
            } else {
                if (answers[i] == 2) {
                    two++;
                }
            }
            if (b == 6) {
                b = 1;
            }

            if (answers[i] == ar[i % ar.length]) {
                three++;
            }
        }

        //5,0,5
        int[] result = {one, two, three};

        //5
        int max = 0;
        for (int i = 0; i < result.length; i++) {

            if (max < result[i]) {
                max = result[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (max == result[i]) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
