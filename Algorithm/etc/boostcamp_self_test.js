// 부스트캠프 자가진단 6번 문제
// 문제: https://blog.naver.com/boostcamp_official/221978031932
// 해설: https://blog.naver.com/boostcamp_official/222388429782

// 내 풀이
const solution = (arr) => {
  const map = new Map(); // 순서보장되는 Map 자료구조에 저장
  arr.forEach(element => {
    let value = !map.get(element) ? 1 : map.get(element) + 1;
    map.set(element, value);
  });

  let result = [];
  for(let [key,value] of map){
      if(value === 1) map.delete(key);
      else result.push(value);
  }

  if(!map.size) result.push(-1);
  console.log(result);
    return result;
    
};


// solution(arr);

// 해설에 있는 풀이 1(Set 사용)
function countOf(arr, value){
    var count = 0;
    arr.forEach(element => {
        if(element == value) count++;
    });
    return count;
}

function solution2(arr){
    var answer = [];
    var ser = new Set([]);
    arr.forEach(element => {
        if(set.has(element)) return;
        set.add(element);
        count = countOf(arr, element);
        if(count > 1) answer.push(count);
    });
    if(answer.length == 0) answer.push(-1);
    return answer;
}


// 해설에 있는 풀이 2(Map 사용)
const solution3 = (arr) => {
    const answer = [];
    const map = new Map();
    arr.forEach(element => {
        if(map.has(element)){
            map.set(element, map.get(element) + 1);
        }
        else{
            map.set(element, 1);
        }
    });
    map.forEach((value) => {
        if(value > 1) answer.push(value);
    });
    if(answer.length === 0) answer.push(-1);
    console.log(answer);
    return answer;
    
};

const arr = [3,3,2,2,2,4,4,5,7,7,7];
solution3(arr);