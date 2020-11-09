function añadir (){
  let lista= document.getElementById("diariosdeportivos");
  var nuevoelemento=`<li>${prompt("introduzca un periodico")}</li>`;
  lista.innerHTML=lista.innerHTML+nuevoelemento;
}


//con manjeadores

var evento1=document.getElementById("botonAnadir");
//evento1.onclick=añadir();