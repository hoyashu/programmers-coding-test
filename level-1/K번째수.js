/*
* 작성일 : 2022-05-18
* https://hoyashu.tistory.com/270
* */

// 나의 코드
function solution(array, commands) {
    var answer = [];

    for (let i = 0; i < commands.length; i++) {
        const start = commands[i][0] - 1;
        const end = commands[i][1];
        const index = commands[i][2] - 1;
        let ar = [];
        let temp;

        if (start === end) {
            temp = array[start];
        } else {
            ar = array.slice(start, end);
            ar.sort((a, b) => {
                if (a > b) return 1;
                if (a < b) return -1;
            })
            temp = ar[index];
        }
        answer.push(temp);
    }
    return answer;
}

// 우수코드
function solution(array, commands) {
    return commands.map(command => {
        const [sPosition, ePosition, position] = command
        const newArray = array
            .filter((value, fIndex) => fIndex >= sPosition - 1 && fIndex <= ePosition - 1)
            .sort((a, b) => a - b)

        return newArray[position - 1]
    })
}
