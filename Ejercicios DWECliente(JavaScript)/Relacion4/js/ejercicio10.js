class Pelicula {
  PATRON_IDPELICULA = /^(\D{2})(?=\d{7})/;
  PATRON_PUNTUACION = /^(\d+)\.(?=\d)/;

  GENERO = `Action, Adult, Adventure, Animation, Biography, Comedy,
  Crime, Documentary ,Drama, Family, Fantasy, 
  Film Noir, Game-Show, History, Horror, Musical, 
  Music, Mystery, News, Reality-TV, Romance, Sci-Fi, 
  Short, Sport, Talk-Show, Thriller, War, Western`
    .trim()
    .split(","); // dividir espacios de texto en arrays

  constructor(idPelicula, titulo, director, año, pais, genero, calificacion) {
    this.idPelicula = idPelicula;
    this.titulo = titulo;
    this.director = director;
    this.año = año;
    this.pais = pais;
    this.genero = genero;
    this.calificacion = calificacion;

    if (idPelicula.length != 9)
      return console.error("IdPelicula debe tener 9 caracteres.");

    if (!this.PATRON_IDPELICULA.test(idPelicula))
      return console.error(
        `idPelicula incorrecto : 9 caracteres, 2 letras 7 números.\nEje: AA1234567`
      );

    if (titulo.length > 100)
      return console.error(`Titulos contiene mas de 100 caracteres.`);

    if (año.length < 1900 || año.length > 3000)
      return console.error("Fecha incorrecta");

    if (!pais instanceof Array)
      return console.error("Separe los paises con coma.");

    if (genero instanceof Array)
      return console.error("Separe los generos con coma");
  }

  fichaTecnica() {
    return ` 
    idPelicula: ${this.idPelicula};
    Titulo: ${this.titulo};
    Director: ${this.director};
    Estreno: ${this.año};
    Pais: ${this.pais};
    Genero: ${this.genero};
    Calificación: ${this.calificacion}`;
  }
};

const Pelicula1 = new Pelicula("AA1234567","AVENGERS: ENDGAME","Juan fr",2019,"EEUU","Sci-Fi",8.7);
const Pelicula2 = new Pelicula("AA1234568","Harry Potter y la Piedra Filosofal","Chris Columbus",2001,"EEUU","Sci-Fi",8.4);
const Pelicula3 = new Pelicula("AA1234569","Star-Wars: El Imperio Contrataca","George Lucas",1995,"EEUU","Sci-Fi",8.1);


console.log(Pelicula1.fichaTecnica());
console.log(Pelicula2.fichaTecnica());
console.log(Pelicula3.fichaTecnica());
