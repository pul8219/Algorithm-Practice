/**
 * @param {string} s
 * @return {number}
 */

 var romanToInt = function(s) {
    // const roman = new Map([['I', 1], ['V', 5], ['X', 10], ['L', 50], ['C', 100], ['D', 500], ['M', 1000]]);
    
    const roman = {
        I: 1,
        V: 5,
        X: 10,
        L: 50,
        C: 100,
        D: 500,
        M: 1000
    };

    let result = 0;

    for(let i = s.length-1; i >= 0; i--){
        if(roman[s[i]] > roman[s[i-1]]){
            result += roman[s[i]] - roman[s[i-1]];
            i--;
            continue;
        }
        // if(roman.get(s[i]) > roman.get(s[i-1])){
        //     result += roman.get(s[i]) - roman.get(s[i-1]);
        //     i--;
        //     continue;
        // }
        else{
            result += roman[s[i]];
        }
    }

    return result;
};


const s = "LVIII";
console.log(romanToInt(s));
