/*
* 작성일 : 2022-05-06
* https://hoyashu.tistory.com/256
* */
function solution(numbers, hand) {
    //왼손으로 쳐야하는 숫자
    const left = [1, 4, 7]
    //오른손으로 쳐야하는 숫자
    const right = [3, 6, 9]
    //오른손잡이 ? 왼손잡이 => R ? L로 변환
    const handCustom = hand.substring(0,1).toUpperCase();

    //현재 손의 위치를 선언한다.
    var leftLocation = "*";
    var rightLocation = "#";

    //눌러야 하는 숫자와의 거리를 확인하는 함수를 생성한다.
    function findDistance(handNumber, nextNumber){
        //각 키패드를 (y,x)값으로 설정한다.
        let keypad = {1:[0,0], 2:[1,0],3:[2,0],
            4:[0,1], 5:[1,1], 6:[2,1],
            7:[0,2], 8:[1,2], 9:[2,2],
            "*":[0,3], 0:[1,3], "#":[2,3]
        }
        //누르고 있는 번호
        let [x1, y1] = keypad[handNumber];
        //누를 번호
        let [x2, y2] = keypad[nextNumber];
        //거리 구하는 법 : 거리를 구한 값을 abs로 절대값으로 만든다음 x,y거리를 합친다.
        return Math.abs(x1 - x2) +  Math.abs(y1 - y2);
    }

    //reduce함수를 이용해서 변수 선언없이 result에 쌓아준다.
    var answer = numbers.reduce((result, number, index)=>{
        //만약 누를 숫자가 왼손으로 눌러야 하는 경우
        if(left.includes(number) ){
            //결과에 L를 추가한다.
            result.push("L");
            //왼손이 해당 숫자를 눌렀다고 현재 손의 위치를 업데이트 해준다.
            leftLocation = number;
        }else if(right.includes(number)){ //만약 누를 숫자가 오른손으로 눌러야 하는 경우
            result.push("R");
            rightLocation = number;
        }else{ //2,5,8,0의 숫자를 눌러야 할 경우
            //현재 왼손이 누르고 있는 것과 눌러야 하는 것의 거리
            var closeLeft = findDistance(leftLocation, number);

            //현재 오른손이 누르고 있는 것과 눌러야 하는 것의 거리
            var closeRight = findDistance(rightLocation, number);

            //만약에 거리가 같으면 자주 사용하는 손잡이를 사용한다.
            if (closeLeft == closeRight){
                result.push(handCustom);
                if(handCustom == "L"){
                    leftLocation = number;
                }else{
                    rightLocation = number;
                }
            }else if(closeLeft < closeRight){
                result.push("L");
                leftLocation = number;
            }else{
                result.push("R");
                rightLocation = number;
            }
        }
        return result;
    } ,[]);

    //join매서드로 배열을 문자열로 바꾼다.
    answer = answer.join("");
    return answer;
}