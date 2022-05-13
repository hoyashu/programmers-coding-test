/*
* 작성일 : 2022-05-13
* */
function solution(numbers) {
    //순서 정렬
    numbers.sort((a, b) => {
        if (a > b) return 1;
        if (a < b) return -1;
    })

    //존재하지 않는 값 더하기
    let answer = 0;
    let k = 0;
    for (let i = 0; i < 10; i++) {
        if (i != numbers[k]) {
            answer += i;
        } else {
            k++;
        }
    }
    return answer;
}