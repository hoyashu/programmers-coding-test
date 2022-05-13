/*
* 작성일 : 2022-05-13
* https://hoyashu.tistory.com/265
* */

function solution(participant, completion) {
    //1,2
    const ob = {}
    participant.map((a) => ob[a] ? ob[a]++ : ob[a] = 1);
    //3
    completion.map((a) => ob[a]--);
    //4
    const yetIndex = Object.values(ob).indexOf(1);
    //5
    const answer = Object.keys(ob)[yetIndex];
    return answer;
}