// ############### Ejercicios ###############

// A partir de el siguiente array de edades nos solicitan realizar lo siguiente:
const edades = [11, 12, 15, 18, 25, 22, 10, 33, 18, 5]

// ===== Arrays de prueba =====
const edadesGrupo1 = [21, 12, 15, 18, 25]
const edadesGrupo2 = [2, 11, 54, 63, 24]


// Obtener en un nuevo array las edades menores a 18.
const menoresDeEdad = arr => {
  const menorEdad = []
  for(i = 0; i < arr.length; i++) {
    if(arr[i] < 18) menorEdad.push(arr[i])
  }
  return menorEdad
}
console.log(menoresDeEdad(edades))
console.log(menoresDeEdad(edadesGrupo1))
console.log(menoresDeEdad(edadesGrupo2))

// Obtener en un nuevo array las edades mayor o igual a 18.
const mayoresDeEdad = arr => {
  const mayorEdad = []
  for(i = 0; i < arr.length; i++) {
    if(arr[i] >= 18) mayorEdad.push(arr[i])
  }
  return mayorEdad
}
console.log(mayoresDeEdad(edades))
console.log(mayoresDeEdad(edadesGrupo1))
console.log(mayoresDeEdad(edadesGrupo2))

// Obtener en un nuevo array las edades igual a 18.
const edadDeMayoria = arr => {
  const edadMayoria = []
  for(i = 0; i < arr.length; i++) {
    if(arr[i] === 18) edadMayoria.push(arr[i])
  }
  if(edadMayoria.length > 0) return edadMayoria
  else return "No se encontraron edades iguales a 18 años"
}
console.log(edadDeMayoria(edades))
console.log(edadDeMayoria(edadesGrupo1))
console.log(edadDeMayoria(edadesGrupo2))

// Obtener el menor.
const edadMinima = arr => {
  let menor = 0
  for(let i = 0; i < arr.length; i++) {
    let num = arr[i]
    i === 0
      ? menor = num
      : num < menor
        ? menor = num
        : menor
  }
  return menor
}

console.log(edadMinima(edades))
console.log(edadMinima(edadesGrupo1))
console.log(edadMinima(edadesGrupo2))

// Obtener el mayor. 
const edadMaxima = arr => {
  let mayor = 0
  for(let i = 0; i < arr.length; i++) {
    let num = arr[i]
    i === 0
      ? mayor = num
      : num > mayor
        ? mayor = num
        : mayor
  }
  return mayor
}
console.log(edadMaxima(edades))
console.log(edadMaxima(edadesGrupo1))
console.log(edadMaxima(edadesGrupo2))

// Obtener el promedio de edades.
const promedioEdades = arr => {
  let suma = arr.reduce((acum, current) => acum + current)
  let promedio = suma / arr.length
  return promedio
}
console.log(promedioEdades(edades))
console.log(promedioEdades(edadesGrupo1))
console.log(promedioEdades(edadesGrupo2))

// Incrementar en 1 todas las edades.
const incrementarEdad = arr => arr.map(num => num += 1)
console.log(incrementarEdad(edades))
console.log(incrementarEdad(edadesGrupo1))
console.log(incrementarEdad(edadesGrupo2))


// Tenemos como base un array de cuentas bancarias, donde a cada una la representamos con un objeto literal. A partir de este array trabajaremos sobre los siguientes enunciados, resolviendo de la forma que nos parezca más adecuada
const arrayCuentas =
[
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
    estaHabilitada: true,
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

// Obtener un nuevo array de cuentas cuyas edades sean menores a 30.
const edadesMenores = (arr, max) => {
  const menores = arr.filter(obj => obj.edadTitular < max)
  return menores
}
console.log(edadesMenores(arrayCuentas, 30))

// Obtener un nuevo array de cuentas cuyas edades sean mayor o igual a 30.
const edadesMayoresIguales = (arr, min) => {
  const mayoresIguales = arr.filter(obj => obj.edadTitular >= min)
  return mayoresIguales
}
console.log(edadesMayoresIguales(arrayCuentas, 30))

// Obtener un nuevo array de cuentas cuyas edades sean menores o igual a 30.
const edadesMenoresIguales = (arr, min) => {
  const menoresIguales = arr.filter(obj => obj.edadTitular <= min)
  return menoresIguales
}
console.log(edadesMenoresIguales(arrayCuentas, 30))

// Obtener la cuenta con el titular de la misma más joven.
const masJoven = arr => {
  let menor = 0
  for(let i = 0; i < arr.length; i++) {
    let num = arr[i].edadTitular
    i === 0
      ? menor = num
      : num < menor
        ? menor = num
        : menor
  }
  const cuentaMasJoven = arr.filter(obj => obj.edadTitular === menor)
  return cuentaMasJoven
}
console.log(masJoven(arrayCuentas))

// Obtener un array con las cuentas habilitadas.
const cuentaHabilitada = arr => {
  const conCuentaHabilitada = arr.filter(obj => obj.estaHabilitada)
  return conCuentaHabilitada
}
console.log(cuentaHabilitada(arrayCuentas))

// Obtener un array con las cuentas deshabilitadas.
const cuentaDeshabilitada = arr => {
  const conCuentaDeshabilitada = arr.filter(obj => !obj.estaHabilitada)
  return conCuentaDeshabilitada
}
console.log(cuentaDeshabilitada(arrayCuentas))

// Obtener la cuenta con el menor saldo.
const menorSaldo = arr => {
  let menor = 0
  for(let i = 0; i < arr.length; i++) {
    let num = arr[i].saldo
    i === 0
      ? menor = num
      : num < menor
        ? menor = num
        : menor
  }
  const cuentaMenorSaldo = arr.filter(obj => obj.saldo === menor)
  return cuentaMenorSaldo
}
console.log(menorSaldo(arrayCuentas))

// Obtener la cuenta con el mayor saldo.
const mayorSaldo = arr => {
  let mayor = 0
  for(let i = 0; i < arr.length; i++) {
    let num = arr[i].saldo
    i === 0
      ? mayor = num
      : num > mayor
        ? mayor = num
        : mayor
  }
  const cuentaMayorSaldo = arr.filter(obj => obj.saldo === mayor)
  return cuentaMayorSaldo
}
console.log(mayorSaldo(arrayCuentas))