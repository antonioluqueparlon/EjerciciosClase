function calcletra(){
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

    var numero = prompt("Introduce tu número de DNI (sin la letra)");

    var letraCalculada=letras[numero%23];

    //comrpobamos el dni
    if(numero <0 || numero>99999999){
        alert("este dni es erroneo");
    }
    //una vez hemos comprobado que es un dni podemos buscar la letra en el array de letras y se la 
    //mostramos al usuario
    else{
        alert("Su letra de DNI es: "+letraCalculada);
    }

    
}