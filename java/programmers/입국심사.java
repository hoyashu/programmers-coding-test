package java.programmers;

/*
 * 작성일 : 2022-05-13
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 * [이분탐색 공부]
 * 각 소요시간에 회차를 곱해 가장 작은 숫자를 카운팅해서 하는줄 알았는데.. 아니였다 - 실패
 * */

public class 입국심사 {
    public static void main(String[] args) {
        int[] times = {7, 9, 20};
        solution(20, times);
    }

    public static long solution(int n, int[] times) {

        int gate = times.length;
        int[] ar = new int[gate];

        //[1,1,1]
        for (int i = 0; i < gate; i++) {
            ar[i] = 1;
            //System.out.print(ar[i]);
        }

        //[6,9,12,14]
        int[] ar2 = new int[n - gate];
        for (int i = 0; i < n - gate; i++) {
            if (i == 0) {
                ar2[i] = times[i] * (ar[i] + 1);
                ar[i]++;
            } else {
                //int it = times[i] * (ar[i] + 1);
                int min = 0;
                int minIndex = 0;
                for (int j = 0; j < gate - 1; j++) {
                    if (min == 0) {
                        min = (ar[j] + 1) * times[j];
                    } else {
                        if (min > (ar[j] + 1) * times[j]) {
                            min = (ar[j] + 1) * times[j];
                            minIndex = j;
                        }
                    }
                    //System.out.println("(ar[j] + 1) * times[j] = " + "min:" + min + ":" + (ar[j] + 1) + "*" + times[j] + "=" + (ar[j] + 1) * times[j]);
                    //System.out.println("(ar[j] + 1) + 1 * times[j + 1] = " + (ar[j + 1] + 1) + "*" + times[j + 1] + "=" + (ar[j + 1] + 1) * times[j + 1]);\

//                    if ((ar[j] + 1) * times[j] < (ar[j + 1] + 1) * times[j + 1]) {
//                        ar2[i] = (ar[j] + 1) * times[j];
//                        //System.out.println(ar2[i] + "작아요");
//                        ar[j]++;
//                        break;
//                    } else {
//                        ar2[i] = (ar[j + 1] + 1) * times[j + 1];
//                        // System.out.println(ar2[i] + "작아요");
//                        ar[j + 1]++;
//                        break;
                    // }

                    // }
                }
                ar2[i] = (ar[minIndex]) * times[minIndex];
                ar[minIndex]++;
            }
        }
        int max = 0;
        for (int i = 0; i < ar2.length; i++) {
            //System.out.println(ar2[i]);
            if (max < ar2[i]) {
                max = ar2[i];
            }
        }
        //System.out.println("답" + ar2.length + "!" + max);
        return max;
    }
}
