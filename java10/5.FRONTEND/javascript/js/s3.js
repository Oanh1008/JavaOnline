let person={
    name:'Pham Van Oanh',
    age: 22,
    skills:['Java', 'Sql'],
    company:{
        id:'xd15',
        name:'glb'
    }
}
console.log(person)

function Car(make,model,year){
    this.make=make;
    this.model=model;
    this.year=year;
}
const car1= new Car('Eagle','Talon Ts1',2022);
console.log(car1)