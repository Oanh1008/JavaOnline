// alert("Welcome to js !!");
// alert("How are you");


let digit = 120;
console.log('digit: ' + digit);
console.log(`digit: ${digit}`);
console.log('type ' + (typeof digit))

console.log('================================');
//dynamic type
let dnm;
console.log(typeof dnm);

dnm = 'type';
console.log(typeof dnm);

dnm = null;
console.log(typeof dnm); // object

dnm = 11;
console.log(typeof dnm);
console.log('================================');

let text = 'Loosely type';
console.log(text.length);
for (let i = 0; i < text.length; i++) {
    console.log(text[i]);
};
console.log('================================');
for (let lt of text) {
    console.log(lt)
}
// let isAdult= confirm("are you 18 years old or older");
// alert('isAdult: '+isAdult)

let accepted = confirm('Do you want to play the game ?');
if (accepted === true) {
    let a = +prompt('Enter a: ',0);
    let b=+prompt('Enter b: ',0);

    
    alert('rs: '+sum(a,b));
}
// declaration function 
function sum(a,b) {
    return a+ b;
}
//expression

let sub = (a,b)=>{
    return a-b;
}
console.log('sub: '+sub(7,4));