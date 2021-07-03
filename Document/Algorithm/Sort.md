# 정렬(Sort)

- [버블 정렬(Bubble Sort)](BubbleSort.md)
- [선택 정렬(Selection Sort)](.md)
- [삽입 정렬(Insertion Sort)](.md)
- [퀵 정렬(Quick Sort)](.md)
- [병합 정렬(Merge Sort)]()
- [힙 정렬(Heap Sort)]()
- [기수 정렬(Radix Sort)]()
- [계수 정렬(Count Sort)]()

# 버블 정렬(Bubble Sort)

두 개의 인접한 자료 값을 비교하면서 위치를 교환하는 방식으로 정렬하는 방법(거품처럼 옆으로 퍼지며 비교해서 버블 정렬이라고 함)

- 직관적이고 간단하다
- O(n^2)로 비효율적이다.

## 그림으로 보는 버블 정렬

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdqPsHU%2FbtqEsDZTw3U%2FHPZkMVPzkSpOVtm7G0jrdK%2Fimg.gif)

## 의사 코드

```
Repeat n–1 times

    For i from 0 to n–2

        If i'th and i+1'th elements out of order

            Swap them

```

## 시간 복잡도

- 최악의 경우: O(n^2)

```
(n-1) * (n-1) = n*2 - 2n + 1
-> O(n^2)
```

- 최선의 경우: Ω(n^2) 정렬 문제에서 가장 최선의 경우는 이미 정렬된 데이터가 들어올 때일 것이다. 하지만 이미 정렬된 데이터가 들어와도 버블 정렬은 맹목적으로 기재된 만큼 반복한다.

## 버블 정렬 개선

교환이 일어나지 않을 때 알고리즘을 일찍 종료하게 하면 버블 정렬을 개선할 수 있다. 이미 정렬된 `[1,2,3,4,5,6,7,8]`을 생각해보자. 1,2 바꾸지 않고 2,3 바꾸지 않고, ...(반복) 총 n-1번 비교하지만 swap이 일어나지 않는다. 따라서 이러한 최선의 경우 `n-1번`, 즉 O(n)이 될 수 있다.

```
Repeat until no swaps

    For i from 0 to n–2

        If i'th and i+1'th elements out of order

            Swap them

```

# 선택 정렬(Selection Sort)

정렬을 위한 알고리즘 중 선택정렬을 배열 안의 자료 중 가장 작은 수(혹은 가장 큰 수)를 찾아 첫 번째 위치(혹은 가장 마지막 위치)의 수와 교환해주는 방식의 정렬입니다.

- 교환 횟수는 최소화하나, 비교 횟수는 증가한다. (버블 정렬과 비교해보기)

## 그림으로 보는 선택 정렬

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbUlaXt%2FbtqErLxD7CT%2FmdbMjqJDP3wigM8qJQfqek%2Fimg.gif)

## 의사 코드

```
For i from 0 to n–1

    Find smallest item between i'th item and last item

    Swap smallest item with i'th item
```

## 시간 복잡도

- 최악의 경우: O(n^2)

```
// n번 비교하고, n-1번 비교하고, ...
n + (n-1) + (n-2) + ... + 1
위 식은 수학적 공식에 따르면 n(n+1)/2 = (n^2+n)/2
=> O(n^2)
```

- 최선의 경우: Ω(n^2)

(이미 정렬되어있는 최선의 경우에도 모두 비교하기 때문에)

# References

- [JS Algorithm, Data Structure](https://velog.io/@yujo/JS%EB%B2%84%EB%B8%94-%EC%A0%95%EB%A0%ACBubble-Sort)
- [거품정렬, 선택정렬, 삽입정렬](https://gaemi606.tistory.com/entry/%EA%B1%B0%ED%92%88%EC%A0%95%EB%A0%ACBubble-sort-%EC%84%A0%ED%83%9D%EC%A0%95%EB%A0%ACSelection-sort)
- [하버드 CS50]()
