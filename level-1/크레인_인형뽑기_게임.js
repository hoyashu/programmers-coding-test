/*
* 작성일 : 2022-05-06
* https://hoyashu.tistory.com/manage/newpost/254
* */

function solution(board, moves) {

    //1. 세로로 값이 정렬되도록 정리
    var cols = [];
    for (let i = 0; i < board.length; i++) {
        cols[i] = [];
    }
    for(let t = 0 ; t < board.length; t++){
        for(const num in board[t]){
            cols[num].push(board[t][num])
        }
    }
    //console.log(cols)

    //2. 빈칸인 0값 제거
    let filtered = []
    for(const col of cols){
        filtered.push(col.filter((e) => e !== 0));
    }
    //console.log(filtered)

    //3. 크레인으로 잡아서 바구니로 이동하기
    let basket = [];
    for(const move of moves){
        //집게가 잡은 것
        const item = filtered[move-1][0];
        //바구니에 담기
        if(item){
            basket.push(item);
        }
        //바구니에 담긴 값 목록에서 제거 (첫번째 값 삭제)
        filtered[move-1].shift();
    }
    console.log(basket)

    //4. 바구니에서 중복되는거 터트리기
    var countPop = 0;//터진 횟수
    //터질 것이 없을때까지 반복되어야 함으로 do~while문 실행
    do{
        var isPop = false;
        for (let i = 0; i < basket.length; i++) {
            const nextIndex = i+1;
            const lastIndex = basket.length
            //마지막 값만 제외하고
            if(nextIndex != lastIndex){
                //다음 값이랑 같은 경우
                if(basket[i] == basket[nextIndex]){
                    //해당하는 값 두개 삭제
                    basket.splice(i,2);
                    isPop = true;
                    //터트린 숫자 추가, 한번 터질 때 2개가 터짐
                    countPop += 2;
                }
            }
        }
    }while(isPop);
    //한개라도 터진 게 있는 경우, do구문을 돌려서 한번 더 검사한다.
    //터진게 없는 경우 isPop은 false가 되면서 반복문 종료

    //5. 답 도출
    var answer = countPop;
    return answer;
}