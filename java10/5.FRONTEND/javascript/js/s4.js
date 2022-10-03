// js selector

let names= document.getElementsByName('lorem');
let classNames=document.getElementsByClassName('past');
let tagNames  =document.getElementsByTagName('p');
let id=document.getElementById('unique');

let selector=document.querySelector('h1.past');
let selectors=document.querySelectorAll('h1.past');

// js crud
//let newTask=document.createElement('li');
//newTask.textContent='Task 04: Todo';
// newTask.style.color='red';
//newTask.classList.add('red-color');
// append
//let todayTasks=document.querySelector('#today-tasks');
//todayTasks.children[0].remove();

//todayTasks.insertBefore(newTask,todayTasks.children[1]);
//todayTasks.appendChild(newTask);
let todayTasks=document.getElementById('today-tasks');
let addBtn=document.querySelector('.add');
let input=document.querySelector('.task-text');
// keypress=on keydown ->on keyup
input.onkeypress=function(event){
    if(event.which==13){
        addTask();
    }
}
/*addBtn.onclick=function(){
    addTask();
}
*/
// another way
addBtn.addEventListener('click',function(){
    //addTask();
    console.log('click1');
});
addBtn.addEventListener('click',function(){
    //addTask();
    console.log('click2');
});
addBtn.onmouseover=function(){
    this.style.background='orange';
}
addBtn.onmouseout=function(){
    this.style.background=null;
}

document.addEventListener('click',function(event){
    console.log(event.target)
});x
// utils function
function addTask(){
    let newTask=document.createElement('li');
    newTask.textContent= input.value;
    newTask.style.color='red';
    todayTasks.appendChild(newTask);
    input.value='';
}