// ###################################################
// ########## ¿Qué devuelven estos códigos? ##########
// ###################################################
// En este ejercicio deberás pensar qué devuelven estos códigos sin probarlos en la consola.

// let numbers =[22, 33, 54, 66, 72]
// console.log(numbers[numbers.length]) ==> devuelve: 5

// let grupoDeAmigos = [ "Harry", "Ron", "Hermione", "Spiderman", "Hulk", "Ironman","Penélope Glamour", "Pierre Nodoyuna","Patán" ]
// console.log(grupoDeAmigos[5]) ==> devuelve: "Ironman"

// let str = "un string cualquiera"
// let arrayAleatorio= ["Digital", "House", "true", "string", "123","false", "54", str ]
// console.log(arrayAleatorio[arrayAleatorio.length - 1]) devuelve ==> "un string cualquiera"



// #########################################################
// ########## Colecciones de películas (y más...) ##########
// #########################################################

// El tech leader del equipo necesita conocer la estructura de datos del nuevo proyecto. Para esto, deberás:

// 1. Crear la estructura adecuada para guardar las siguientes películas: "star wars", "totoro", "rocky", "pulp fiction", "la vida es bella"
const movies = ["star wars", "totoro", "rocky", "pulp fiction", "la vida es bella"]

// Importante: verificá que todo funciona correctamente accediendo a alguna de las películas una vez creada la estructura correspondiente.
for(i = 0; i < movies.length; i++) console.log(movies[i])


// 2. Más tarde, de producción dieron el aviso de que las películas deberían estar todas en mayúsculas. Para esto solicitan que crees una función que reciba por parámetro un array y convierta el contenido de cada elemento a mayúsculas.
// Pista: revisá qué hace el método de strings .toUpperCase().
const upperCaseArr = arr => {
  for(i = 0; i < arr.length; i++){
    arr[i] = arr[i].toUpperCase()
  }
  return arr
}
console.log(upperCaseArr(movies))


// 3. Mientras trabajabas en el feature anterior, se dio el aviso de que también hay que crear otra estructura similar a la primera, pero con las siguientes películas animadas: "toy story", "finding Nemo", "kung-fu panda", "wally", "fortnite"
// Por lo tanto, te piden crear una función que reciba dos arrays como parámetros, para poder agregar los elementos contenidos en el segundo array dentro del primero, y así retornar un solo array con todas las películas como sus elementos.
// Importante: las películas animadas también deberían convertirse a mayúsculas. 
const animatedMovies = ["toy story", "finding Nemo", "kung-fu panda", "wally", "fortnite"]
const insertArr = (arr1, arr2) => {
  for(i = 0; i < arr2.length; i++) arr1.push(arr2[i])
  const upperArr1 = upperCaseArr(arr1)
  return upperArr1
}
const mergedMovies = insertArr(movies, animatedMovies)
console.log(mergedMovies)


// 4. Durante el proceso, uno de los desarrolladores advierte que el último elemento del array de películas animadas es un videojuego. Ahora tenés que editar el código y modificarlo de manera que puedas eliminar ese último elemento antes de migrar el contenido al array que contenga todas las películas.
// PD: por precaución, guardá el elemento que vas a eliminar en una variable.
let deletedElement = mergedMovies.pop()
console.log(deletedElement)
console.log(mergedMovies)


// 5. Finalmente, te envían dos arrays con calificaciones que hacen distintos usuarios del mundo sobre las películas con el siguiente formato:
// const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
// const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];
// Te piden crear una función que compare las calificaciones e indique si son iguales o diferentes. Te confirman que están en el orden adecuado y que solo traen valores numéricos del 1 al 10.
// PD: los elementos de los scores tanto de Asia como de Europa corresponden en orden al del array resultante de combinar películas con películas animadas. Es decir, el primer elemento del array de películas general corresponde al primer elemento de asiaScores y al primer elemento de euroScores, y así sucesivamente.
const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];

const contrastRating = (arr1, arr2) => {
  const contrastedRating = []
  if(arr1.length === arr2.length) {
    for(i = 0; i < arr1.length; i++) {
      if(arr1[i] === arr2[i]) contrastedRating.push("iguales")
      else contrastedRating.push("diferentes")
    }
    return contrastedRating
  } else console.log("Ups!!! Los arrays son de diferente longitud, revisa e intenta nuevamente")
}
const contrastedRate = contrastRating(asiaScores, euroScores)
console.log(contrastedRate)
for(i = 0; i < asiaScores.length; i++) console.log(`Las calificaciones de la pelicula ${i + 1} son: ${contrastedRate[i].toUpperCase()}`)


// #################################
// ########## Extra bonus ##########
// #################################

// ===== Array inverso =====
// En este ejercicio deberás crear una función que devuelva un array con sus elementos invertidos, sin modificarlo. Luego, deberás hacer una función que lo modifique e invierta el orden de sus elementos.
// 1. Creá la función imprimirInverso que tome un array como argumento y que imprima en la consola cada elemento en orden inverso (no tenés que invertir el array).
const imprimirInverso = arr => {
  for(i = 0; i < arr.length; i++) console.log(arr[arr.length - (i + 1)])
}
console.log(movies)
imprimirInverso(movies)

// 2. Creá la función inversor que tome un array como argumento y devuelva uno nuevo invertido.
const inversor = arr => {
  let inversedArr = []
  for(i = 0; i < arr.length; i++) inversedArr.push(arr[arr.length - (i + 1)])
  return inversedArr
}
console.log(mergedMovies)
console.log(inversor(mergedMovies))


// ===== sumaArray() =====
// En este ejercicio, deberás crear una función sumaArray() que acepte un arreglo de números (3 elementos) y devuelva la suma de todos ellos. Ejemplo:
// ● sumArray([1,2,3]) // 6
// ● sumArray([10, 3, 10]) // 23
// ● sumArray([-5,100, 19]) // 114
const sumaArray = arr => {
  let sum = 0
  for(i = 0; i < arr.length; i++) sum += arr[i]
  console.log(sum)
}
sumaArray([1,2,3]) // 6
sumaArray([10, 3, 10]) // 23
sumaArray([-5,100, 19]) // 114


// ===== Simulación Array.join() =====
// En este ejercicio deberás crear una función llamada join() que reciba un arreglo de strings de 4 elementos y simule el comportamiento del método Array.join().
// Importante: no podés usar el método Array.join() original.
// Ejemplo:
// ● join(["h","o","l","a"]) debe retornar el string "hola".
// ● join(["c","h","a,"u"]) debe retornar el string "chau".
const join = arr => {
  let joinedStr = ""
  for(i = 0; i < arr.length; i++) joinedStr += arr[i]
  console.log(typeof joinedStr)
  console.log(joinedStr)
}
join(["h", "o", "l", "a"]) // debe retornar el string "hola".
join(["c", "h", "a", "u"]) // debe retornar el string "chau".