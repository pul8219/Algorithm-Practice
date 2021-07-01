# 배열(Array)

선형 자료구조

- 찾고자 하는 원소의 인덱스(index) 값을 알고 있으면 `O(1)`로 원소에 접근할 수 있다. **랜덤 접근(random access)**가 가능하다.
- 하지만 경우 해당 원소에 접근한 뒤(`O(1)`) 삭제의 경우 특정 원소를 삭제 후 그 뒤의 원소들을 shift 해주거나, 삽입의 경우 삽입하고자 하는 위치부터 그 뒤의 원소들을 1씩 shift하고 삽입해야한다. 그래서 삭제, 삽입의 경우 시간 복잡도는 `O(n)`가 된다.

# 연결리스트(Linked List)

선형 자료구조

각 원소들이 자기자신 다음에 어떤 원소가 오는지 기억하고 있는 자료구조. 데이터를 메모리나 디스크에 연속적으로 할당되지 않는다.(=/= 배열)

장점

- 동적 크기
- 삽입과 삭제가 용이: 다음 원소를 가리키는 포인터만 바꿔주면 삽입, 삭제 자체는 `O(1)`로 해결할 수 있다. (배열의 삽입, 삭제시 단점을 해결)

단점

- 포인터를 위한 여분의 메모리 공간이 필요: 포인터로 다음 원소를 지정해야하기 때문
- random access 불가능: 삽입, 삭제할 위치를 찾을 때도(search) 첫 번째 원소부터 모두 확인하며 찾아가야한다. (순차 탐색)

결국 연결 리스트는 탐색할 때(search) `O(n)`, 삽입/삭제할 때 `O(n)`의 시간 복잡도를 갖는다.

## 구현 in JavaScript

```js
class Node {
  constructor(elem) {
    this.elem = elem;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = new Node('head');
    this.tail = null;
  }

  // isEmpty(){
  //   return this.size === 0;
  // }

  // 노드 찾기
  find(item) {
    let curNode = this.head;
    while (curNode.elem != item) {
      curNode = curNode.next;
    }
    return curNode;
  }

  // 노드 추가(명시한 item 뒤에, 명시하지 않았다면 자동으로 맨앞에 추가)
  insert(newItem, item = 'head') {
    let newNode = new Node(newItem);
    if (this.head.next === null) {
      this.head.next = newNode;
    } else {
      let current = this.find(item);
      newNode.next = current.next;
      current.next = newNode;
    }

    if (newNode.next === null) {
      this.tail = newNode;
    }
  }

  // 가장 마지막에 노드 추가
  addToTail(newItem) {
    let newNode = new Node(newItem);
    // 현재 tail에 연결
    // console.log(this.tail);
    this.tail.next = newNode;
    this.tail = newNode;
  }

  // 연결 리스트 요소들 출력
  print() {
    let curNode = this.head;
    console.log('==========');
    while (curNode.next !== null) {
      console.log(curNode.next.elem);
      curNode = curNode.next;
    }
    console.log('==========');
    // console.log(this.tail);
  }

  // 이전 노드 찾기
  findPrev(item) {
    let curNode = this.head;
    while (curNode.next !== null && curNode.next.elem != item) {
      curNode = curNode.next;
    }
    return curNode;
  }

  // 노드 삭제
  remove(item) {
    let preNode = this.findPrev(item); // 삭제할 노드 이전 노드를 찾기
    preNode.next = preNode.next.next;
  }
}

const list = new LinkedList();
list.insert('seoul');
list.insert('busan', 'seoul');
list.insert('daegu');
list.addToTail('gwangju');
list.insert('yangyang', 'gwangju');

list.print();

list.remove('gwangju');
list.remove('daegu');

list.print();
```

https://dororongju.tistory.com/107
https://velog.io/@760kry/JS-Linked-List-vs-Array-List-data-structor
https://jeong-pro.tistory.com/126

## 이중 연결 리스트

## 원형 연결 리스트
