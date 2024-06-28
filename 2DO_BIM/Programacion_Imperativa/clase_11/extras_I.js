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

// ############### Extras: ###############
// Desarrollar una función llamada generarID que reciba como parámetro el array de cuentas y agregue a cada elemento (objeto literal) una propiedad llamada id con un valor Numérico
console.log(arrayCuentas)

const generarID = arr => {
  let id = 0
  let incrementador = 159
  const cuentasConID = []
  arr.forEach(obj => {
    obj.id = (id + incrementador) * (incrementador + 123)
    cuentasConID.push(obj)
    incrementador++
  })
  return cuentasConID
}

const arrayCuentasID = generarID(arrayCuentas)

console.log(arrayCuentasID)

// Desarrollar una función llamada buscarPorId que reciba como parámetro el array de cuentas y un id, en caso de encontrar retornar la cuenta (él objeto literal completo), caso contrario retornar null
const buscarPorID = (arr, ID) => {
  let resultado = null
  arr.forEach(obj => obj.id === ID ? resultado = obj : resultado)
  return resultado
}
let cuentaPorID = buscarPorID(arrayCuentasID, 45724)
console.log(cuentaPorID)
cuentaPorID = buscarPorID(arrayCuentasID, 45725)
console.log(cuentaPorID)

// Desarrollar una función llamada filtrarPorSaldos que reciba como parámetro el array de cuentas y un saldo (Number), deberá retornar un array que se cuyas cuentas se encuentren por debajo del saldo enviado por parámetro
const filtrarPorSaldos = (arr, saldo) => {
  const filtradasPorSaldo = []
  arr.forEach(obj => {
    obj.saldo < saldo ? filtradasPorSaldo.push(obj) : filtrarPorSaldos
  })
  return filtradasPorSaldo
}
cuentasFiltradasPorSaldo = filtrarPorSaldos(arrayCuentasID, 2000)
console.log(cuentasFiltradasPorSaldo)

// Desarrollar una función llamada incrementarSaldo que reciba como parámetro el array de cuentas, un id y un saldo, deberá incrementar él saldo de la cuenta, en caso de encontrar, caso contrario retornar undefined
// Reutilizando la función  buscarPorId

const incrementarSaldo = (arr, ID, saldo) => {
  cuentaEncontrada = buscarPorID(arr, ID)
  cuentaEncontrada ? cuentaEncontrada.saldo += saldo : cuentaEncontrada = undefined
  return cuentaEncontrada
}
let cuentaIncrementada = incrementarSaldo(arrayCuentasID, 45724, 600)
console.log(cuentaIncrementada)
cuentaIncrementada = incrementarSaldo(arrayCuentasID, 45725, 600)
console.log(cuentaIncrementada)