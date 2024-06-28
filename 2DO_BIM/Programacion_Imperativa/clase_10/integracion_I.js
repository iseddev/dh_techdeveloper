// #######################################################
// ############### ¡Preparando el cerebro! ###############
// #######################################################

// ********** Loop de pares **********
// Deberás crear una función llamada loopDePares que reciba como parámetro un número y haga un loop de 0 a 100 mostrando en la consola cada número del loop. En caso de que el número de la iteración sumado con el número pasado por parámetro sea par, mostrará en la consola: “El número X es par”.
const loopDePares = num => {
  for(i = 0; i <= 100; i++) {
    console.log(`Número: ${i}`)
    if((i + num) % 2 === 0) console.log(`El numero ${i + num} es par`)
  }
}
// loopDePares(7)
// loopDePares(13)
// loopDePares(24)


// ********** Loop de impares con palabra **********
// Deberás crear una función llamada loopDeImpares que reciba como parámetros un número y una palabra, y haga un loop de 0 a 100 mostrando en la consola cada número del loop. Luego, modificar el código para que, en caso de que ese número sumado con el número pasado por parámetro sea impar, muestre en la consola la palabra pasada por parámetro.
const loopDeImpares = (num, word) => {
  for(i = 0; i <= 100; i++) {
    console.log(`Número: ${i}`)
    if((i + num) % 2 !== 0) console.log(`${i + num} impar => ${word}`)
  }
}
// loopDeImpares(7, "hola")
// loopDeImpares(13, "mundo")
// loopDeImpares(24, "javascript")


// ********** Sumatoria **********
// Deberás crear una función llamada sumatoria que reciba un número como parámetro y que devuelva la sumatoria de todos sus números anteriores, incluso ese mismo. Ejemplo:
// sumatoria(3) debe retornar 6 porque hace (1+2+3)
// sumatoria(8) debe retornar 36
const sumatoria = num => {
  sum = 0
  for(i = 1; i <= num; i++) {
    sum += i;
  }
  console.log(sum)
}
// sumatoria(5)
// sumatoria(10)
// sumatoria(23)


// ********** Nuevo arreglo **********
// Deberás crear una función llamada nuevoArreglo que reciba un número como parámetro y que devuelva un nuevo arreglo con tantos elementos como el número que le hayas pasado. Ejemplo:
// nuevoArreglo(5) debe retornar [1,2,3,4,5]
// nuevoArreglo(10) debe retornar [1,2,3,4,5,6,7,8,9,10]
const nuevoArreglo = num => {
  const arr = []
  for(i = 1; i <= num; i++) {
    arr.push(i)
  }
  console.log(arr)
}
// nuevoArreglo(5)
// nuevoArreglo(10)
// nuevoArreglo(23)


// ********** Similar String.split() **********
// Deberás crear una función llamada split que reciba un string y simule el comportamiento de la función original. Si no estás seguro de cómo funciona, Google puede ayudarte. Importante: no podés usar el String.split(). Ejemplo:
// split(“hola”) debe retornar [“h”,”o”,”l”,”a”]
// split(“chau”) debe retornar [“c”,”h”,”a”,”u”]
const split = str => {
  const splited = []
  for(i = 0; i < str.length; i++) {
    splited.push(str[i])
  }
  console.log(splited)
}
// split("hola")
// split("mundo")
// split("javascript")


// ********** Manejando dos arreglos **********
// Deberás crear una función llamada arrayHandler que reciba dos arreglos de igual largo como parámetros y muestre en la consola “Soy {elemento de array 1} y yo soy {elemento de array 2}”. Ejemplo:
// arrayHandler([1,2,3,4], [“h”,”o”,”l”,”a”]) debe mostrar: 
// Soy 1 y yo soy h
// Soy 2 y yo soy o
// Soy 3 y yo soy l
// Soy 4 y yo soy a
const arrayHandler = (arr1, arr2) => {
  for(i = 0; i < arr1.length; i++) {
    console.log(`Soy ${arr1[i]} y yo soy ${arr2[i]}`)
  }
}
// arrayHandler([1, 2, 3, 4], ["h", "o", "l", "a"])


// ********** Palíndromo **********
// Deberás crear una función llamada palindromo que indique si una palabra es palíndroma o no. Debe retornar “true” en caso de que lo sea, y “false” en caso de que no. Ejemplo:
// palindromo(“anilina”) debe retornar true
// palindromo(“Ana”) debe retornar true
// palindromo(“Enrique”) debe retornar false
const palindromo = word => {
  let test = ""
  let lower = word.toLowerCase()
  let i = word.length
  for(i; i > 0; i--) {
    test += lower[i - 1]
  }
  lower === test
    ? console.log(`¿${word} es palíndromo? => true`)
    : console.log(`¿${word} es palíndromo? => false`)
}
palindromo("hola")
palindromo("anilina") // debe retornar true
palindromo("Ana") // debe retornar true
palindromo("Enrique") // debe retornar false