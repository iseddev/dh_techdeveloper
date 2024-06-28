/*
##### Objetivo #####
Aplicar las estructuras de JavaScript para repasar y fijar la sintaxis del lenguaje.

** Micro desafío I **
Escribir un programa que realice una búsqueda dentro de un archivo JSON de acuerdo a los siguientes requerimientos. Este archivo JSON (https://drive.google.com/file/d/1ilZN5q6QP1pLUIbFruVX7Rje6JSly9df/view?usp=sharing) será utilizado como base de esta función, el mismo se obtiene como resultado de la siguiente API: https://pokeapi.co/api/v2/ability/

1. Se debe cargar el archivo JSON que se obtiene como respuesta de la API mencionada anteriormente.
2. Realizar una función que reciba como parámetro el “name” del pokemon a buscar.
3. En el caso de encontrar el pokemon, debe mostrar un mensaje de éxito y la url correspondiente.
4. En el caso de no encontrar el pokemon, se debe informar con un mensaje de advertencia.
5. Desarrollar la función como una función declarada.
6. Realizar una mejora en la función utilizando el método find de arreglos y una arrow function.

>> Ayuda 1: Les dejamos un link (https://www.w3schools.com/js/js_array_iteration.asp) donde se explica cómo implementar el método find de arreglos.
>> Ayuda 2: Para importar un archivo se puede utilizar la función require() 
>> Ayuda 3: Les dejamos un link(https://www.w3schools.com/js/js_json.asp) donde pueden ver cómo trabajar con archivos JSON.
*/

// Importar archivo JSON
const pokemonData = require("./pokemonData.json")

// Función declarada
function findPokemon(name) {
  // Verificamos que se haya ingresado por lo menos un valor
  if(name !== undefined) {
    // Verificamos que el valor ingresado sea un string no vacío
    if(name !== null && name !== "" && typeof name === "string") {
      // Buscamos el nombre del pokemon en el registro
      let pokemon = pokemonData.results.find(pokemon => pokemon.name === name.toLowerCase())
      // Si encontramos el nombre del pokemon, retornamos un mensaje de éxito
      if(pokemon) return `ÉXITO: "${pokemon.name}" SI está en el registro.\nURL : ${pokemon.url}`
      // Si NO encontramos el nombre del pokemon, retornamos un mensaje de error
      return `ERROR: "${name}" NO está en el registro.`
    }
    // Si el valor ingresado NO es un string no vacío, retornamos un mensaje de error
    return `ERROR: "${name}" No es un tipo de dato válido.`
  }
  // Si no se ingresó ningún valor, retornamos un mensaje de error
  return "ERROR: NO se ingresó ningún valor."
}
console.log("##################################################")
console.log(findPokemon("damp"))
console.log("##################################################")
console.log(findPokemon("john"))
console.log("##################################################")
console.log(findPokemon(""))
console.log("##################################################")
console.log(findPokemon(0))
console.log("##################################################")
console.log(findPokemon())


// Arrow function
const findPokemonArrow = name => {
  let res = ""
  if(name !== undefined) {
    if(name !== null && name !== "" && typeof name === "string") {
      let pokemon = pokemonData.results.find(pokemon => pokemon.name === name.toLowerCase())
      pokemon
        ? res = `ÉXITO: "${pokemon.name}" SI está en el registro.\nURL : ${pokemon.url}`
        : res =  `ERROR: "${name}" NO está en el registro.`
    } else { res =  `ERROR: "${name}" No es un tipo de dato válido.` }
  } else { res = "ERROR: NO se ingresó ningún valor." }
  return res
}
console.log("##################################################")
console.log(findPokemonArrow("drizzle"))
console.log("##################################################")
console.log(findPokemonArrow("doe"))
console.log("##################################################")
console.log(findPokemonArrow(""))
console.log("##################################################")
console.log(findPokemonArrow(5))
console.log("##################################################")
console.log(findPokemonArrow())