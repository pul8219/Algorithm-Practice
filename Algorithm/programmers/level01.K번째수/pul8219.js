function solution(array, commands) {
    var answer = [];
     let slicing = [];
    commands.forEach(command => {
        slicing = array.slice(command[0]-1, command[1]); // array의 i ~ j번째까지 잘라 새로운 배열에 저장

        slicing.sort((a,b) => a-b); // 정렬
        
        answer.push(slicing[command[2]-1]);

        slicing = []; // slicing 배열 초기화
    });
    return answer;
}
// // solution([1,5,2,6,3,7,4], [[2,5,3],[4,4,1],[1,7,3]]);

// solution([3],[[2,5,3],[4,4,1]]);
