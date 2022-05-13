/*
* 작성일 : 2022-05-13
* */
function solution(absolutes, signs) {
    var answer = absolutes.reduce((a, cur, i) => {
        if (signs[i] === true) {
            return a + cur;
        } else {
            return a - cur
        }
    }, 0)
    return answer;
}