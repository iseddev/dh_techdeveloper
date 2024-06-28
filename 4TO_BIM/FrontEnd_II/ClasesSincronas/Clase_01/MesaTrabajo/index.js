/* -------------------------------------------------------------------------- */
/*                                  FUNCIÓN 1                                 */
/* -------------------------------------------------------------------------- */
/* function iniciarJuego() {

  // Saludamos al usuario
  alert("Bienvenido al piedra papel o tijera de Frontend II.");
  // guardamos en una variable en nombre ingresado
  const nombre = prompt("Ingrese su nombre por favor:")

  alert("Gracias por jugar " + nombre + ". ¡Mucha suerte!");

  // mostramos los datos por consola
  console.log("----------------------------");
  console.log("El jugador es:")
  console.log(nombre);
  console.log("----------------------------");

  return nombre;
}

// creamos una variable a nivel global para guardar el nombre del jugador que nos devuelve la función
const nombreJugador = iniciarJuego(); */

/* -------------------------------------------------------------------------- */
/*                          CONSIGNA MESA DE TRABAJO                          */
/* -------------------------------------------------------------------------- */

function iniciarJuego() {
  
  // Saludamos al usuario
  alert("Bienvenido al piedra papel o tijera de Frontend II.")
  // guardamos en una variable en nombre ingresado
  let nombre = prompt("Ingrese su nombre por favor:")
  
  // 1- Modificar la función de iniciarJuego(), validar si ingresa un dato válido como nombre.
  // 2- Si no ingresa un texto, o tiene menos de 3 caracteres debemos volver a pedir que lo ingrese.
  while (!nombre || nombre.trim().length < 3 || !isNaN(parseInt(nombre))) {
    !nombre
      ? alert("El campo nombre no puede estar vacío")
      : nombre.trim().length < 3
        ? alert("Nombre debe tener al menos 3 caracteres")
        : !isNaN(parseInt(nombre))
          ? alert("El nombre no debe ser un número")
          : alert("Error inesperado")
    nombre = prompt("Ingrese su nombre por favor:")
  }
    
  let nombreFiltrado = nombre.trim().toUpperCase()
  alert("Gracias por jugar " + nombreFiltrado + ". ¡Mucha suerte!");
  
  // Mostramos los datos por consola
  console.log("----------------------------");
  console.log("El jugador es:")
  // 3- Finalmente el nombre devuelto debe estar todo en mayúsculas.
  console.log(nombreFiltrado);
  console.log("----------------------------");

  return nombreFiltrado;
}

// creamos una variable a nivel global para guardar el nombre del jugador que nos devuelve la función
const nombreJugador = iniciarJuego();
