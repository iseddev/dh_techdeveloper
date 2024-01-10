// ############### Ejercicio 1 ###############
// Dado el siguiente array de paises
const paises = [
  {
  nombre: "Argentina",
  continente: "Sudamérica",
  poblacion: 40000000
  },
  {
  nombre: "Colombia",
  continente: "Sudamérica",
  poblacion: 50372000
  },
  {
  nombre: "Brasil",
  continente: "Sudamérica",
  poblacion: 300000000
  },
  {
  nombre: "Etiopía",
  continente: "África",
  poblacion: 15000000
  },
  {
  nombre: "Chile",
  continente: "Sudamérica",
  poblacion: 10000000
  }
]

// Crear una función que reciba como parámetro él arreglo de objetos, un continente, y un número de población.
// La misma debe retornar un nuevo arreglo solo con los países que sean del continente pasado por parámetro, y además, que su población sea mayor o igual a la del parámetro.
// Si no encuentra coincidencias deberá retornar un array vacío

const selectCountries = (arr = null, continent = null, population = null) => {
  if(arr && continent && population) {
    let upperContinent = continent.toUpperCase()
    const selectedCountries = []
    arr.forEach(obj => {
      obj.continente.toUpperCase() === upperContinent && obj.poblacion >= population
        ? selectedCountries.push(obj)
        : selectedCountries
    })
    return selectedCountries
  } else {return "Error en alguno de los datos ingresdos, intenta nuevamente..."}
}

console.log(paises)
let filteredCountries = selectCountries(paises) // Solo se pasa el array => ERROR
console.log(filteredCountries)
filteredCountries = selectCountries(paises, "sudamerica") // Se pasa arra y pais en minúsculas => ERROR
console.log(filteredCountries)
filteredCountries = selectCountries(paises, "Sudamérica") // Se pasa array y pais sin población => ERROR
console.log(filteredCountries)
filteredCountries = selectCountries(paises, "sudamérica", 25000000) // Se pasan los datos correctos => CORRECTO
console.log(filteredCountries)


// ############### Ejercicio 2 ###############
// Dado el siguiente array de numeros :
const arrayDeNumeros = [1,2,3, 8, 9, 104, 5, 6, 7, 15]

const bubbleAsc = arr => {
  const iterations = arr.length - 1
  for (let i = 0; i < iterations; i++) {
    for (let j = 0; j < iterations - i; j++) {
      if (arr[j] > arr[j + 1]) {
        let aux = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = aux;
      }
    }
  }
  return arr
}

const bubbleDesc = arr => {
  const iterations = arr.length - 1
  for (let i = 0; i < iterations; i++) {
    for (let j = 0; j < iterations - i; j++) {
      if (arr[j] < arr[j + 1]) {
        let aux = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = aux;
      }
    }
  }
  return arr
}

// Crear una función llamada bubbleSort que reciba como parámetros el array y un string que represente el sentido de ordenamiento, la función deberá realizar un ordenamiento interno del array según el orden indicado
// ● “ASC” lo ordenará ascendente
// ● “DESC” lo ordenará descendente
// Para analizar el correcto funcionamiento imprimir por consola el array antes y después de ejecutar la función.
const bubbleSort = (arr = null, ordering = null) => {
  let orderedArr = []
  if(arr && ordering) {
    let upperOrdering = ordering.toUpperCase()
    upperOrdering === "ASC"
      ? orderedArr = bubbleAsc(arr)
      : upperOrdering === "DESC"
        ? orderedArr = bubbleDesc(arr)
        : orderedArr
  } else { return "Error en los datos ingresados, verifica e intenta nuevamente..." }
  return orderedArr
}

console.log(bubbleSort(arrayDeNumeros)) // Sólo se ingresa 1 parámetro => ERROR
console.log("\nOrden ASCENDENTE")
console.log(bubbleSort(arrayDeNumeros, "asc")) // Se ingresan los dos parámetros
console.log("\nOrden DESCENDENTE")
console.log(bubbleSort(arrayDeNumeros, "desc")) // Se ingresan los dos parámetros


// ############### Ejercicio 3 ###############
// Dada la matriz
let matriz = [
  [5, 2, 2], // 0
  [2, 5, 2], // 1
  [4, 4, 5], // 2
]
// a. Crear una función que reciba la matriz por parámetro, sume todos los valores de la fila 1 y retorne la suma.
const addRowOne = arr => {
  let row = 1
  let sum = 0
  arr[row - 1].forEach(num => sum += num)
  return sum
}
console.log("\nSuma de todos los numeros de la primera fila")
console.log(addRowOne(matriz))

// b. Crear una función que reciba la matriz generada por parámetro y retorne un nuevo array con todos los valores pares de la matriz.
const selectEvenNums = arr => {
  const evenNums = []
  for(let i = 0; i < arr.length; i++) {
    for(let j = 0; j < arr[i].length; j++) {
      arr[i][j] % 2 === 0 ? evenNums.push(arr[i][j]) : evenNums
    }
  }
  return evenNums
}
console.log("\nArray de sólo números pares")
console.log(selectEvenNums(matriz))