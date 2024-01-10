const prompt = require("prompt-sync")({ sigint: true })

// Tomémonos un rato para armar las variables del juego de Mario y de una Persona. Recuerden guardar los dos como archivos separados en la carpeta correspondiente.

// ********** VARIABLES MARIO **********

// Variable de puntos (debajo de la palabra Mario)
let points = 0

// Cantidad de monedas
let coins = 0

// Número de nivel
let level = 1

// Número de mundo
let world = 1

// *=*=*=* Tiempo inicial de juego *=*=*=*
let initialTime = 10000
// *=*=*=* Contador de tiempo transcurrido *=*=*=*
let counterTime = 0
// Tiempo restante para terminar el nivel
let remainingTime = initialTime - counterTime

// *=*=*=* Contidad de vidas iniciales *=*=*=*
let initialLives = 3
// *=*=*=* Contador de vidas perdidas *=*=*=*
let lostLives = 0

// Aunque en esta pantalla no la veamos, también tenemos una variable que indica la cantidad de vidas restantes
let remainingLives = initialLives - lostLives

// *=*=*=* Bloque tipo ladrillo *=*=*=*
let isBrickBlock = true
// *=*=*=* Bloque tipo acero *=*=*=*
let isSteelBlock = true
// *=*=*=* Bloque tipo misterioso *=*=*=*
let isMisteriousBlock = true

// Cada bloque misterioso tiene una cantidad de monedas, esa cantidad está guardada en una variable. ¿Qué le pasará a la variable cada vez que Mario golpee el bloque? (Dato de color, Mario le pega con el puño, no con la cabeza)
let isHitMisteriousBlock = true
let misteriousBlockCoins = 10
let hitMisteriousBlock = 0;
let misterousBlockCoinsRemaining = misteriousBlockCoins - hitMisteriousBlock

// Si hilamos fino, podríamos pensar que el estado de Mario puede almacenarse en una variable. ¿Es grande Mario? En el caso de que la variable esté en “Verdadero” (porque tocó un hongo) cuando toque a algún enemigo no pierde vida, sino que cambia su estado a pequeño
let isBig = false
let hitMushroom = true
let hitEnemy = false

// ¿Identificas alguna variable más que nosotros no hayamos tenido en cuenta?
let clouds = 2
let enemies = 3
let isEnemy = true
let isMushroom = true

// Solicitar que el usuario ingrese su nombre utilizando el prompt. Imprimilo en consola mostrando la etiqueta “Nombre:” seguida del valor ingresado por ejemplo “Nombre: Juan”
let userName = prompt("Ingresa tu nombre por favor: ")
console.log("Nombre: " + userName)

// Imprimir en consola la comparación de nuestra variable cantidad de vidas restante con el valor 0
console.log("Se tienen vidas aún?", remainingLives > 0)

// Descontar una vida a esa variable y volver a imprimir la comparación, además del nuevo valor de la variable.
remainingLives = remainingLives - 1
console.log("Se tienen vidas aún?", remainingLives > 0)
console.log("Vidas restantes:", remainingLives)