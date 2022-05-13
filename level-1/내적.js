/*
* 작성일 : 2022-05-13
* https://hoyashu.tistory.com/263
* */
function solution(a, b) {
    var answer = a.reduce((prev, cur, i) =>
            prev += (cur * b[i])
        , 0);
    return answer;
}