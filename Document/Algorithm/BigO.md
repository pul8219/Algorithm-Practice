# 빅오 표기법(Big O Notation)

Big-O 표기법은 알고리즘의 효율성을 나타내는 지표이다. 시간복잡도(실행시간)와 공간복잡도(실행공간)가 있다. 입력되는 데이터의 개수(N)의 증가에 따라 알고리즘의 성능을 예측한다. 일반적으로는 최악의 시나리오를 상정했을 때 복잡도를 의미한다.

![](https://images.velog.io/images/pul8219/post/4e0eecda-c32c-431e-adf5-6e7ea5382f6d/image.png)

위 그림은 입력(input)되는 element양이 많아질수록 작업량(operation)이 얼마나 늘어나는지 나내는 빅오 복잡도 그래프이다.

- 알고리즘의 분석 목표는 f(n)을 계산하는 것으로 여기서 n은 **입력되는 데이터의 개수(N, n)** 이다.
- 영향력이 큰 항 이외에 영향력이 없는 항들을 무시한다. (아래서 자세히 설명할 것)
- _O(1) < O(log n) < O(n) < O(n log n) < O(n<sup>2</sup>) < O(2<sup>n</sup>)_

# 빅오 표기법 예제(JavaScript)

## O(1): Constant Time

- 입력되는 데이터가 증가해도 성능에 변화가 없는 경우(일정한 시간 패턴)

## O(n)

- 입력된 데이터에 비례해서 처리시간이 일정하게 증가하는 패턴

```js
// i가 0부터 n-1까지 n번의 연산이 수행되므로 O(n)이다.
function On(n) {
  for (let i = 0; i < n; i++) {
    console.log(i);
  }
}
```

## O(log n)

- 증가하는 속도가 줄어들며 증가하는 패턴
- ex) 이진 트리 탐색: 자식이 2개 이하로 있고 일정한 규칙으로 뻗어나간다.

```js
// Log 시간 복잡도
// n이 1,000,000 이어도 log2(1,000,000) = 19.9315... 이기 때문에 19개의 항목만을 출력한다.
function LogArithmetic(n) {
  for (let i = 2; i <= n; i = i * 2) {
    console.log(i);
  }
}

LogArithmetic(1000000);
```

## O(n<sup>2</sup>)

- 증가하는 속도가 급격히 증가하는 패턴(입력 데이터에 비례하게 처리시간이 제곱배로 증가한다.)
- ex) 버블 정렬

##

##

# 빅오 표기법 규칙

## 계수 법칙

> 상수 k>0인 경우 f(n)이 O(g(n))이면 kf(n)은 O(g(n))이다.

f(n)=n 인 경우와 f(n)=5n인 경우를 생각해보자

n이 무한대로 갈 때 계수는 크게 영향을 미치지 않으므로 무시한다.

두 경우 모두에서 시간복잡도는 O(n)으로 동일하다.

## 합의 법칙

> f(n)이 O(h(n))이고 g(n)이 O(p(n))이라면 f(n) + g(n)은 O(h(n)+p(n))이다.

f(n)=n인 반복문과 f(n)=5n인 반복문이 나란히 있는 예를 생각하면 쉽다. O(6n)=O(n)

## 곱의 법칙

> f(n)이 O(h(n))이고 g(n)이 O(p(n))이면 f(n)g(n)은 O(h(n)p(n))이다.

n번 도는 반복문 안에 5n번 도는 반복문이 있다고 생각해보자(이중 for문) 이 경우 f(n)=5n^2 이므로 O(n^2)이다.(계수법칙 적용으로 계수는 무시)

## 전이 법칙

> f(n)이 O(g(n))이고 g(n)이 O(h(n))이면 f(n)은 O(h(n))이다.

## 다항 법칙

> f(n)이 3(k)차 다항식이면 f(n)은 O(n³(k))이다.

# References

- [자바스크립트에서 Big O(시간 복잡도)란?](https://soldonii.tistory.com/56)
- [웹 개발자를 위한 자료구조와 알고리즘(#01.빅오 표기법)](https://callmedevmomo.medium.com/%EC%9B%B9-%EA%B0%9C%EB%B0%9C%EC%9E%90%EB%A5%BC-%EC%9C%84%ED%95%9C-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EC%99%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-01-%EB%B9%85%EC%98%A4-%ED%91%9C%EA%B8%B0%EB%B2%95-ff369f0efc1d)
- [빅오 표기법(Big O notation) & 자바스크립트](https://velog.io/@realryankim/TIL-%EB%B9%85%EC%98%A4-%ED%91%9C%EA%B8%B0%EB%B2%95Big-O-notation-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8)
- [JS Big-O 시간복잡도](https://velog.io/@760kry/Big-O)
- [빅오 표기법과 자바스크립트](https://aidanbae.github.io/code/algorithm/bigo/)
- [자료구조, 알고리즘 - 성능측정(빅오)](https://valuefactory.tistory.com/532)
- []()
