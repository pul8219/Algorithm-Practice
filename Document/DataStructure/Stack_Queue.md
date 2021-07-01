# 스택(Stack), 큐(Queue)

자바스크립트의 배열에서 제공하는 메소드를 이용하면 스택과 큐를 쉽게 구현할 수 있다.

> **ADT(Abstract Data Types)**
>
> 추상자료형이라고도 하며, 데이터를 구체적으로 구현하는 방식은 생략하고 데이터의 추상적인 형태와 그 데이터를 다루는 방법만을 정해놓은 것을 의미한다.
>
> ex) 스택, 큐, 트리 모두 ADT이다. 예를 들어 스택은 데이터를 담을 배열과 top, push, pop과 같은 개념으로 이루어진 자료구조이다.

# 스택(Stack)

![](https://image.librewiki.net/thumb/2/29/Data_stack.svg/300px-Data_stack.svg.png)

- LIFO(후입선출, Last In first Out): 먼저 들어간 데이터가 나중에 나오는 / 나중에 들어간 데이터가 먼저 나오는 자료구조
- 선형(linear) 자료구조
- 함수 실행 컨텍스트가 쌓이는 `Call stack`이나 브라우저 방문 기록이 쌓이는 `History Stack`이 대표적인 예

# 스택의 기능

## 메소드

- 데이터를 집어넣는 **push**
- 데이터를 꺼내는 **pop**
- 스택의 길이 **length**
- 다음에 나올 데이터를 확인하는 **peek**
- 현재 스택이 비어있는지 확인하는 **isEmpty**
- 현재 스택을 초기화하는 **clear**

## 속성

- **top**: 가장 나중에 들어간 데이터의 위치(index)를 가리키는 변수. 초기값을 `-1`이나 `0`으로 두고 구현할 수 있다.

# 스택 구현 방법

- 배열로 구현
- 연결리스트로 구현

# 스택 구현 in JavaScript

## 배열로 스택 구현

JavaScript에서 제공하는 `push()`, `pop()`을 사용하지 않고 배열을 이용해 스택을 구현해보자.-

### pseudo code

```
스택 생성{
    top 초기화
}

스택.push(data){
    top++;
    data를 top 위치에 삽입
}

스택.pop(){
    if 스택이 비어있다면
        강제 종료
    else
        top 위치에 있는 데이터 return;
        데이터 삭제
        top--;

}
```

### 전체 코드

```js
class Stack {
  constructor() {
    this.top = -1;
    this.arr = [];
  }
  push(data) {
    this.top++;
    this.arr[this.top] = data;
  }
  pop() {
    if (this.top < 0) {
      console.log('Error: Stack is empty.');
      return -1;
    }

    let popData = this.arr[this.top];
    this.arr.splice(this.top, 1);
    this.top--;
    return popData;
  }
  length() {
    return this.arr.length;
  }
  peek() {
    return this.arr[this.top];
  }
  isEmpty() {
    return this.arr.length === 0;
  }
  clear() {
    this.arr = [];
    this.top = -1;
  }
  print() {
    console.log(this.arr);
  }
}

const stack = new Stack();

stack.push(1);
stack.push(2);
stack.push(3);
console.log(stack.length()); //3
console.log(stack.peek()); // 3
stack.print(); // [1,2,3]
stack.pop();
stack.print(); // [1,2]
console.log(stack.isEmpty()); // false
stack.pop();
stack.pop();
stack.print(); // []
console.log(stack.isEmpty()); // true
stack.push(4);
stack.push(5);
stack.push(6);
stack.print(); // [4,5,6]
stack.clear();
stack.print(); // []
console.log(stack.length()); // 0
stack.pop(); // Error: Stack is empty.
```

## 연결리스트로 스택 구현하기

# 큐(Queue)

![](https://image.librewiki.net/thumb/5/52/Data_Queue.svg/300px-Data_Queue.svg.png)

- FIFO(선입선출, First In First Out): 먼저 들어간 데이터가 먼저 나오는 자료구조
- 선형(linear) 자료구조
- 자바스크립트 엔진에서 비동기 함수 실행시 콜백들이 대기열로 들어오는 `Task queue`가 대표적인 예

# 큐의 기능

## 메소드

- 데이터를 넣는 **enqueue**
- 데이터를 꺼내는 **dequeue**
- 큐의 데이터의 길이 **length**
- 다음에 나올 데이터를 확인하는 **peek**
- 현재 큐가 비어있는지 확인하는 **isEmpty**
- 현재 큐을 초기화하는 **clear**

## 속성

- front
- rear

# 큐 구현 방법

- 자료구조 수업 때 했던 방식 기억하기 (front, rear로 구현했던거)
- 연결리스트로 구현
- 배열로 순환큐를 만들어 구현
- 스택 2개로 구현

# 큐의 구현 in JavaScript

## 자바스크립트의 `push()`, `shift()`를 이용해 큐 구현

### pseudo code

### 전체 코드

```js
class Queue {
  constructor() {
    this.arr = [];
  }

  enqueue(data) {
    this.arr.push(data);
  }
  dequeue() {
    this.arr.shift();
  }
  length() {
    return this.arr.length;
  }
  peek() {
    return this.arr[0];
  }

  clear() {
    this.arr = [];
  }
  print() {
    console.log(this.arr);
  }
}

const queue = new Queue();
queue.enqueue(1);
queue.enqueue(10);
queue.enqueue(100);
queue.print(); // [1,10,100]
queue.dequeue();
queue.print(); // [10,100]
console.log(queue.peek()); // 10
console.log(queue.length()); // 2
queue.clear();
queue.print(); // []
```

다만 `shift()`메소드의 경우 배열 맨 앞의 값을 삭제하고 배열의 기존 요소들을 앞으로 당겨줘야하므로 성능이 좋지 않다.

## 스택으로 큐 구현하기

스택을 연결리스트로 구현하고 이 스택을 이용해 큐 구현하기

참고 <https://velog.io/@raram2/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EB%A1%9C-%EC%8A%A4%ED%83%9D%EA%B3%BC-%ED%81%90-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-Stack-Queue>

# 우선순위 큐(Priority Queue)

# References

- [JavaScript로 Stack 구현하기](https://gogomalibu.tistory.com/52)
- [자바스크립트로 스택과 큐 구현하기](https://velog.io/@raram2/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EB%A1%9C-%EC%8A%A4%ED%83%9D%EA%B3%BC-%ED%81%90-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-Stack-Queue)⭐
  - 연결리스트로 스택 구현, 2개의 스택으로 큐 구현
- [javascript로 queue 구현](https://jinchuu1391.tistory.com/48)
  - 우선순위큐,
