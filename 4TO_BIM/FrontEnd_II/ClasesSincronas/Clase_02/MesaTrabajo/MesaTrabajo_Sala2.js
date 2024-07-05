/* -------------------------------------------------------------------------- */
/*                                  FUNCIÓN 2                                 */
/* -------------------------------------------------------------------------- */
// 👇 Esta función nos devuelve 1, 2 o 3 según la elección del usuario.
// Hasta que el usuario ingrese un dato válido le seguimos pidiendo que elija.

function getUserChoice() {
  // empezamos con la variable elección en 0
  let userChoice = 0

  do {
      // Pedimos que elija una opción válida
      // Convertimos el texto que nos llega en un número y reemplazamos en valor guardado en la variable
      userChoice = parseInt(prompt("Ingrese para jugar: 1(piedra), 2(papel) o 3(tijera)"))

      // Si el dato ingresado no es válido entonces se vuelve a pedir hasta que cumpla
  } while (isNaN(userChoice) || userChoice < 1 || userChoice > 3)

  // mostramos los datos por consola
  console.log("----------------------------")
  console.log("La elección del jugador es:")
  console.log(userChoice)
  console.log("----------------------------")

  // Finalmente devolvemos el valor de la elección
  return userChoice
}

/* -------------------------------------------------------------------------- */
/*                                  FUNCIÓN 3                                 */
/* -------------------------------------------------------------------------- */
function getPCChoice() {
  let randomNum = parseInt(Math.random() * 3 + 1)

  // Mostramos los datos por consola
  console.log("----------------------------")
  console.log("La computadora saca:")
  console.log(randomNum)
  console.log("----------------------------")

  // Finalmente devolvemos el valor de la elección aleatoria
  return randomNum
}

/* -------------------------------------------------------------------------- */
/*                                  FUNCIÓN 4                                 */
/* -------------------------------------------------------------------------- */
// 👇 Esta función nos devuelve el resultado de la partida según las elecciones.
// Comparamos la elección de cada uno para saber quien pierde y quien gana.

function compareChoices() {
  const POSSIBLE_RESULTS = ['¡Genial, ganaste!', 'Esto fue un empate.', 'Una lástima, perdiste.']

  let userChoice = getUserChoice()
  let pcChoice = getPCChoice()

  // 👇 Por defecto el jugador gana
  let roundResult = POSSIBLE_RESULTS[0]

  // 👇 Chequeamos el caso en que empata
  if (userChoice === pcChoice) {
      roundResult = POSSIBLE_RESULTS[1]

      // 👇 Chequeamos los posibles casos en que pierde, sino ya sabemos que ganó
  } else if ((userChoice === 1 && pcChoice === 2) || (userChoice === 2 && pcChoice === 3) || (userChoice === 3 && pcChoice === 1)) {
      roundResult = POSSIBLE_RESULTS[2]
  }

  // Devolvemos la frase con el resultado de la partida
  return roundResult
}

const gameResult = compareChoices()

/* -------------------------------------------------------------------------- */
/*                          CONSIGNA MESA DE TRABAJO                          */
/* -------------------------------------------------------------------------- */

// 1- Crear una función que reciba como parámetro un texto (la frase de resultado de la partida).
const showResults = result => {
  // 2- La función debe mostrar por consola el resultado de la partida.
  console.log(result)
  // 3- A su vez debe mostrar al usuario una alerta con el resultado de la partida.
  alert(result)
  // 4- Finalmente, si el resultado fue una derrota debe mostrarle al usuario un mensaje de aliento para desearle suerte en la próxima oportunidad.
  if(result === "Una lástima, perdiste.") { alert("¡Suerte en la próxima!") }
}

showResults(gameResult)