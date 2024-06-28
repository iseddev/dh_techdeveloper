/* -------------------------------------------------------------------------- */
/*                                  FUNCIÓN 2                                 */
/* -------------------------------------------------------------------------- */
// 👇 Esta función nos devuelve 1, 2 o 3 según la elección del usuario.
// Hasta que el usuario ingrese un dato válido le seguimos pidiendo que elija.

function pedirJugada() {
  // empezamos con la variable elección en 0
  let eleccion = 0;

  do {
      // Pedimos que elija una opción válida
      // Convertimos el texto que nos llega en un número y reemplazamos en valor guardado en la variable
      eleccion = parseInt(prompt("Ingrese para jugar: 1(piedra), 2(papel) o 3(tijera)"));

      // Si el dato ingresado no es válido entonces se vuelve a pedir hasta que cumpla
  } while (isNaN(eleccion) || eleccion < 1 || eleccion > 3)

  // mostramos los datos por consola
  console.log("----------------------------");
  console.log("La eleccion del jugador es:")
  console.log(eleccion);
  console.log("----------------------------");

  // Finalmente devolvemos el valor de la eleccion
  return eleccion;
}

/* -------------------------------------------------------------------------- */
/*                                  FUNCIÓN 3                                 */
/* -------------------------------------------------------------------------- */
function jugadaRandom() {
  let numero = parseInt(Math.random() * 3 + 1);

  // Mostramos los datos por consola
  console.log("----------------------------");
  console.log("La computadora saca:")
  console.log(numero);
  console.log("----------------------------");

  // Finalmente devolvemos el valor de la eleccion aleatoria
  return numero;
}



/* -------------------------------------------------------------------------- */
/*                                  FUNCIÓN 4                                 */
/* -------------------------------------------------------------------------- */
// 👇 Esta función nos devuelve el resultado de la partida según las elecciones.
// Comparamos la eleccion de cada uno para saber quien pierde y quien gana.

function compararJugadas() {
  const RESULTADOS_POSIBLES = ['¡Genial, ganaste!', 'Esto fue un empate.', 'Una lástima, perdiste.'];

  const eleccionJugador = pedirJugada();
  const eleccionComputadora = jugadaRandom();

  // 👇 Por defecto el jugador gana
  let resultadoRonda = RESULTADOS_POSIBLES[0];

  // 👇 Chequeamos el caso en que empata
  if (eleccionJugador === eleccionComputadora) {
      resultadoRonda = RESULTADOS_POSIBLES[1];

      // 👇 Chequeamos los posibles casos en que pierde, sino ya sabemos que ganó
  } else if ((eleccionJugador === 1 && eleccionComputadora === 2) || (eleccionJugador === 2 && eleccionComputadora === 3) || (eleccionJugador === 3 && eleccionComputadora === 1)) {
      resultadoRonda = RESULTADOS_POSIBLES[2];
  }

  // Devolvemos la frase con el resultado de la partida
  return resultadoRonda;
}

const resultadoDePartida = compararJugadas()

/* -------------------------------------------------------------------------- */
/*                          CONSIGNA MESA DE TRABAJO                          */
/* -------------------------------------------------------------------------- */

// 1- Crear una función que reciba como parámetro un texto (la frase de resultado de la partida).
const mostrarResultado = (resultado) => {
  // 2- La función debe mostrar por consola el resultado de la partida.
  console.log(resultado)
  // 3- A su vez debe mostrar al usuario una alerta con el resultado de la partida.
  alert(resultado)
  // 4- Finalmente, si el resultado fue una derrota debe mostrarle al usuario un mensaje de aliento para desearle suerte en la próxima oportunidad.
  if(resultado === "Una lástima, perdiste.") { alert("¡Suerte en la próxima!") }
}

mostrarResultado(resultadoDePartida)