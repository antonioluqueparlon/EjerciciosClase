function miFuncion() {

var arrayNumeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var arrayPares = [];
var arrayImpares = [];

for (let i = 0; i < arrayNumeros.length; i++) {
    if (i % 2 == 0) {
        arrayPares.push(arrayNumeros[i]);
    }
    else {
        arrayImpares.push(arrayNumeros[i]);
    }

}

document.writeln("Los numeros pares son " + arrayPares+"<br>");
document.write("Los numeros impares son " + arrayImpares);
}

miFuncion();