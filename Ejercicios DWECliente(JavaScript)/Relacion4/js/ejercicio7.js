//function mayorMenor(arrayNumeros) {
  //var arrayNumeros = [7, 4, 5, 199, -21];
 // arrayNumeros.forEach(arrayNumeros =>{
   //   document.write("Mayor" + max + "Minimo " +min);
  //});


  //console.log(+min+" "+max);
//}

var arrayNumeros=[1,2,3,4,5,6,7,8,9];

var min = Math.min.apply(null, arrayNumeros);
var max = Math.max.apply(null, arrayNumeros);

const arrayNumerosArrow = () => { return console.log("Maximo : "+max+" Minimo: "+min) }
//const arrayNumerosArrow = (arrayNumeros) => { return +max }

console.log(arrayNumerosArrow() );







