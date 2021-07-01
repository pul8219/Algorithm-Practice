class Queue{
    constructor(){
        this.arr = [];
    }

    enqueue(data){
        this.arr.push(data);
    }
    dequeue(){
        this.arr.shift();
    }
    length(){
        return this.arr.length;
    }
    peek(){
        return this.arr[0];
    }

    clear(){
        this.arr = [];
    }
    print(){
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




