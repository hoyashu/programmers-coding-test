/*
* 작성일 : 2022-05-13
* https://hoyashu.tistory.com/264
* */
function solution(nums) {

    function isPrime(e) {
        //2은 무조건 소수이다.
        if (e === 2) {
            return true;
        }
        //소수인지 검증
        //소수인지를 확인하기 위해선 제곱근까지만 확인해도 된다.(꼭 필요한건 아니지만 시간복잡도에 이로움)
        for (let i = 2; i <= Math.floor(Math.sqrt(e)); i++) {
            if (e % i === 0) {
                //나누어지는게 있으니 소수가 아니다.
                return false;
            }
        }
        //위에서 return되는게 없는 경우 소수이다.
        return true;
    }

    var answer = 0;
    for (let i = 0; i < nums.length; i++) {
        for (let i2 = i + 1; i2 < nums.length; i2++) {
            for (let i3 = i2 + 1; i3 < nums.length; i3++) {
                let result = isPrime(nums[i] + nums[i2] + nums[i3]);
                if (result) {
                    answer++;
                }
            }
        }
    }
    return answer;
}