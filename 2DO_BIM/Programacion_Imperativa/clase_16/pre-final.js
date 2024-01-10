// *************** PRE - EXAMEN FINAL ***************

// ========== EJERCICIO Nº1 ==========

//Dada la matriz 3x3
let matriz = [
  [5, 2, 2], // 0
  [2, 5, 2], // 1
  [4, 4, 5], // 2
]

// 1) Crear una función que reciba la matriz por parámetro, sume todos los valores de primer diagonal  y retorne la suma.
const addDiagonal = arr => {
  let sum = 0
  for(let i = 0; i < arr.length; i++) { sum += arr[i][i] }
  return sum
}
console.log(addDiagonal(matriz))

// 2) Crear una función que reciba la matriz generada por parámetro y retorne un nuevo array con todos los valores pares de la matriz.
const evenNums = arr => {
  const even = []
  for(let i = 0; i < arr.length; i++) {
    for(let j = 0; j < arr[i].length; j++) { arr[i][j] % 2 === 0 ? even.push(arr[i][j]) : even }
  }
  return even
}
console.log(evenNums(matriz))


// ========== EJERCICIO Nº2 ==========

// Dado el siguiente arreglo de objetos:
let cuadros = [
  {
    nombre: "Mona Lisa",
    creador: "Leonardo Da Vinci",
  },
  {
    nombre: "La ultima cena",
    creador: "Leonardo Da Vinci",
  },
  {
    nombre: "La noche estrellada",
    creador: "Vincent van Gogh",
  },
  {
    nombre: "El grito",
    creador: "Edvard Munch",
  },
  {
    nombre: "Trigal con cuervos",
    creador: "Vincent van Gogh",
  },
  {
    nombre: "Maria Magdalena",
    creador: "Leonardo Da Vinci",
  },
  {
    nombre: "Amor y Dolor",
    creador: "Edvard Munch",
  },
  {
    nombre: "Ansiedad",
    creador: "Edvard Munch",
  },
]

// 1) Realizar una función llamada filtrarPorCreador que reciba por parámetro el array y el nombre de un artista. Nuestra función deberá retornar un nuevo array que contenga los nombres de las obras de arte que ha realizado el creador recibido por parámetro. Por ejemplo, si se envía por parámetro: (cuadros, “Leonardo Da Vinci”). Nuestra función deberá retornar: ("Mona Lisa", "La ultima cena", "Maria Magdalena")
const filtrarPorCreador = (arr, name) => {
  artworkByName = []
  arr && name
    ? arr.forEach( obj => obj.creador === name ? artworkByName.push(obj.nombre) : artworkByName )
    : console.log(`Upsss!!! Parece que faltan datos, intenta nuevamente`)
  return artworkByName
}
let artistName = "Leonardo Da Vinci"
console.log(filtrarPorCreador(cuadros, artistName))
artistName = "Edvard Munch"
console.log(filtrarPorCreador(cuadros, artistName))

// ========== EJERCICIO Nº3 ==========

// Realizar una función que mediante el algoritmo de ordenamiento bubbleSort:
// 1) Indique si el arreglo de objetos del EJERCICIO Nº2 se encuentra ordenado alfabéticamente según su creador o no.
// 2) Si está ordenado deberá retornar true. Si no lo está, deberá ordenarlo.
const ascendOrder = arr => {
  let isOrdered = true
  for(let i = 0; i - arr.length -1; i++) {
    for(j = 0; j < arr.length - 1 - i; j++) {
      if(arr[j].creador > arr[j + 1].creador) {
        isOrdered = false
        let aux = arr[j]
        arr[j] = arr[j + 1]
        arr[j + 1] = aux
      }
    }
  }
  if(!isOrdered) { return arr } else { return isOrdered }
  
}

// 3) Realizar el correspondiente llamado a esta función para demostrar su correcto funcionamiento.
// Verificamos el array original que no está ordenado y el retorno del array ordenado
console.log(`Verificamos el array original (que no está ordenado) y el retorno del array ordenado`)
const isOrdered = ascendOrder(cuadros)
console.log(isOrdered)
console.log(`Verificamos un array (que sí está ordenado) y que la función retorne "true"`)
const orderedArray = isOrdered
console.log(ascendOrder(orderedArray))


// ========== EJERCICIO Nº4 ==========

// Desarrollar una función para cada uno de las siguientes apartados: 
// 1) Que reciba por parámetro un número entero y retorne su triple.
const triple = num => num * 3
let a = 3
let b = 5
console.log(`El triple de ${a} es: ${triple(a)}`)
a = 12
console.log(`El triple de ${a} es: ${triple(a)}`)
a = 4
console.log(`El triple de ${a} es: ${triple(a)}`)

// 2) Que reciba por parámetro dos números enteros y retorne la multiplicación de ambos.
const product = (num1, num2) => num1 * num2
console.log(`El producto de ${a} x ${b} es: ${product(a, b)}`)
a = 8
b = 12
console.log(`El producto de ${a} x ${b} es: ${product(a, b)}`)
a = 13
b = 4
console.log(`El producto de ${a} x ${b} es: ${product(a, b)}`)

// 3) Que reciba por parámetro dos números enteros, verificar que sean distintos de 0 y retorne la división de ambos. 
const quotient = (num1, num2) => {
  if(num1 !== 0 && num2 !== 0) { return num1 / num2 }
  else {return `ERROR!!! Los números deben ser distintos de CERO, intenta nuevamente` }
}
console.log(`El cociente de ${a} entre ${b} es: ${quotient(a, b)}`)
a = 4
b = 9
console.log(`El cociente de ${a} entre ${b} es: ${quotient(a, b)}`)
a = 4
b = 0
console.log(`El cociente de ${a} entre ${b} es: ${quotient(a, b)}`)
a = 0
b = 7
console.log(`El cociente de ${a} entre ${b} es: ${quotient(a, b)}`)

// ========== EJERCICIO Nº5 ==========
// Crear una matriz de 5 x 7.
let matrix = [
  [54, 65, 12, 82, 98, 56, 15],
  [95, 25, 98, 24, 15, 69, 34],
  [12, 57, 81, 39, 65, 52, 84],
  [22, 55, 88, 99, 77, 66, 33],
  [30, 50, 80, 90, 70, 10, 40],
]

// Crear una función que reciba la matriz generada por parámetro, sume todos los valores de la fila 4 y retorne la suma.
const addRowfour = arr => {
  let sum = 0
  for(let i = 0; i < arr[3].length; i++) { sum += arr[3][i] }
  return sum
}
console.log(addRowfour(matrix))


// ========== EJERCICIO Nº6 ==========

// Dado el siguiente arreglo de objetos: 
let personas = [
  {
      nombre : "Lucia",
      oficio : "Medica",
      edad : 37
  },
  {
      nombre : "Tiziano",
      oficio : "Programador",
      edad : 9
  },
  {
      nombre : "Julian",
      oficio : "Chofer",
      edad : 45
  },
  {
      nombre : "Adriana",
      oficio : "Chef",
      edad : 24
  },
]
// 1) Realizar una función que reciba un array como parámetro, y lo recorra para filtrar las personas cuya edad sea mayor a 25. La función deberá retornar un nuevo arreglo con las personas que cumplan con la condición antes mencionada.
const filterByAge = arr => {
  let filteredArr = []
  arr.forEach(obj => obj.edad > 25 ? filteredArr.push(obj) : filteredArr )
  return filteredArr
}

// 2) Ejecutar el correspondiente llamado a la función realizada en el inciso anterior para mostrar su correcto funcionamiento.
console.log(filterByAge(personas))