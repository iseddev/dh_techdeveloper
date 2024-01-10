// Ahora bien. dado los siguientes numeros:

let num1 = 13
let num2 = 1663
let num3 = 3363
// agrega una variable mas, llamada num4
// con un valor numerico
let num4 = 4316

// Crea un algoritmo que te permita identificar el numero mayor de los 4 anteriores.

// Escribe tu código debajo de esta linea, y observa los resultados por la consola. Adicional, cambia los valores de los 4 numeros para ver que algoritmo funciona con cualquier conjunto de 4 numeros.

// Solución
num1 > num2 && num1 > num3 && num1 > num4
  ? console.log(`${num1} es el mayor de ${num1}, ${num2}, ${num3} y ${num4}`)
  : num2 > num3 && num2 > num4
    ? console.log(`${num2} es el mayor de ${num1}, ${num2}, ${num3} y ${num4}`)
    : num3 > num4
      ? console.log(`${num3} es el mayor de ${num1}, ${num2}, ${num3} y ${num4}`)
      : console.log(`${num4} es el mayor de ${num1}, ${num2}, ${num3} y ${num4}`)