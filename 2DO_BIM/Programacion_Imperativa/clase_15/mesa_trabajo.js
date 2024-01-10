// 1. A partir de él siguiente array de edades nos solicitan realizar lo siguiente
const edades = [33, 27, 34, 30, 34, 25];

// a. Desarrollar una función que ordene internamente de forma ascendente las edades, la misma deberá retornar él array ordenado , es decir deberíamos obtener resultado como él siguiente.
// [25, 27, 30, 33, 34, 34]
const ascend = arr => {
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
console.log(ascend(edades))

// b. Desarrollar una función que ordene internamente de forma descendente las edades, la misma deberá retornar él array ordenado , es decir deberíamos obtener resultado como él siguiente.
// [34, 34, 33, 30, 27, 25]
const descend = arr => {
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
console.log(descend(edades))

// 2. Dado un array de strings:
const letras = ["C", "A", "D", "E", "H", "Z", "J", "L"]

// ¿Cómo pudieras ordenar el array anterior, alfabéticamente?
console.log(ascend(letras))

// 3. A partir del siguiente array de Objetos Literales se solicita realizar lo siguiente:
const arrayCuentas = [
  {
    titular: "Arlene Barr",
    estaHabilitada: false,
    saldo: 3253.40,
    edadTitular: 33,
    tipoCuenta: "sueldo"
  },
  {
    titular: "Roslyn Torres",
    estaHabilitada: false,
    saldo: 3229.45,
    edadTitular: 27,
    tipoCuenta: "sueldo"
  },
  {
    titular: "Cleo Lopez",
    estaHabilitada: true,
    saldo: 1360.19,
    edadTitular: 34,
    tipoCuenta: "corriente"
  },
  {
    titular: "Daniel Malone",
    estaHabilitada: false,
    saldo: 3627.12,
    edadTitular: 30,
    tipoCuenta: "sueldo"
  },
  {
    titular: "Ethel Leon",
    estaHabilitada: true,
    saldo: 1616.52,
    edadTitular: 34,
    tipoCuenta: "sueldo"
  },
  {
    titular: "Harding Mitchell",
    estaHabilitada: true,
    saldo: 1408.68,
    edadTitular: 25,
    tipoCuenta: "corriente"
  }
]

// a. Desarrollar una función que ordene internamente de forma ascendente según él saldo de cada cuenta, la misma deberá retornar él array ordenado.
const ascendByBalance = arr => {
  const iterations = arr.length - 1
  for (let i = 0; i < iterations; i++) {
    for (let j = 0; j < iterations - i; j++) {
      if (arr[j].saldo > arr[j + 1].saldo) {
        let aux = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = aux;
      }
    }
  }
  return arr
}
console.log(ascendByBalance(arrayCuentas))

// b. Desarrollar una función que ordene internamente de forma ascendente según la edad del titular de cada cuenta, la misma deberá retornar él array ordenado.
const ascendByAge = arr => {
  const iterations = arr.length - 1
  for (let i = 0; i < iterations; i++) {
    for (let j = 0; j < iterations - i; j++) {
      if (arr[j].edadTitular > arr[j + 1].edadTitular) {
        let aux = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = aux;
      }
    }
  }
  return arr
}
console.log(ascendByAge(arrayCuentas))