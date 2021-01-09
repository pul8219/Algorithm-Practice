// BOJ
// 2389번 문제: 설탕 배달

// 최대한 적은 봉지를 들고 가는 것이 목표
// 5킬로그램의 봉지가 많아야 봉지수가 적어짐(당연한 것)

let N = 18;
let result = 0;

console.log(N);
if(N % 5 === 0) return N/5;

result += N/5;
N %= 5;
result += N/3;
N %= 3;

if (!N) return -1;
console.log(result);
return result;

