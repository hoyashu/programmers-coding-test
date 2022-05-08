/*
* 작성일 : 2022-05-08
* 2022 ㅇㅇㅎ ㅌㅋㅋㅍ 5기
* */
function solution(salaries, days) {
    var answer = salaries.reduce((previousValue, currentValue) => {
        let day = currentValue[0];
        let cash = currentValue[1];

        if (day > days) { //7일부터 지급받는데 6일째 중단시킴
            return previousValue + cash;
        } else {
            if (days % day == 0) { //가동 중지 전에 일을 한 경우
                return previousValue + cash * (days / day);
            } else {
                return previousValue + cash * (Math.ceil(days / day));
            }
        }
    }, 0)
    return answer;
}