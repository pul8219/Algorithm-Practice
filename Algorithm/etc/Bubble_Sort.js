// 버블 정렬(Bubble Sort) 구현하기(JavaScript)

// 배열을 인자로 받아 정렬한 배열을 반환하는 함수를 작성하기

/**
 * 풀이1
 */

function bubbleSort(arr){
    for(i = arr.length - 1; i > 0; i--){
        for(j = 0; j < i; j++){
            if(arr[j] > arr[j+1]){
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    return arr;
}

let arr = [3,1,9,5];
const result = bubbleSort(arr);
console.log(result);

/**
 * 풀이2
 */

function bubbleSort2(arr){
    for (let i = 0; i < arr.length - 1; i++) {
        for(let j = 0; j < arr.length - i - 1; j++){
            if(arr[j+1] < arr[j]){
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        } 
    }
    return arr;
}


let arr2 = [3,1,9,5];
const result2 = bubbleSort(arr)
console.log(result2);


/**
 * JS 100제
 * 50번 문제 버블 정렬
 * 풀이2랑 같음
 */

function bubbleSort3(arr) {
    // console.log(arr);
    let result = arr.slice(); // 얕은 복사
    // console.log(result);
    for (let i = 0; i < result.length - 1; i++) {
      for (let j = 0; j < result.length - i - 1; j++) {
        if (result[j] > result[j + 1]) {
           let temp = result[j];
           result[j] = result[j+1];
           result[j+1] = temp;
        }
      }
    }
    return result;
  }
  
  const items = prompt('입력해주세요.').split(' ').map((n) => {
    return parseInt(n, 10);
  });
  
  console.log(bubbleSort3(items));

// const items = [4,3,2,1];
// bubbleSort3(items);