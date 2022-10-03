// function operate(manipulate){
//     let a= +prompt('Enter a: ');
//     let b= +prompt('Enter b: ');
//     alert('sum: '+manipulate(a,b));
// }
// operate((a,b)=>a+b);
// callback function
/*
Interval
let counter=0;
let randItv=setInterval(function(){
    console.log('Interval: '+Math.random());
    if(counter++===5){
        clearInterval(randItv);
    }
},1000);

Timeout
let randTo=setTimeout(function(){
    console.log('Timeout: '+Math.random()*10);
},300);
*/
/*
let digit=8;
let text='Welcome';
function printDigit(){
    console.log(digit);
    for(let i=0;i<digit;i++){
        console.log('i >> '+i);
    }
}
function printText(){
    console.log(text)
}
printDigit();
printText();

// var function scope
// let block scope
*/
let month=['January','March','April'];
/*
    push(e)    >> add(length-1, e)
    pop()      >> remove(length-1)
    unshift(e) >> add(0, element)
    shift      >> remove(0)
    slice(a,b) >> subList(a,b)
    splice(index, count?) >> remove(idx, count?)
    splice(index, count?, items)
+ count = 0; >> splice(index, 0, items) >> addAll(index, items);
*/
Array.prototype.insert = function(index,element){
    this.splice(index,0,element);
}
