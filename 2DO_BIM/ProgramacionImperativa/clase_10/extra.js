// Consecutivos similares
// Debes crear una función llamada “consecutivosSimilares” que reciba un string y retorne cuantos consecutivos similares hay en un string. 

// Ejemplo: 
// consecutivosSimilares(“AAAA”) debe retornar 3
// consecutivosSimilares(“BBBBB”) debe retornar 4
// consecutivosSimilares(“ABABABAB”) debe retornar 0
// consecutivosSimilares(“BABABA”) debe retornar 0
// consecutivosSimilares(“AAABBB”) debe retornar 4 /
let consecutivosSimilares = str => {
  let contador = 0
  let consecutivo = ""
  for(i = 0; i < str.length; i++) {
    if(consecutivo === str[i]) contador++
    consecutivo = str[i] // consecutivo = "A"
  }
  return console.log(`${str}, consecutivos: ${contador}`)
}
consecutivosSimilares("AAAA") // debe retornar 3
consecutivosSimilares("BBBBB") // debe retornar 4
consecutivosSimilares("ABABABAB") // debe retornar 0
consecutivosSimilares("BABABA") // debe retornar 0
consecutivosSimilares("AAABBB") // debe retornar 4



// Rotación de arreglo a la derecha
// Debes crear una función llamada “rotar” que reciba un arreglo y un número, y debera retornar un nuevo arreglo con los elementos rotados la cantidad de veces como sea el número a la derecha.
// Ejemplo: 
// rotar([1, 2, 3, 4, 5], 2) debe retornar [4, 5, 1, 2, 3]
// rotar([1, 2, 3, 4, 5], 3) debe retornar [3, 4, 5, 1, 2]
const rotar = (arr, n) => {
  let elements = arr.slice(-n) // nuevo array con los últimos n elementos
  arr.splice(-n, n) // Se eliminan los últimos n elementos
  let rotated = elements.concat(arr) // se concatenan (unen) los dos arrays
  console.log(rotated)
}

rotar([1, 2, 3, 4, 5], 2) // debe retornar [4, 5, 1, 2, 3]
rotar([1, 2, 3, 4, 5], 3) // debe retornar [3, 4, 5, 1, 2]