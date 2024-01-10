//  PRUEBA PARCIAL PROGRAMACIÓN IMPERATIVA ===== NOV-2023 =====


// ********** Ejercicio 1 **********
// Desarrollar una función para el siguiente apartado:
// A. Que reciba por parámetro 2 números, y verifique que si uno de ellos es par, retorne la multiplicación de ambos, si ambos son pares, retorne la suma de ambos, si no hay ninguno par, que retorne ‘ninguno es par ‘.
const isEven = (num1, num2) => {
  let result
  num1 % 2 === 0 && num2 % 2 === 0
    ? result = num1 + num2
    : num1 % 2 === 0 || num2 % 2 === 0
      ? result = num1 * num2
      : result = "Ninguno es par"
  return result
}
// Pruebas
console.log("========== Resultados EJERCICIO 1 ==========")
console.log(isEven(3, 6)) // => 18
console.log(isEven(10, 6)) // => 16
console.log(isEven(3, 7)) // => Ninguno es par


// ********** Ejercicio 2 **********
// 1. Deberás escribir un objeto literal llamado ciclista que contenga las siguientes propiedades que deberás completar con tus datos:
const ciclista = {
  // a. nombre
  nombre: "Israel",
  // b. apellido
  apellido: "Porfirio",
  // c. edad
  edad: 43,
  // d. tiene Bici (TRUE/FALSE)
  tieneBici: true
}
// 2. Teniendo en cuenta los datos del punto número 1.
// a. Crear una función que reciba por parámetro el objeto y retorne un string en base a las siguientes condiciones :
const ableToCompete = obj => {
  // - si no tiene bici “No podrá competir”
  if(!obj.tieneBici) { return "No podrá competir" }
  // - si edad es mayor o igual a 18 y tiene bici “puede competir”
  else if(obj.edad >= 18 && obj.tieneBici) { return "Puede competir"}
  // - si tiene bici y es menor a 18 “podrá competir pero con un adulto acompañante”
  else if(obj.tieneBici && obj.edad < 18) { return "Podrá competir pero con un adulto acompañante" }
}
// *Deberás realizar la invocación de la función de forma que se pueda ver el resultado
console.log("\n========== Resultados EJERCICIO 2 ==========")
console.log(ableToCompete(ciclista)) // => "Puede competir"


// ********** Ejercicio 3 **********
// ● Crear un array vacío, que tenga el nombre libros.
const libros = []

// ● Usando estos 4 objetos:
let historiasInconscientes = {
  anio : 2013,
  autor : "Gabriel Rolón",
  paginas: 352
}
let elAlquimista = {
  anio : 1988,
  autor : "Paulo Coehlo",
  paginas: 192
}
let elCampamento = {
  anio : 2021,
  autor : "Blue Jeans",
  paginas: 480
}
let operacionMasacre = {
  anio: 2009,
  autor: "Rodolfo Walsh",
  paginas: 236
}
// ● Deberás agregarlos al array utilizando un método de array.
libros.push(historiasInconscientes)
libros.push(elAlquimista)
libros.push(elCampamento)
libros.push(operacionMasacre)
// ● Mostrar por consola el array para ver que contenga esos objetos.
console.log("\n========== Resultados EJERCICIO 3 ==========")
console.log(libros)
// ● Deberás crear una función que reciba el array libros como parámetro, y si el año de lanzamiento es anterior a 2020, deberá agregar una propiedad a cada objeto que se llame época y tenga el valor pre-pandemia, si el año es posterior o igual a 2020 el valor de la propiedad época será post-pandemia.
const addEra = arr => {
  arr.forEach(obj => obj.anio >= 2020 ? obj.epoca = "post-pandemia" : obj.epoca = "pre-pandemia" )
}
// ● Ejecutar la función y mostrar por consola los cambios.
addEra(libros)
console.log(libros)