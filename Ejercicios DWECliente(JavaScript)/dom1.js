//var array_enlaces= document.getElementsByTagName("a");
//console.log(array_enlaces);

//var num_enlaces=array_enlaces.length;
//console.log("el numero de enlaces es "+array_enlaces.length);

//primera forma
var array_enlaces = document.getElementsByTagName("a").length;
console.log("El numero de enlaces es " + array_enlaces);

//segunda forma

console.log(document.querySelectorAll("a").length);
console.log(document.querySelectorAll("a"));
console.log(document.querySelectorAll("a"));

for (i = 0; i < document.querySelectorAll("a").length; i++) {
  console.log(document.querySelectorAll("a")[i].href);
}

//numero de enlaces que enlazar a marca
var enlacesmarca=0;
var enlaces1=document.getElementsByTagName();

//numero de enlaces del tercer parrafo
var enlacestercerparrafo=0;
var parrafos=document.getElementsByTagName("p");
var parrafos2=document.querySelectorAll("p");
enlaces=parrafos[2].getElementsByTagName("a");
enlaces=parrafos[2].querySelectorAll("a");
var enlacestercerparrafo2=enlaces2.length;
document.write("Hay " +enlacestercerparrafo+ "enlaces en el tercer parrafo" +enlacestercerparrafo2);