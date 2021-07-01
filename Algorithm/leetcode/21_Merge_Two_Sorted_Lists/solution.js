/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
 var mergeTwoLists = function(l1, l2) {
    
    let list = new ListNode();
    let head = list;
    
    while(l1 !== null && l2 !== null){ // l1, l2 모두 null이 아닐 때까지 반복
        if(l1.val < l2.val){
            list.next = new ListNode(l1.val);
            l1 = l1.next;
        }
        else{
            list.next = new ListNode(l2.val);
            l2 = l2.next;
        }
        list = list.next;
    }
    
    // if(l1 !== null){
    //     list.next = l1;
    // }
    // if(l2 !== null){
    //     list.next = l2;
    // }
    
    list.next = l1  || l2; // l1, l2 중에 값이 비교되지 않은 노드가 남아있을 수 있다. 따라서 현재 null을 가리키고 있는 리스트(모두 검사 완료)말고 다른 리스트의 노드를 이어주어야한다.
    
    // let curNode = head.next;
    // while(curNode !== null){
    //     console.log(curNode.val);
    //     curNode = curNode.next;
    // }
    return head.next;

};

// 재귀적인 방법으로 푸는 방법
// 실행시켜보니까 풀이1보다 훨씬 빠르다.
var mergeTwoLists2 = function(l1, l2){
    // l1, l2중 하나가 null이라면 둘 중 null이 아닌 것을 반환. 물론 둘다 null일 경우는 null을 리턴할 것이다.
    if(!l1 || !l2) return l1 || l2
    if(l1.val < l2.val){
        l1.next = mergeTwoLists(l1.next, l2)
        return l1
    }
    l2.next = mergeTwoLists(l1, l2.next)
    return l2
}

