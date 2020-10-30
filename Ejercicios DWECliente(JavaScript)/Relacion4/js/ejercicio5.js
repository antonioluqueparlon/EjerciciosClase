function devuelveTiempoPasado() {

    var fechaDada= new Date(1990,1,31);
    var hoy=new Date();
    var milisHoy= hoy.getTime();
    console.log("fecha hoy "+milisHoy);
    var milisFechaDada= fechaDada.getTime();
    console.log("fecha dada "+milisFechaDada);

    var diferencia= milisHoy-milisFechaDada;
    console.log("milis solucion "+diferencia);

    //milisegundos que tiene un año
    var milisUnAño=1000*60*60*24*365;
    //calculo la diferencia entre los milis del año actual y del año pasado
    annostotales=diferencia/milisUnAño;


    console.log("Han pasado "+annostotales+" años");
    
}

devuelveTiempoPasado();
