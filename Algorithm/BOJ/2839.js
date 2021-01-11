// BOJ
// 2389번 문제: 설탕 배달



// 최대한 적은 봉지를 들고 가는 것이 목표
// 5킬로그램의 봉지가 많아야 봉지수가 적어짐(당연한 것)

// math.floor 써서 바꿔보기
//이거 제출 통과아아악
var n = Number(require('fs').readFileSync('/dev/stdin')); // BOJ 제출용 코드. 입력값을 받는 코드이며 입력값을 숫자로 받기 위해

let three = 0;
let five = Math.floor(n / 5);
n %= 5;

while(five >= 0){
    if(n % 3 == 0){
        three = Math.floor(n / 3);
        n %= 3;
        break;

    }
    five--;
    n += 5;
}

if (n==0){
    console.log(five + three);
}
else{
    console.log(-1);
}

//이건 통과 안됐음
var n = Number(require('fs').readFileSync('/dev/stdin'));
//let n = 18;
const big = 5;
const small = 3;

let bigMax = Math.floor(n / big);
while(bigMax>=0){
    let remain = n - bigMax * big;
    if(remain % small === 0){
        console.log(bigMax + n / small);
        return;
    }
    else{
        bigMax--;
    }


}
console.log(-1);