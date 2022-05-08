/*
* 작성일 : 2022-05-08
* 2022 ㅇㅇㅎ ㅌㅋㅋㅍ 5기
* */
function solution(scores) {
    //회원별 총점
    const studentTotal = scores.map(x => x[0] + x[1]);

    //문제별 총합
    const menjeTotal = scores.reduce((prev, curr) => [prev[0] + curr[0], prev[1] + curr[1]], [0, 0]);

    //더 어려운 문제 확인 (점수가 낮음)
    var hardIndex = 0;

    //더 어려운 문제 확인
    //두개 문제의 점수가 같지 않은 경우
    if (menjeTotal[0] != menjeTotal[1]) {
        for (let i = 0; i < menjeTotal.length; i++) {
            //점수가 더 낮은게 어려운 문제
            if (menjeTotal[i] < hardIndex) {
                hardIndex = i;
            }
        }
    } else {
        hardIndex = -1;
    }

    var result = [];
    for (const i in studentTotal) {
        var ob = {};
        ob.id = Number(i) + 1;
        ob.one = scores[i][0];
        ob.two = scores[i][1];
        ob.total = studentTotal[i];
        result.push(ob);
    }
    //정렬
    result.sort((a, b) => {
        //총점 높은 순
        if (a.total > b.total) return -1;
        if (a.total < b.total) return 1;

        //1번 점수로 비교해야하는 경우
        if (hardIndex == 0) {
            if (a.one > b.one) return -1;
            if (a.one < b.one) return 1;
        }
        //2번 점수로 비교해야하는 경우
        if (hardIndex == 1) {
            if (a.two > b.two) return -1;
            if (a.two < b.two) return 1;
        }
        if (a.id > b.id) return -1;
        if (a.id < b.id) return 1;
    })

    //정렬된 값의 index를 이용해 순서 가져오기
    var answer = [];
    for (let i = 0; i < result.length; i++) {
        for (let a = 0; a < result.length; a++) {
            if (i + 1 == result[a].id) {
                answer.push(a + 1);
            }
        }
    }
    return answer;
}