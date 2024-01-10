/*
 * Extra: ¿Qué puedes hacer para identificar el numero mayor de una lista de numeros, como la siguiente? Utiliza Javascript.
 *
 * Tip: es valido buscar en google :)
 *
 * Adicional: al terminar tu algoritmo, cambia los valores de la lista, bien sea agregando o removiendo, y asegurate que tu algoritmo funcione con cualquier lista de números.
 */

let numeros = [5, 12, 2, 40, 33, 2, 8]
// numeros = [85, 12, 2, 40, 33, 2, 8]
// numeros = [5, 120, 2, 40, 33, 2, 8]
// numeros = [5, 12, 276, 40, 33, 2, 8]
// numeros = [5, 12, 2, 40, 330, 2, 8]
// numeros = [5, 12, 2, 40, 33, 290, 8]
// numeros = [5, 12, 2, 40, 33, 2, 843]

// Solución 1
console.log(`Números: ${numeros}`)

let ascendentes = [numeros[0]]
for(let i = 0; i < numeros.length - 1; i++) {
  ascendentes[i] > numeros[i + 1]
    ? ascendentes.unshift(numeros[i + 1])
    : ascendentes.push(numeros[i + 1])
}
let numeroMayor1 = ascendentes[ascendentes.length - 1]
console.log(`Ascendentes: ${ascendentes}`)
console.log("Número mayor 1:", numeroMayor1)

// Solución 2 => Considerando "mejoras" del código anterior y aplicando recomendaciones obtenidas de consultas en la web
let numeroMayor2 = 0
numeros.forEach(num => numeroMayor2 < num ? numeroMayor2 = num : numeroMayor2)
console.log("Número mayor 2:", numeroMayor2)
