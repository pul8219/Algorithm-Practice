package codility.lesson04_CountingElements_MissingInteger;

import java.util.HashSet;
import java.util.Set;

// 배열에 등장하지 않는데 가장 작은 양의 정수를 리턴하면 되는 것!!!
// 음수만 있는 경우에는 1을 리턴
// Java HashSet 이용

class Solution{
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i : A){ // 배열 A의 모든 요소를 Hashset에 담기
            set.add(i);
        }

        for(int i = 1; i <= Integer.MAX_VALUE; i++){ // i: 1~최대 int자료형의 최대값까지 반복
            // i가 set에 존재하지 않으면 아래 if 조건문을 만족시킴 -> 등장하지 않는 가장 작은 양의 정수 찾은 것!
            if(!set.contains(i)) // HashSet.contains(): Set 안에 객체가 존재하면 True 리턴하는 함수
                return i;
        }
        return -1;
    }
}


public class pul8219 {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] A = {-1,-2,-3,1,2,3,4,5,7};
        System.out.println(s.solution(A));
    }
}
