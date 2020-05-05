<!-- Variables -->

var contador_avance=0;
var pantalla_juego =2;
var nivel_juego =0;


var aleatorio =0;
var aleatorio2 =0;
var direccion1 =0;
var direccion2 =0;
var contador_golpe1=0;
var contador_golpe2=0;
var contador_bola1=0;
var contador_bola2=0;


var salto_potencia1 = 0;
var salto_potencia2 = 0;
var direccionx =0;
var direcciony =0;

var cantidad_seres = 30;
var cantidad_seresmax = 50;

var vida1=100;
var vida2=100;
var ki1=100;
var ki2=100;


<!-- Opciones -->

var gravedad = 20;


var p1_bolaenergia = 5;
var p1_vel = 15;
var p1_salto = 35;
var p1_podergolpe = 2;
var p1_poderbola = 10;



var p2_bolaenergia = 5;
var p2_vel = 15;
var p2_salto = 35;
var p2_podergolpe = 2;
var p2_poderbola = 10;




var ser=new Array();
ser[1]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[2]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[3]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[4]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[5]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[6]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[7]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[8]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[9]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[10]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[11]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[12]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[13]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[14]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[15]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[16]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[17]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[18]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[19]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[20]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[21]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[22]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[23]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[24]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[25]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[26]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[27]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[28]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[29]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
ser[30]=new ente(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);



ser[1].x=0; ser[1].y=1000; ser[1].xmax=0; ser[1].ymax=1000;	ser[1].w=1; ser[1].h=1; ser[1].volumen=1; ser[1].volumenmax=1; ser[1].fotograma=1; ser[1].fotogramamax=1; ser[1].dibujo=1; ser[1].dibujomax=1;ser[1].vida=100; ser[1].vidamax=100; ser[1].accion=0; ser[1].accionmax=0; ser[1].accion2=0; ser[1].accion2max=0;	
ser[1].accion3=0; ser[1].accion3max=0; ser[1].accionss=0; ser[1].avance=0;	ser[1].avance2=0; ser[1].avance3=0; ser[1].poder=30; ser[1].potencia=0; ser[1].etereo=0; ser[1].estado=1;	ser[1].estado2=1; ser[1].estado3=1; ser[1].estado4=1; ser[1].masa=1; ser[1].impulsox=0; ser[1].impulsoy=0;	
	



var cantidad_espejismos = 2;
var cantidad_espejismosmax = 20;

var espejismo=new Array();
espejismo[1]=new espejo(0,0,0,0,0,0,0);
espejismo[2]=new espejo(0,0,0,0,0,0,0);
espejismo[3]=new espejo(0,0,0,0,0,0,0);
espejismo[4]=new espejo(0,0,0,0,0,0,0);
espejismo[5]=new espejo(0,0,0,0,0,0,0);
espejismo[6]=new espejo(0,0,0,0,0,0,0);
espejismo[7]=new espejo(0,0,0,0,0,0,0);
espejismo[8]=new espejo(0,0,0,0,0,0,0);
espejismo[9]=new espejo(0,0,0,0,0,0,0);
espejismo[10]=new espejo(0,0,0,0,0,0,0);
espejismo[11]=new espejo(0,0,0,0,0,0,0);
espejismo[12]=new espejo(0,0,0,0,0,0,0);
espejismo[13]=new espejo(0,0,0,0,0,0,0);
espejismo[14]=new espejo(0,0,0,0,0,0,0);
espejismo[15]=new espejo(0,0,0,0,0,0,0);
espejismo[16]=new espejo(0,0,0,0,0,0,0);
espejismo[17]=new espejo(0,0,0,0,0,0,0);
espejismo[18]=new espejo(0,0,0,0,0,0,0);
espejismo[19]=new espejo(0,0,0,0,0,0,0);
espejismo[20]=new espejo(0,0,0,0,0,0,0);







<!-- mensajes -->

var cantidad_mensajes = 21;
var cantidad_mensajesmax = 21;
var mensaje=new Array();
mensaje[1]=new mensajex(0,0,0,0,0,0);
mensaje[2]=new mensajex(0,0,0,0,0,0);
mensaje[3]=new mensajex(0,0,0,0,0,0);




<!-- dibujo -->
var cordenadax_dibuja=0;
var cordenaday_dibuja=0;
<!-- /dibujo -->


<!-- contadores  -->

var contador1=0;
var contador2=0;
var contador3=0;


<!-- /contadores -->


