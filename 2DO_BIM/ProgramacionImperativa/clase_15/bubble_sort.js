// ***** Algoritmo Bubble Sort *****
// También llamado “ordenación por burbuja”, con este algoritmo podremos ordenar una lista de elementos en un array, según un valor numérico, de menor a mayor, o viceversa.
// En primer lugar, entenderemos cómo funciona el algoritmo y, luego, discutiremos casos de usos en la vida real.
// Para comprender cómo funciona, y cómo se escribe Bubble Sort, asumamos una lista de números enteros y positivos.
// const nums = [6,5,1,2,4,3,8,7]

// Escribamos el algoritmo Bubble Sort para ordenar estos números de menor a mayor, y obtener la secuencia 1,2,3,4,5,6,7,8. A nivel general este algoritmo va a querer “interrogar” todos los números del array, ya veremos cuál en un momento. Para la iteración, utilizaremos un ciclo for, que vaya desde el primer elemento del array, hasta el último.
// for(let i=0; i<numeros.length; i++) {
// }

// La “pregunta” que Bubble Sort hace es la siguiente: empezando desde el primer número del array, preguntar al siguiente número si es mayor y, de ser así, cambiar posiciones. Caso contrario, pasar al siguiente número y hacer la misma pregunta.

// Una primera iteración por cada número no nos garantiza que ya los números están ordenados, por lo que vamos a tener que repetir este proceso, no solamente empezando desde el primer elemento del array, sino desde todos los números, menos el último. Para esto, vamos a tener que utilizar un ciclo dentro de un ciclo, o un doble for.

// for (let i = 0; i < numeros.length; i++) {
//   for (let j = 0; j < numeros.length - 1; j++) {
//   }
// }

// El último paso del algoritmo Bubble Sort nos indica que hagamos una pregunta lógica, estando en el for interno: ¿es el siguiente número de la lista, mayor que el actual (sobre el que se está iterando)? Si es así, intercambiamos posiciones, y repitamos esto hasta el final del array. Al terminar, pasemos al segundo número del array y volvamos a hacer todo de nuevo. En código, esto se ve así:

// for (let i = 0; i < numeros.length; i++) {
//   for (let j = 0; j < numeros.length; j++) {
//     if (numeros[j] > numeros[j + 1]) {
//       let temp = numeros[j];
//       numeros[j] = numeros[j + 1];
//       numeros[j + 1] = temp;
//     }
//   }
// }


// ===== Ejecución de este algoritmo =====

const nums = [14,6,10,5,1,11,15,2,12,0,4,3,13,8,7]

// Forma ascendente (menor a mayor)
const orderAscendNums = arr => {
  const iterations = arr.length - 1
  for (let i = 0; i < iterations; i++) {
    console.log(`===== INICIO ITERACIÓN: ${i + 1} =====`)
    for (let j = 0; j < iterations - i; j++) {
      console.log(`Comparación(${j + 1} de ${iterations - i}): ${arr[j]} > ${arr[j + 1]}`)
      if (arr[j] > arr[j + 1]) {
        console.log(`VERDADERO => Intercambio: ${arr[j]} X ${arr[j + 1]}`)
        let aux = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = aux;
      }
    }
    console.log(`===== FIN ITERACIÓN: ${i + 1} =====\n`)
  }
  return arr
}
console.log(nums)
console.log(orderAscendNums(nums))

// Forma descendente (mayor a menor)
const orderDescendNums = arr => {
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
console.log(orderDescendNums(nums))