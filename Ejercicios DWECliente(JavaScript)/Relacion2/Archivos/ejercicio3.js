function multiplo(numero,multiplo){

    //Para saber si son multiplos o no tenemos que hacer una funcion con el resto del modulo de la division
    resto=numero%multiplo;
    if(resto==0){
        return true;
    }
    else{
        return false;
    }
        
    }
    //arrays que tendran los multiplos de los numeros que yo quiero (en este caso multiplos de 11)

    const multiplos11=[];

    //bucle del 1 al numero que yo quiera que compruebe, en este caso hasta 3000
    for(var i=1; i<=3000;i++){
         if(multiplo(i,11)) // esto sera si es true la sentencia
         multiplos11.push(i);
    }

    //muestro en pantalla
    document.write("El array de los multiplos de 11 es: "+multiplos11);


