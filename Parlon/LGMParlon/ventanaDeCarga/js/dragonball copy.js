var canvas; 
var vida1;
var vida2;
var vida1=100;
var vida2=100;
var ki1=100;
var ki2=100;
var ctx;


var ondavitalVegeta;
var desplazamientoOnda = 20;
var imgFondo, imgGokumin,
    imgCargadas = 0;
var coordenadasVegetita
var coordenadasKakarot

<!--COSAS PARA PROBAR SI FUNCIONA-->
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

<!-- CONTROLES -->
var mousex=0;
var mousey=0;
var tecla_izquierda = 37;
var tecla_arriba = 38;
var tecla_derecha = 39;
var tecla_abajo = 40;
var tecla_a = 65;
var tecla_b = 66;
var tecla_c = 67;
var tecla_d = 68;
var tecla_e = 69;
var tecla_f = 70;
var tecla_g = 71;
var tecla_h = 72;
var tecla_i = 73;
var tecla_j = 74;
var tecla_k = 75;
var tecla_l = 76;
var tecla_m = 77;
var tecla_n = 78;
var tecla_o = 79;
var tecla_p = 80;
var tecla_q = 81;
var tecla_r = 82;
var tecla_s = 83;
var tecla_t = 84;
var tecla_u = 85;
var tecla_v = 86;
var tecla_w = 87;
var tecla_x = 88;
var tecla_y = 89;
var tecla_z = 90;
var tecla_enter = 13;
var tecla_espacio = 32;
var tecla_retroceso = 8;
var tecla_mayus = 16;
var tecla_control = 17;


var tecla_disparo = tecla_h;
var tecla_disparo2 = tecla_m;

var tecla_magia1 = tecla_g;
var tecla_magia2 = tecla_n;

var tecla_inventario = tecla_enter;
var tecla_salto = tecla_j;



var tecla_izquierda1 = tecla_a;
var tecla_arriba1 = tecla_w;
var tecla_derecha1 = tecla_d;
var tecla_abajo1 = tecla_s;


var tecla_izquierda2 = tecla_izquierda;
var tecla_arriba2 = tecla_arriba;
var tecla_derecha2 = tecla_derecha;
var tecla_abajo2 = tecla_abajo;
    

class Kakaroto{

    moverDerecha () {
        this.limpiar();
        this.agregarPelotaActualARastro();
        this.x += desplazamientoOnda;
        this.pintar();
    }

}

class Ondavital {
        constructor (x, y, radio) {
            this.x = x;
            this.y = y;
            this.radio = radio;
            this.rastro = [];
        }
    
        pintar() {
            ctx.strokeStyle = "#000000";
            ctx.beginPath();
            ctx.arc(ondavital.x, ondavital.y, ondavital.radio, 0, 2 * Math.PI);
            ctx.arc(ondavitalVegeta.x, ondavitalVegeta.y, ondavitalVegeta.radio, 0, 2 * Math.PI);
            ctx.stroke();
            for (var i = 0; i < this.rastro.length; i++) {
                ctx.strokeStyle = "#d64343";
                ctx.beginPath();
                ctx.arc(this.rastro[i].x, this.rastro[i].y, this.rastro[i].radio, 0, 2 * Math.PI);
                ctx.stroke();
            }
            for (var i = 0; i < this.rastro.length; i++) {
                ctx.strokeStyle = "#13c7df";
                ctx.beginPath();
                ctx.arc(this.rastro[i].x, this.rastro[i].y, this.rastro[i].radio, 0, 2 * Math.PI);
                ctx.stroke();
            }
            
            
        }

        limpiar () {
           // ctx.fillStyle = "#FFFFFF";
           // ctx.fillRect(0, 0, canvas.width, canvas.height);
            paintEscena();
        }

        agregarPelotaActualARastro () {
            this.rastro.push(new Ondavital(this.x, this.y, this.radio, false));
            while (this.rastro.length > 100) {
                this.rastro.shift();
            }
        }

        moverDerecha () {
            this.limpiar();
            this.agregarPelotaActualARastro();
            this.x += desplazamientoOnda;
            this.pintar();
        }
        moverIzquierda () {
            this.limpiar();
            this.agregarPelotaActualARastro();
            this.x -= desplazamientoOnda;
            this.pintar();
        }
        moverArriba () {
            this.limpiar();
            this.agregarPelotaActualARastro();
            this.y -= desplazamientoOnda;
            this.pintar();
        }
        moverAbajo () {
            this.limpiar();
            this.agregarPelotaActualARastro();
            this.y += desplazamientoOnda;
            this.pintar();
        }
    }
    

function init() {
    ondavital = new Ondavital(350,500,50)
    ondavitalVegeta=new Ondavital(700,500,50)
    preloadImagenes();

    canvas = document.getElementById('canvas');
    ctx = canvas.getContext("2d");
  /*  console.log(ondavital); */

   

    document.addEventListener("keydown", function(e){
        if(e.keyCode == "39"){
            ondavital.moverDerecha();
        }
        if(e.keyCode == "37"){
            ondavitalVegeta.moverIzquierda();
        }
        if(e.keyCode == "38"){
            ondavital.moverArriba();
        }
        if(e.keyCode == "40"){
            ondavital.moverAbajo();
        }
    
    });

}

function control_naves () {
	
	
    
    <!-- lanzar bolas de ki -->
	
	if (  presiona[tecla_magia1] && ki1>5 && contador_bola1==0 && (ser[1].subestado==0 || ser[1].estado==4  || ser[1].estado==2) )
	{
		ser[1].estado=11; ser[1].subestado=7;	
		contador_bola1	= 1;	
    }
}

function reFresh(){

  ondavital = new Ondavital(100, 100, 30);
  ondavitalVegeta=new Ondavital(700,500,50)
    paintEscena();

}

function preloadImagenes(){
    imgFondo = new Image();
    imgFondo.width = this.canvas;
    imgFondo.height = this.canvas;
    imgFondo.src = 'imagenes/fondo.jpg';
    imgFondo.addEventListener('load', function(){
        imgCargadas++;
        paintEscena();

    }, false);

    imgGokumini = new Image();
    imgGokumini.src = 'imagenes/gokumini.png';
    imgGokumini.addEventListener('load', function() {
          imgCargadas++;
            paintEscena();
        }, false);

    imgVegetaMini = new Image();
    imgVegetaMini.src = 'imagenes/vegeta.png';
    imgVegetaMini.addEventListener('load', function() {
          imgCargadas++;
            paintEscena();
        }, false);

}


function paintEscena(){
    if (imgCargadas == 3){
        paintFondo();
        ondavital.pintar();
        ondavitalVegeta.pintar();
       
    }
}

function paintFondo(){
    ctx.drawImage(imgFondo, 0, 0);
    ctx.drawImage(imgGokumini,10,200);
    ctx.drawImage(imgVegetaMini,400,200);
}