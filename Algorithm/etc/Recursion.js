function draw(h){

    if(h === 0) return;
    draw(h-1);
    for(let i = 0; i < h; i++){
        document.write('#');
    }
    document.write('<br>');
}

function mainFunc(){

    let height = prompt('height: ');

    draw(height);
}

mainFunc();