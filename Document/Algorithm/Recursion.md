# 재귀(Recursion)

`Calls itself`

함수가 본인 스스로를 호출해서 사용하는 것

이진 탐색 예시에 재귀를 적용해보자.

```
Pick up phone book
Open to middle of phone book
Look at page
If Smith is on page
    Call Mike
Else if Smith is earlier in book
    Search left half of book
Else if Smith is later in book
    Search right half of book
Else
    Quit
```

전화번호를 찾기 위해 중간을 펼쳐보고, 또 한 쪽의 중간을 펼쳐보며, ... 계속 절반으로 줄여나가는 예제이다. 이 의사 코드 전체를 Search함수라 생각해보자. `else if`문들에서 Search 스스로를 호출해 이 문제를 재귀적으로 해결할 수도 있다.

## 예제

아래와 같이 피라미드 모양을 출력해보자.

```
#
##
###
####
```

```js
function draw(h) {
  for (let i = 1; i <= h; i++) {
    for (let j = 1; j <= i; j++) {
      document.write('#');
    }
    document.write('<br>');
  }
}

function mainFunc() {
  let height = prompt('height: ');

  draw(height);
}

mainFunc();
```

피라미드의 높이를 입력받아 피라미드를 출력해주는 `draw` 함수를 정의했다. 그런데 여기서 꼭 중첩 루프를 사용해야할까?

높이가 4인 피라미드는 높이가 3인 피라미드에 한줄을 추가한 것이고, 높이가 3인 피라미드는 높이가 2인 피라미드에 한줄을 추가한 것이다. 높이가 2인 피라미드도 높이 1의 피라미드에 한 줄을 추가한것이다.(다만 높이 0의 피라미드는 없다. 알고리즘에 맞게 반환, 종료를 잘 처리해야한다.) 이처럼 눈에 보이는 or 가상의 물체의 구조를 그 물체 자체를 이용해 설명하는 것을 재귀라고 한다.

중첩 반복문으로 작성했던 피라미드 그리기 예제를 `재귀`를 이용해 작은 피라미드로 큰 피라미드를 나타내는 방식으로 고쳐보자.

```js
function draw(h) {
  if (h === 0) return;
  draw(h - 1);
  for (let i = 0; i < h; i++) {
    document.write('#');
  }
  document.write('<br>');
}

function mainFunc() {
  let height = prompt('height: ');

  draw(height);
}

mainFunc();
```

- 높이 4인 피라미드를 그리려면, 4-1값인 높이 3의 피라미드를 그려야 한다. `draw(h-1)`
- 이렇게만 하면 자기 자신을 끊임없이 호출한다. 멈추는 조건이 필요하다. `if(h === 0) return;` (이게 따지고 보면 시작점이 된다.)
- `draw(h-1)`에서 마법처럼 높이 3의 피라미드를 모두 그려준다고 일단 가정해보자. 이렇게 높이 3의 피라미드를 그렸다면, 높이 4의 피라미드로 만들기 위해 추가해야할 코드가 있다.
- 중첩 반복문와 달리 `for`문은 한번만 사용되었다. 이렇게 재귀적인 방식으로 중첩 반복문을 쓴 예제와 동일한 작업을 수행할 수 있다.

# References

- [하버드 CS50 - 4.알고리즘 7)재귀](https://www.boostcourse.org/cs112/joinLectures/41307)
