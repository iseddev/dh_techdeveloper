// =============== Ejercicio 1 ===============
// En un concurso de fotografía, donde los usuarios publican una fotografía y obtienen likes, se registra la cantidad de likes obtenidos por cada usuario en un array. Ordenar los valores para poder indicar cuál fue la mayor cantidad de likes obtenidos, cuánto obtuvo el segundo, cuánto el tercero y cuánto el que menos likes obtuvo —suponer que participaron 15 usuarios y suponer para cada uno, una cantidad de likes—.
const likesByPlayer =[321, 658, 248, 548, 658, 125, 721, 430, 821, 269, 687, 523, 199, 713, 384]

const ascendOrder = arr => {
  for(let i = 0; i - arr.length -1; i++) {
    for(j = 0; j < arr.length - 1 - i; j++) {
      if(arr[j] > arr[j + 1]) {
        let aux = arr[j]
        arr[j] = arr[j + 1]
        arr[j + 1] = aux
      }
    }
  }
  return arr
}

const orderedLikes = ascendOrder(likesByPlayer)
console.log(orderedLikes)
console.log(`El primer lugar obtuvo: ${orderedLikes[orderedLikes.length - 1]} likes`)
console.log(`El segundo lugar obtuvo: ${orderedLikes[orderedLikes.length - 2]} likes`)
console.log(`El tercer lugar obtuvo: ${orderedLikes[orderedLikes.length - 3]} likes`)


// =============== Ejercicio 2 ===============
// El servicio meteorológico, para llevar el control diario de temperatura, utiliza un objeto temperatura donde registra día —valor numérico del día—, mes —valor numérico—, temperatura máxima y temperatura mínima, correspondiente a dicho día. Las temperaturas —objeto temperatura— están cargados en un array.
const temperatureRecords = [
  {
    day: 1,
    month: 2,
    maxTemperature: 32,
    minTemperature: 16,
  },
  {
    day: 2,
    month: 2,
    maxTemperature: 35,
    minTemperature: 10,
  },
  {
    day: 3,
    month: 2,
    maxTemperature: 30,
    minTemperature: 11,
  },
  {
    day: 4,
    month: 2,
    maxTemperature: 31,
    minTemperature: 15,
  },
  {
    day: 5,
    month: 2,
    maxTemperature: 37,
    minTemperature: 19,
  },
  {
    day: 6,
    month: 2,
    maxTemperature: 36,
    minTemperature: 12,
  },
  {
    day: 7,
    month: 2,
    maxTemperature: 33,
    minTemperature: 17,
  },
  {
    day: 8,
    month: 2,
    maxTemperature: 39,
    minTemperature: 13,
  },
  {
    day: 9,
    month: 2,
    maxTemperature: 38,
    minTemperature: 14,
  },
  {
    day: 10,
    month: 2,
    maxTemperature: 34,
    minTemperature: 18,
  },
  {
    day: 11,
    month: 2,
    maxTemperature: 36,
    minTemperature: 20,
  },
  {
    day: 12,
    month: 2,
    maxTemperature: 38,
    minTemperature: 13,
  },
  {
    day: 13,
    month: 2,
    maxTemperature: 35,
    minTemperature: 19,
  },
  {
    day: 14,
    month: 2,
    maxTemperature: 31,
    minTemperature: 14,
  },
]

// a) Ordenar por temperatura mínima de menor a mayor.
const ascendTemperatures = arr => {
  for(let i = 0; i - arr.length -1; i++) {
    for(j = 0; j < arr.length - 1 - i; j++) {
      if(arr[j].minTemperature > arr[j + 1].minTemperature) {
        let aux = arr[j]
        arr[j] = arr[j + 1]
        arr[j + 1] = aux
      }
    }
  }
  return arr
}
console.log(ascendTemperatures(temperatureRecords))

// b) Ordenar por temperatura máxima de mayor a menor.
const descendTemperatures = arr => {
  for(let i = 0; i - arr.length -1; i++) {
    for(j = 0; j < arr.length - 1 - i; j++) {
      if(arr[j].maxTemperature < arr[j + 1].maxTemperature) {
        let aux = arr[j]
        arr[j] = arr[j + 1]
        arr[j + 1] = aux
      }
    }
  }
  return arr
}
console.log(descendTemperatures(temperatureRecords))
