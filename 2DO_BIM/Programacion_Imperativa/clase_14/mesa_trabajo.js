// Vamos a practicar el uso de matrices y, de paso, los ciclos FOR.
// 1) Seguir las instrucciones en este sandbox, para escribir y sumar los valores dentro de una matriz. => https://codesandbox.io/s/mesa-17-ejercicio-1-yh91v?file=/src/index.js
// i. Declara una variable que contenga una matriz de 5X5 llena de puros números enteros y positivos
const vector5 = [[4, 9, 8, 2, 12],
                 [9, 23, 5, 3, 8],
                 [6, 42, 7, 3, 2],
                 [23, 6, 5, 4, 1],
                 [9, 65, 2, 7, 4]] // Resultado esperado de la suma de todos los números: 269

// ii. Luego escribe un algoritmo para sumar todos los números de la matriz
const addArrElements = vector => {
  let sum = 0
  for(let i = 0; i < vector.length; i++) {
    for(let j = 0; j < vector[i].length; j++) { sum += vector[i][j] }
  }
  return sum
}
console.log(addArrElements(vector5)) // Resultado obtenido: 269


// 2) Crear una función que genere una matriz de 10x10. Cada fila debe tener solo 10 números. La matriz debe verse así:
//  1  2  3  4  5  6  7  8  9 10
// 11 12 13 14 15 16 17 18 19 20
// 21 22 23 24 25 26 27 28 29 30
// 31 32 33 34 35 36 37 38 39 40
// 41 42 43 44 45 46 47 48 49 50
// 51 52 53 54 55 56 57 58 59 60
// 61 62 63 64 65 66 67 68 69 70
// 71 72 73 74 75 76 77 78 79 80
// 81 82 83 84 85 86 87 88 89 90
// 91 92 93 94 95 96 97 98 99 100
// https://codesandbox.io/s/mesa-17-ejercicio-2-8glzg?file=/src/index.js
// (i * 10) + (j + 1)
const generarMatriz10por10 = () => {
  let matriz10X10 = []
  for(let i = 0; i < 10; i++) {
    matriz10X10[i] = []
    for(let j = 0; j < 10; j++) { matriz10X10[i][j] = (i * 10) + (j + 1) }
  }
	return matriz10X10;
}
let matriz10por10 = generarMatriz10por10();
console.table(matriz10por10);


// 3) Por último, vamos a generar dos funciones:
// Ambas funciones deben devolver un resultado único: Rojo: 505 / Verde 505

// a) Una va a sumar los valores en la diagonal marcada en rojo.
const addRedDiagonal = arr => {
  let addDiagonal = 0
  for(let i = 0; i < arr.length; i++) { addDiagonal += arr[i][i] }
  return addDiagonal
}
console.log(addRedDiagonal(matriz10por10))

// b) La otra va a marcar los valores de la diagonal marcada en verde.
const addGreenDiagonal = arr => {
  let addDiagonal = 0
  for(let i = arr.length - 1; i >= 0; i--) { addDiagonal += arr[i][i] }
  return addDiagonal
}
console.log(addGreenDiagonal(matriz10por10))
// Trabajar en el mismo sandbox del ejercicio 2.