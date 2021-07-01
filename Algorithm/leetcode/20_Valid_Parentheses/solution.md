# 20. Valid Parentheses

- 문제 분류: ``
- 문제 출처: [LeetCode - 20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- 라벨: `Easy`, `JavaScript`

# 목차

- [문제 설명](#문제-설명)
- [풀이 아이디어 및 고민](#풀이-아이디어-및-고민)
- [최종 코드](#최종-코드)
- [References](#references)

# 문제 설명

# 풀이 아이디어 및 고민

## 첫번째 풀이

힌트만 보고 고민해서 작성한 첫번째 풀이. 배열로 만든 스택에 문자열의 문자들을 push, pop하는 방식으로 풀이했다.

### pseudo code

```
스택이 비어있을 경우, 문자를 바로 추가(문제: 닫는 괄호도 바로 들어갈 수 있다.)

문자열의 문자를 도는 for 반복문{
    스택의 (배열의 가장 끝에 있는)최상단(top)요소(문제: 이게 닫는 괄호일 수 있다)에 대응하는 닫힘괄호와 현재 문자가{
        같으면 -> 최상단 요소를 스택에서 제거 stack.pop()
        다르면 -> 현재 문자를 스택에 추가 stack.push(data)
    }
}

최종적으로 스택이 비어있으면 true를 리턴, 스택이 비어있지 않을 경우 false 리턴

```

### 코드

```js
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  const arr = [];

  const brackets = {
    '(': ')',
    '{': '}',
    '[': ']',
  };

  for (let i = 0; i < s.length; i++) {
    if (arr.length === 0) {
      arr.push(s[i]); // 중복 ❗
      continue;
    }
    let comp = arr[arr.length - 1];
    if (brackets[comp] === s[i]) {
      arr.pop();
      continue;
    }
    arr.push(s[i]); // 중복 ❗
  }
  return arr.length === 0;
};
```

### 실행 결과 및 개선점

- 제출 상태: `Accepted`
- Runtime: 116ms (faster than 9.07%)
- Memory Usage: 40.2MB (less than 15.51%)

=> 런타임 개선 필요 있음

> 개선할 점

- 중간에 틀린 것을 알 수 있음에도 문자열의 끝까지 for문이 돈다. (`"([)]"` 이런 경우 중간에서 걸러낼 수 있음)
- stack 배열이 비어있는 경우는 따로 체크해주지 말고 다른 조건을 검사할 때 자동적으로 걸러질 수 있도록 고쳐서 `arr.push(s[i])` 코드의 중복을 없애자.

## 다른 풀이

```js
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  let stack = [];
  s = s.split('');
  const BRACKETS = {
    '{': '}',
    '[': ']',
    '(': ')',
  };

  for (e of s) {
    // if last item on stack is opposite parenthesis, pop from stack
    if (BRACKETS[stack[stack.length - 1]] === e) {
      stack.pop();
    } else {
      // if we push closing, then it's invalid, return false
      if (e === ')' || e === '}' || e === '}') {
        return false;
      }

      // if not, we are pushing one of the opening to the stack
      stack.push(e);
    }
  }

  // if stack is empty, state is valid
  return stack.length === 0;
};
```

### 이해 후 다시 작성

첫번째 풀이에서 개선한 점

- `for` 반복문 대신 `for ...of` 사용
  - `for...of`는 반복가능한 객체(Array, Map, Set, String, TypedArray, arguments 객체 등)에 대해 반복할 수 있는 명령문이기 때문에 문자열에도 `for...of`를 쓸 수 있다.
- 불필요하게 중복되는 조건 제거
- continue 사용 x

pseudo code

```
문자열을 돌며 반복{
    ✔️(if문) 스택의 최상단요소(배열의 마지막 요소)에 대응하는 닫힘괄호가 현재 문자와 같다면{
        배열에서 최상단요소를 꺼낸다(pop)
        (*** 스택이 비어있는 경우는 여기에 들어오지도 않고 else문으로 갈 것이다.)
    }
    ✔️(else문){ // 아래 if문으로 인해 스택에는 열림괄호만 들어갈 것이고 상단 if문이 아닌 이 곳 else문으로 왔다는 건 현재 문자가 스택 최상단요소에 대응하는 닫힘괄호가 아니라는 뜻이다.
        ✔️(if문) 현재문자가 ), }, ] 셋 중 하나이면 false를 리턴해라(invalid하니까 더이상 볼 필요가 없다는 것)
        위의 if문에도 해당되지 않으면 현재 문자를 스택에 넣어라(push)
    }
}

끝까지 다 돌았으니 스택이 비어있으면 true를, 그렇지 않으면 false를 리턴하기
```

```js
var isValid = function (s) {
  const arr = [];

  const brackets = {
    '(': ')',
    '{': '}',
    '[': ']',
  };

  for (elem of s) {
    if (brackets[arr[arr.length - 1]] === elem) arr.pop();
    else {
      if (elem === ')' || elem === ']' || elem === '}') return false;
      arr.push(elem);
    }
  }
  return arr.length === 0;
};
```

- 제출 상태: `Accepted`
- Runtime: 72ms(faster than 95.73%)
- Memory Usage: 39.3MB(less than 35.91%)

## 다른 풀이

```js
let isValid = (A, s = []) => {
  for (let c of A)
    if (c == '(') s.push(')');
    else if (c == '[') s.push(']');
    else if (c == '{') s.push('}');
    else if (!s.length || c != s.pop()) return false;
  return !s.length;
};
```

### 이해 후 다시 작성

```js
var isValid = function (s, arr = []) {
  for (elem of s) {
    if (elem === '(') arr.push(')');
    else if (elem === '[') arr.push(']');
    else if (elem === '{') arr.push('}');
    else if (!arr.length || elem !== arr.pop()) return false;
  }
  return !arr.length;
};
```

- 제출 상태: `Accepted`
- Runtime: 84ms(faster than 38.47%)
- Memory Usage: 39.4MB(less than 32.35%)

# 최종 코드

# References
