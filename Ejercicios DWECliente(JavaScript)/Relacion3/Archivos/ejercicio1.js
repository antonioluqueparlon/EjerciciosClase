var miFecha=new Date();


anoactual=miFecha.getFullYear();
mesactual=miFecha.getMonth()+1; // los meses empiezan en 0
diaSemana=miFecha.getDay();
diaMes=miFecha.getDate();
cuatrimestre=Math.floor((miFecha.getMonth()+4)/4);



document.write("<br></br>Estamos en el dia "+diaMes+" del mes "+mesactual+" del cuatrimestre "+cuatrimestre+" del año "+anoactual);


// “Estamos en el día D (día semana) del mes M (mes actual) del primer|segundo|tercer cuatrimestre del año AAAA”
