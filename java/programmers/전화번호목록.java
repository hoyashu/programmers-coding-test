package java.programmers;
/*
 * 작성일 : 2022-05-23
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * [hash 공부]
phone_book	return
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
 * */

import java.util.HashMap;

public class 전화번호목록 {

    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        boolean answer = false;
        //map셋팅
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

        //비교
        for (int i = 0; i < phone_book.length; i++) {
            //string은 .length()구나..
            //1. startWith() : 스트링형의 앞문장들을 비교하는 메서드 입니다.
            // : 비교하여 일치하면 true 일치하지 않으면 false를 반환한다.
            for (int k = 0; k < phone_book[i].length(); k++) {
                answer = map.containsKey(phone_book[i].substring(0, k));
            }
            map.put(phone_book[i], 1);
        }
        return answer;
    }
}
