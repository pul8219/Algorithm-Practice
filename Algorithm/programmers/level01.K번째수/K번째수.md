# 프로그래머스 level01.K번째수

## 코드

## 풀이과정

### 문제 설명

commands 배열은 [i, j, k] 형태의 원소를 가지는 2차원 배열이다. 1차원 배열 array에 대해 commands의 모든 각각의 원소에 대해 다음 연산을 적용한다.

1. array의 i번째부터 j번째까지 자른다.
2. 1에서 나온 배열을 정렬한다.
3. 2에서 나온 (정렬된) 배열에서 k번째 숫자를 찾는다.

commands의 모든 원소마다 계산된 3에서 나온 숫자를 배열에 담아 return하도록 코드를 작성하는 문제이다.

### 풀이 아이디어

commands 배열을 순회하도록 반복문을 사용하고 slice 함수를 이용해 1(array를 자르는 과정)을 수행한다. 이를 slicing이라는 미리 정의된 변수에 담은 후 정렬하고 k번째 수를 찾아 answer 배열에 넣는다. (slicing 배열도 사용 후엔 초기화해서 반복마다 다시 사용한다.) 이 과정을 commands 배열의 길이만큼 반복한다.

초기 코드는 제출 때는 통과를 못했는데 배열을 정렬하는 코드를 `slicing.sort()` 이렇게 작성했기 때문이다. JavaScript에서 `sort()`를 사용해 숫자를 오름차순으로 정렬하고 싶을 때는 `sort(a,b => {return a-b;})`처럼 작성해야한다. 안그럼 아스키 문자 순서로 정렬되어 원하는 결과를 얻을 수 없다.([100, 1, 4, 13,10] 을 sort()로 정렬하면 [1, 10, 100, 13,4] 이런 순으로 정렬된다. 우리가 원하는 것은 숫자의 크기순으로 정렬되는 것!)

### 다른 풀이

- junilhwang.js

```js
// https://programmers.co.kr/learn/courses/30/lessons/42748?language=javascript
function solution(array, commands) {
  return commands.map(
    ([i, j, k]) => array.slice(i - 1, j).sort((a, b) => a - b)[k - 1]
  );
}

console.log(
  solution(
    [1, 5, 2, 6, 3, 7, 4],
    [
      [2, 5, 3],
      [4, 4, 1],
      [1, 7, 3],
    ]
  ),
  [5, 6, 3]
);
//console.log(solution([1,1,1,1,3,2,2,2,2], [[]]),[])
```

# References

프로그래머스/javascript K번째 수

- https://velog.io/@fastpace04/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4JavaScript-K%EB%B2%88%EC%A7%B8-%EC%88%98

`sort((a,b) => {return a-b})` 관련 궁금증

- https://fluorite94.tistory.com/220
- https://stackoverflow.com/questions/39202616/difference-between-sort-sortfunctiona-breturn-a-b-and-sortfunctiona
- https://forum.freecodecamp.org/t/arr-sort-a-b-a-b-explanation/167677/2
- https://dudmy.net/javascript/2015/11/16/javascript-sort/
- https://opentutorials.org/course/50/109

```js
// let arr = [1, 111, 13, 4, 222, 10];
// arr.sort();
// console.log(arr); //[1, 10, 111, 13, 222, 4]

// let arr = [1, 100, 4, 13, 10];
// arr.sort();
// console.log(arr); // [1,10,100,13,4]
```

for, forEach, map

- https://m.blog.naver.com/wideeyed/221877912230
