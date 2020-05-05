    var canvas;
    var ctx;
    var ancho=900;
    var alto=700;

document.addEventListener('keydown',function(evento){
    if(evento.keyCode=32){
        console.log("goku salta");
        saltar();
        
    }
});

var imgFondo,imgGoku,imgVegeta;
function preloadImagenes(){
    imgFondo = new Image();
    imgGoku = new Image();
    imgVegeta = new Image();
    imgBola = new Image();


    imgFondo.src = 'imagenes/fondo.jpg';
    imgGoku.src = 'imagenes/gokuui.png';
    imgVegeta.src = 'imagenes/vegeta.png';
    imgBola.src = 'imagenes/6.png';
    
};



function inicializa(){
    canvas=document.getElementById('canvas');
    ctx=canvas.getContext('2d');
    preloadImagenes();
 
}

function borradoCanvas(){
    canvas.width = ancho;
    canvas.height = alto;
}


suelo=400;
var goku={y:suelo, vy:0,gravedad:2,salto:28,vymax:9, saltando:false};
var nivel={velocidad:9, puntuacion:0, muerto: false};
var vegetaRival1={x:ancho+100 ,y: suelo};
var peleaDeFondo={x:200,y:70,velocidad:4};
var FondoDelTorneo={x:0,y:850};


function dibujaGoku(){
    ctx.drawImage(imgGoku,0,0,408,550,150,goku.y-20,200,170);
}


function dibujaVegetaRival() {
    ctx.drawImage(imgVegeta,0,0,543,460,vegetaRival1.x,vegetaRival1.y,250,160);
}

function dibujaBola(){
    ctx.drawImage(imgBola,0,0,200,100,peleaDeFondo.x,peleaDeFondo.y,480,100);
}

function MovimientoRivales() {
    if(vegetaRival1.x < -100){
        vegetaRival1.x=ancho+100;
    }
    else{
        vegetaRival1.x -= nivel.velocidad;
    }
}

function MovimientoPeleaFondo() {
    if(peleaDeFondo.x < -100){
        peleaDeFondo.x=ancho+100;
    }
    else{
        peleaDeFondo.x -= peleaDeFondo.velocidad;
    }
}

//-------------------------------------------

//voy a dibujar el fondo

function dibujaFondo(){
    ctx.drawImage(imgFondo,0,0);
}



function saltar(){
    goku.saltando=true; 
    goku.vy = goku.salto;
}


function gravedad(){
    if(goku.saltando==true){

        if(goku.y - goku.vy - goku.gravedad > suelo ){ // si goku llega al suelo , le quito los valores de la gravedad y de la velodad 
                                                    // para evitar el rebote que se general al tocar el suelo 
            goku.saltando=false;
            goku.vy=0; // pongo su velociudad en el ejey y en 0 otra vez porque ha llegado al suelo
            goku.y=suelo; 
        }
        else{ // si no, la velodad y la posicion de goku en el eje y sera la establecidad por los atributos
            goku.vy -= goku.gravedad;  
            goku.y -= goku.vy; 
        }
         
    }
}

function colision(){

    if(vegetaRival1.x >=100 && vegetaRival1.x <=150 ){
        if(goku.y >= suelo-100){
            nivel.muerto=true;
            if(nivel.muerto ==true){
                nivel.velocidad=9;
                vegetaRival1.x=1000;
                
            }
            else{
            nivel.velocidad=9;
            
            }
            alert("Has muerto Goku!!\n\nPulsa intro hasta que puedas volver a jugar\n\nIMPORTANTE: DALE A INICIAR JUEGO.\n\nCON LA BARRA ESPACIADORA SE SALTA,ANIMO SAIYAN!");
        }
        
    }
    return true;
}

function puntuacion(){
    if(nivel.muerto == true){
        ctx.font = "60px impact";
        ctx.fillStyle= "#ff0000"
        ctx.fillText(`1ºDAW PARLÓN`,270,280);
    }

}

//function colisionSi(){
//    if(colision==true){
//        principal();
//    }
//}



//----------------------------------------------------------------------

//BUCLE DEL JUEGO
var FPS=50;
setInterval(function(){
    principal();

},1000/FPS);

function principal(){
    //console.log("Hola funciona el juego");
    
    borradoCanvas();
    dibujaFondo();
    colision();
    dibujaGoku();
    gravedad();
    dibujaVegetaRival();
    MovimientoRivales();
    dibujaBola();
    MovimientoPeleaFondo();
    //colisionSi();
    puntuacion();

}

   

