function compruebaTriangulo(lado1,lado2,lado3,angulo1,angulo2,angulo3){
    var sumaAngulos=parseInt(angulo1)+parseInt(angulo2)+parseInt(angulo3);
    var equi=false;

    if (lado1 != 0 && lado2 != 0 && lado3 != 0 && sumaAngulos==180) {

        if(angulo1==60 && angulo2==60 && angulo3==60 && lado1==lado2 && lado2==lado3){
        document.write('Equilátero');
        equi=true;
        }

        if((angulo1==angulo2 || angulo2==angulo3 || angulo1==angulo3) && (lado1==lado2 || lado2==lado3 || lado1==lado3) && !equi){
        document.write('Isósceles');
        }
        
        if( (angulo1!=angulo2 && angulo2!=angulo3 && angulo1!=angulo3) && (lado1!=lado2 && lado2!=lado3 && lado1!=lado3)){
        document.write('Escaleno');
        }
        
        if(angulo1==90 || angulo2==90 || angulo3==90){
        document.write(" y además es réctangulo.")
        }

    }
    else{
        document.write("no es un triangulo");
        console.log("no es un triangulo");
        window.alert("no es un triangulo");
    }

}