function menorNumero(n1,n2,n3){

    //mis tres numeros inicializados con sus variables
    var n1= prompt("Introduce un número");
    var n2= prompt("Introduce un número");
    var n3= prompt("Introduce un número");

    //NUMEROS ANALISIS
    if(n1<n2 && n1<n3){
        document.write("el "+n1+ " es el menor");
    }

    if(n2<n1 && n2>n3){
        document.write("el "+n3+ " es el menor");
    }

    if(n1<n3 && n2<n1){
        document.write("el "+n1+ " es el menor");
    }

    if(n1<n3 && n2==n1){
        document.write("el "+n1+ " es el menor");
    }

    if(n2<n1 && n2<n3){
        document.write("el "+n2+ " es el menor");
    }

    if(n3<n1 && n3<n2){
        document.write("el "+n3+ " es el menor");
    }
}