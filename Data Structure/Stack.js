class Stack{
    constructor(){
        this.top = -1;
        this.arr = [];
    }
    push(data){
        this.top++;
        this.arr[this.top] = data;
    }
    pop(){
        if(this.top < 0){
            console.log('Error: Stack is empty.');
            return -1;
        }

        let popData = this.arr[this.top];
        this.arr.splice(this.top, 1);
        this.top--;
        return popData;
    }
    length(){
        return this.arr.length;
    }
    peek(){
        return this.arr[this.top];

    }
    isEmpty(){
        return this.arr.length === 0;

    }
    clear(){
        this.arr = [];
        this.top = -1;
    }
    print(){
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
