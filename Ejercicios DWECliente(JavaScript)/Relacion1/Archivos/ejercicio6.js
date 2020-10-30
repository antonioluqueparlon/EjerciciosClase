function mostrarTabla(numero){

    var numero= parseInt(prompt(`Introduzca numero `));
    for(let i=1;i<=10;i++){
        document.write(`${numero} x ${i} = `+ numero*i +`<br>`);
    }
}
