function contarVocales (texto){

texto=(prompt("Escribe una cadena de Texto y te saldran cuantas consonantes y vocales tiene"));
var contadorVocales=0;
var contadorConsonantes=0;
var vocales = ['a','e','i','o','u','A','E','I','O','U'];
var consonantes = ['b','c','d','f','g','h','j','k','l','m','n','ñ','p','q','r','s','t','v','w','x','y','z','B','C','D','F','G','H','J','K','L','M','N','Ñ','P','Q','R','S','T','V','W','X','Y','Z'];



for(var j=0; j<texto.length;j++){
    if(consonantes.indexOf(texto[j]) >=0){
        contadorConsonantes++;
    }
}

for(var i=0; i<texto.length;i++){
    if(vocales.indexOf(texto[i]) >=0){
        contadorVocales++;
    }
}

console.log("Vocales: "+contadorVocales+ " Consonantes: "+contadorConsonantes);

}


console.log(contarVocales());
