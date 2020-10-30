var factura = {
  empresa: {
    nife: "51182647b",
    nombree: "empresaluque",
    direccione: "lucena",
    telefonoe: "345678900",
  },

  cliente: {
    ncliente: "11243",
    dnic: "123456789",
    nombrec: "pepe",
    domiciliocl: "peso32",
    cp: "14900",
    ciudad: "lucena",
    provincia: "cordoba",
  },

  productos: [
    { descripcion: "bolsa pipas", cantidad: 1, precio: 10 },
    { descripcion: "chicles", cantidad: 1, precio: 20 },
    { descripcion: "chupachups", cantidad: 1, precio: 30 },
  ],

  informacion: {
    total: 0,
    formaPago: "contado",
  },
};

//calculo la factura y la muestro

factura.calculaTotal = function () {
  for (var i = 0; i < this.productos.length; i++) {
    this.informacion.total +=
      this.productos[i].cantidad * this.productos[i].precio;
  }
};

factura.muestraTotal = function () {
  this.calculaTotal();
  alert("La venta total es de  = " + this.informacion.total + " euros");
};
console.log(factura);

factura.muestraTotal();
