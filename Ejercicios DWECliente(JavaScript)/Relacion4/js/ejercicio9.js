function ascendenteDescendente(vector){

var vector1= new Array;
var vector2=[];

vector1=[...vector];
vector2=[...vector];
vector1.sort();
vector2.sort().reverse();

console.log("Array Original "+vector+" Array Ascendente "+vector1+" Array Descendente "+vector2);

}

ascendenteDescendente([1,5,5,8,2,-50,]);