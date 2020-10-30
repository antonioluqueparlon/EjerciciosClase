function mostrarMayorArray(){
    var array = [6, "pepe", 2, "juan"]; 

    //console.log(array[2-1]);
    
    //determinar cual de los dos elementos de texto es mayor
    var resultado= array[1] > array[3];

    //compruebo que el indice 1 es mayor que el 3(siempre va a ser mayor el que menos indice tenga)
    if(array[3]>array[1]){
        mayor=array[3];
        console.log("jajajajja torpe");

    }else{
        mayor=array[1];
        console.log("ahora si");
    }
    document.write(`${array[1]} es mayor que ${array[3]}`);
    console.log(`${array[1]} es mayor que ${array[3]}`);
}



//sumar restar multiplicar y dividir

function operaciones(){
    var array = [6, "pepe", 2, "juan"];

//suma
var suma=0;
suma +=array[0]+array[2];
console.log("el resultado de la suma es "+suma);
document.write("el resultado de la suma es "+suma+"<br><br>");


//resta
var resta=0;
resta =array[0]-array[2];
console.log("el resultado de la resta es "+resta);
document.write("el resultado de la resta es "+resta+"<br><br>");


//multiplicacion
var multiplicacion=0;
multiplicacion =array[0]*array[2];
console.log("el resultado de la multiplicacion es "+multiplicacion);
document.write("el resultado de la multiplicacion es "+multiplicacion+"<br><br>");


//division
var division=0;
division =array[0]/array[2];
console.log("el resultado de la divison es "+division);
document.write("el resultado de la divison es "+division+"<br><br>");
}