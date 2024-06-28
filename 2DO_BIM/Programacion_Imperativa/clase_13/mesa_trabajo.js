// 1) Escribir un programa que muestre en pantalla los números del 1 al 100, sustituyendo los múltiplos de 3 por la palabra “fizz”, los múltiplos de 5 por “buzz” y los múltiplos de ambos, es decir, los múltiplos de 3 y 5 —o de 15—, por la palabra “fizzbuzz”. Visiten este sandbox https://codesandbox.io/s/fizzbuzz-3e9uc?file=/src/index.js para realizar el ejercicio ahí. Recuerden desplegar la consola para ver sus resultados, y utilicen la función console.log para mostrar datos en la misma.
for(let i = 1; i <= 100; i++) {
  i % 15 === 0
    ? console.log(`fizzbuzz`)
    : i % 5 === 0
      ? console.log(`buzz`)
      : i % 3 === 0
        ? console.log(`fizz`)
        : console.log(i)
}

// 2) Escriban una función que reciba dos parámetros: un array y un índice. La función deberá de mostrar por consola el valor del elemento según el índice dado. Por ejemplo, dada la siguiente array e índice, la función imprimirá '6'. let array = [3,6,67,6,23,11,100,8,93,0,17,24,7,1,33,45,28,33,23,12,99,100]; var index = 1; Visiten este sandbox para escribir su código. https://codesandbox.io/s/busqueda-en-array-025me?file=/src/index.js
const showItem = (arr, index) => console.log(arr[index])
const array = [3,6,67,6,23,11,100,8,93,0,17,24,7,1,33,45,28,33,23,12,99,100]
let i = 1
showItem(array, i)
i = 10
showItem(array, i)

// 3) Escribir una función que, dado un número de mes, devuelva la cantidad de días de ese mes —suponiendo que no es un año bisiesto—. https://codesandbox.io/s/dias-del-mes-jb0f2?file=/src/index.js
const daysInMonth = num => {
  let daysInMonth = 0
  num >= 1 && num <= 12
    ? num !== 2
      ? (num <= 7 && num % 2 !== 0) || (num >= 8 && num % 2 === 0)
        ? daysInMonth = 31
        :(num <= 6 && num % 2 === 0) || (num >= 9 && num % 2 !== 0)
          ? daysInMonth = 30
          : null
      : daysInMonth = 28
    : null
  return daysInMonth
}
for(let i = 1; i <= 12; i++) { console.log(`Mes ${i} tiene: ${daysInMonth(i)} dias`) }

// 4) Escribir una función de JavaScript que invierta un número. Por ejemplo, si x = 32443, la salida debería ser 34423. https://codesandbox.io/s/inverter-jfwm7?file=/src/index.js
const reverseNumber = num => {
  let invertedNumber = 0
  do {
    invertedNumber = invertedNumber * 10 + (num % 10)
    num = Math.floor(num / 10)
  } while(num > 0)
  return invertedNumber
}
console.log(reverseNumber(32443))
console.log(reverseNumber(951753))
console.log(reverseNumber(986532))

// 5) Escribir una función que reciba una array y solo imprima los valores que se repiten. Por ejemplo, dada la siguiente array e índice, la función imprimirá '6,23,33,100'. let array = [3,6,67,6,23,11,100,8,93,0,17,24,7,1,33,45,28,33,23,12,99,100]; https://codesandbox.io/s/impresora-repitientes-qtz0e?file=/src/index.js
const repeatedValues = arr => {
  let repeatedNums = []
  let num = 0
  for(let i = 0; i < arr.length; i++) {
    num = arr[i]
    for(let j = (i + 1); j < arr.length; j++) {
      num === arr[j] ? repeatedNums.push(num) : repeatedNums
    }
  }
  console.log(repeatedNums)
}
let nums = [3,6,67,6,23,11,100,8,93,0,17,24,7,1,33,45,28,33,23,12,99,100]
repeatedValues(nums)