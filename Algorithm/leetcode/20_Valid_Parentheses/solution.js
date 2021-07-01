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
  
    for (elem of s) {
      if (brackets[arr[arr.length - 1]] === elem) arr.pop();
      else {
        if (elem === ')' || elem === ']' || elem === '}') return false;
        
        arr.push(elem);
      }
    }
    return arr.length === 0;
  };

// let isValid = (s, arr=[]) => {
//     // s = s.split('');

//     for(elem of s){
//         if(elem === '(') arr.push(')');
//         else if(elem === '[') arr.push(']');
//         else if(elem === '{') arr.push('}');
//         else if(!arr.length || elem !== arr.pop()) return false;
//     }
//     return !arr.length;

// };
const s = '()()[][]';
console.log(isValid(s));