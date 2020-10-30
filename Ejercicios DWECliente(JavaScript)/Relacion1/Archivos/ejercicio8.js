    var numeroAleatorio = Math.random()*(100-0)+0;
    console.log(`${numeroAleatorio}`);
    var limiteInferior=1;
    var limiteSuperior=100;

    do{
    numero= parseInt(prompt(`Introduzca numero entre ${limiteInferior} y ${limiteSuperior}`));
    intentos++;
    if(numero<numeroAleatorio)
    limiteInferior=numero;
    else
    limiteSuperior=numero;
    }while (numero!=numeroAleatorio)
    console.log(`has acertado en ${intentos}`);


