// Dado los siguientes numeros:

let num1 = 43
let num2 = 78
let num3 = 14

// Crea un algoritmo que te permita identificar el numero mayor. Utiliza condicionales como el if() else{}, o if() else if(). Escribe tu código debajo de estas lineas, y observa los resultados por la consola. Especificamente para este conjunto de datos deberias ver por consola el numero 78, adicional, cambia los valores de num1, num2 y num3 para verificar que tu algoritmo funcione con cualquiera 3 valores.

// Solución 1
num1 > num2
  ? num1 > num3
    ? console.log(`${num1} es el mayor de ${num1}, ${num2} y ${num3}`)
    : console.log(`${num3} es el mayor de ${num1}, ${num2} y ${num3}`)
  : num2 > num3
    ? console.log(`${num2} es el mayor de ${num1}, ${num2} y ${num3}`)
    : console.log(`${num3} es el mayor de ${num1}, ${num2} y ${num3}`)

// Solución 2 => A partir de la "optimización" de la solución anterior
num1 > num2 && num1 > num3
  ? console.log(`${num1} es el mayor de ${num1}, ${num2} y ${num3}`)
  : num2 > num3
    ? console.log(`${num2} es el mayor de ${num1}, ${num2} y ${num3}`)
    : console.log(`${num3} es el mayor de ${num1}, ${num2} y ${num3}`)