// ########################################################
// ############### Descripción del problema ###############
// ########################################################

// Desde un banco nos contactan para crear una aplicación que pueda facilitar el manejo de información y las acciones que el mismo necesita. Nuestro tech leader nos facilita la forma de representar a los usuarios (cuentas bancarias). Cada una de estas cuentas tiene la siguiente información:

// ● N.o de cuenta (solo números).
// ● Tipo de cuenta (cuenta corriente en pesos o caja de ahorro en pesos).
// ● Saldo en pesos (solo la cantidad).
// ● Titular de la cuenta (nombre completo).
// Teniendo en cuenta esta información, se nos pide que hagamos lo siguiente:

// 1. Considerar la siguiente lista de clientes (cuentas bancarias).
let arrayCuentas = [
  {
    nroCuenta: 5486273622,
    tipoDeCuenta: "Cuenta Corriente",
    saldoEnPesos: 27771,
    titularCuenta: "Abigael Natte",
  },
  {
    nroCuenta: 1183971869,
    tipoDeCuenta: "Caja de Ahorro",
    saldoEnPesos: 8675,
    titularCuenta: "Ramon Connell",
  },
  {
    nroCuenta: 9582019689,
    tipoDeCuenta: "Caja de Ahorro",
    saldoEnPesos: 27363,
    titularCuenta: "Jarret Lafuente",
  },
  {
    nroCuenta: 1761924656,
    tipoDeCuenta: "Cuenta Corriente",
    saldoEnPesos: 32415,
    titularCuenta: "Ansel Ardley",
  },
  {
    nroCuenta: 7401971607,
    tipoDeCuenta: "Cuenta Unica",
    saldoEnPesos: 18789,
    titularCuenta: "Jacki Shurmer",
  },
]

// 2. Crear un objeto literal llamado “banco”, el cual tendrá una propiedad llamada “clientes” que estará compuesta de la lista de objetos obtenidos en el punto anterior.
const banco = {
  clientes: [
    { nroCuenta: 5486273622, tipoDeCuenta: "Cuenta Corriente", saldoEnPesos: 27771, titularCuenta: "Abigael Natte", },
    { nroCuenta: 1183971869, tipoDeCuenta: "Caja de Ahorro", saldoEnPesos: 8675, titularCuenta: "Ramon Connell", },
    { nroCuenta: 9582019689, tipoDeCuenta: "Caja de Ahorro", saldoEnPesos: 27363, titularCuenta: "Jarret Lafuente", },
    { nroCuenta: 1761924656, tipoDeCuenta: "Cuenta Corriente", saldoEnPesos: 32415, titularCuenta: "Ansel Ardley", },
    { nroCuenta: 7401971607, tipoDeCuenta: "Cuenta Unica", saldoEnPesos: 18789, titularCuenta: "Jacki Shurmer", }
  ],
  
  // 3. Al objeto “banco”, crearle un método llamado consultarCliente, el cual recibirá un nombre (titular) por parámetro, deberá buscarlo en la lista de cuentas y retornar el objeto cliente que corresponda con ese nombre ingresado.
  consultarCliente: function(titular) {
    let success = false
    let details = {}
    for(i = 0; i < this.clientes.length; i++) {
      if(this.clientes[i].titularCuenta === titular) {
        details = this.clientes[i]
        success = true
      }
    }
    if(success) return details
    else return `${titular} no se encuentra en nuestros registros...`
  },

  // 4. Crear otro método llamado depósito que recibirá dos parámetros: el titular de cuenta y una cantidad de dinero a depositar. El método debe obtener la cuenta correspondiente y luego sumar la cantidad de dinero a depositar a saldo en pesos. Luego, deberá dar un aviso por la consola con el mensaje “Depósito realizado, su nuevo saldo es: XXXX”.
  deposito: function(titular, amount) {
    let details = this.consultarCliente(titular)
    if(details.titularCuenta === titular) {
      details.saldoEnPesos += parseInt(amount)
      console.log(`Depósito realizado a la cuenta de ${titular}, su nuevo saldo es: $${details.saldoEnPesos}`)
    } else return console.log(`${titular} no se encuentra en nuestros registros...`)
  },
  
  // 5. Crear un último método llamado extracción que recibirá también dos parámetros: el titular de cuenta y el monto a extraer. El método debe obtener la cuenta correspondiente y restar el monto al saldo actual. En caso de que el resultado sea menor a 0, deberá imprimir un mensaje por la consola de “Fondos insuficientes”. De lo contrario, deberá imprimir “Extracción realizada correctamente, su nuevo saldo es: XXXX”.
  extraccion: function(titular, amount) {
    let details = this.consultarCliente(titular)
    if(details.titularCuenta === titular) {
      if(parseInt(amount) <= details.saldoEnPesos) {
        let saldoInicial = details.saldoEnPesos
        details.saldoEnPesos -= parseInt(amount)
        console.log(`Retiro de cuenta: ${titular}, saldo anterior: ${saldoInicial}, retiro de: ${amount}, nuevo saldo: ${details.saldoEnPesos}`)
      } else { console.log(`Fondos insuficientes, saldo: ${details.saldoEnPesos}, cantidad a retirar: ${amount}`) }
    } else return console.log(`${titular} no se encuentra en nuestros registros...`)
  }
}

// ===== 3 =====
// Ayuda: let clienteEncontrado = banco.consultarCliente(“Ramon Connell”)
console.log(`========== EJERCICIO 3 ==========`)
let clienteEncontrado = banco.consultarCliente("Ramon Connell")
console.log(clienteEncontrado)
clienteEncontrado = banco.consultarCliente("John Doe")
console.log(clienteEncontrado)

// ===== 4 =====
console.log(`\n========== EJERCICIO 4 ==========`)
banco.deposito("Ramon Connell", 500)
banco.deposito("Elena Doe", 1000)

// ===== 5 =====
console.log(`\n========== EJERCICIO 5 ==========`)
banco.extraccion("Jacki Shurmer", 500)
banco.extraccion("Tom Doe", 600)
banco.extraccion("Abigael Natte", 27771)
banco.extraccion("Jarret Lafuente", 27364)