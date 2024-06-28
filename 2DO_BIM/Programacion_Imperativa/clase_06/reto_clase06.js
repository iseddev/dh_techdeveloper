// Sin repetirte, modificá tu código de forma tal que cumpla con estas consignas:
// ● Si la edad es negativa, que se muestre en la consola este mensaje: "Error, edad inválida. Por favor ingrese un número válido."
// Importante: no se deberá mostrar ningún otro mensaje.
// ● Si tiene 21 años, además de darle la bienvenida, felicitarlo por haber llegado a la mayoría de edad.
// ● Si su edad es impar, decirle en cualquiera de los mensajes: "¿Sabías que tu edad es impar?".

let edad = 17

if(edad < 0) {
  console.log("Error, edad inválida. Por favor ingrese un número válido.")
} else if(edad < 18) {
  console.log("No puede pasar al bar.")
} else if (edad < 21){
  console.log("Puede pasar al bar, pero no puede tomar alcohol.")
} else if(edad === 21 || edad % 2 !== 0) {
  if(edad === 21) {
    console.log("Bienvenido y muchas FELICIDADES por haber llegado a la mayoría de edad")
    console.log("¿Sabías que tu edad es impar?")
  } else if(edad > 0 && edad % 2 !== 0){
    console.log("¿Sabías que tu edad es impar?")
  }
}

// ###################################
// ########## totalAPagar() ##########
// ###################################

// Declará una función llamada totalAPagar() que reciba como parámetros: vehiculo y litrosConsumidos.
// A continuación, definí y realizá los cálculos para obtener el total a pagar, teniendo en cuenta las siguientes consideraciones:
// ● Si el vehículo es “coche”, el precio por litro es de $86.
// ● Si es “moto”, ha de ser $70.
// ● Si es “autobús”, ha de ser $55.
// ● Si los litros consumidos están entre 0 y 25, se ha de añadir $50 al total a pagar.
// ● Si los litros consumidos son mayor a 25, se ha de añadir $25 al total a pagar.

const totalAPagar = (tipoVehiculo, litrosConsumidos) => {
  if(litrosConsumidos > 0 && litrosConsumidos <= 25) {
    if(tipoVehiculo === "coche") { return litrosConsumidos * 86 + 50 }
    else if(tipoVehiculo === "moto") { return litrosConsumidos * 70 + 50 }
    else if(tipoVehiculo === "autobus") { return litrosConsumidos * 55 + 50}
  } else {
    if(tipoVehiculo === "coche") { return litrosConsumidos * 86 + 25 }
    else if(tipoVehiculo === "moto") { return litrosConsumidos * 70 + 25 }
    else if(tipoVehiculo === "autobus") { return litrosConsumidos * 55 + 25}
  }
}

let tipoVehiculo = "coche"
let litrosConsumidos = 18
console.log(totalAPagar(tipoVehiculo, litrosConsumidos)) // Resultado esperado: 18*86+50=1598
litrosConsumidos = 30
console.log(totalAPagar(tipoVehiculo, litrosConsumidos)) // Resultado esperado: 30*86+25=2605

tipoVehiculo = "moto"
litrosConsumidos = 18
console.log(totalAPagar(tipoVehiculo, litrosConsumidos)) // Resultado esperado: 18*70+50=1310
litrosConsumidos = 30
console.log(totalAPagar(tipoVehiculo, litrosConsumidos)) // Resultado esperado: 30*70+25=2125

tipoVehiculo = "autobus"
litrosConsumidos = 18
console.log(totalAPagar(tipoVehiculo, litrosConsumidos)) // Resultado esperado: 18*55+50=1040
litrosConsumidos = 30
console.log(totalAPagar(tipoVehiculo, litrosConsumidos)) // Resultado esperado: 30*55+25=1675


// #########################################
// ########## Local de sándwiches ##########
// #########################################

// Necesitamos armar el sistema para un local de venta de sándwiches. Los clientes eligen el sándwich base que tiene un precio y, por cada selección siguiente, se le suma el valor de su selección al precio. Por ejemplo, partiendo de un sándwich base vegetariano con un precio x, después se selecciona pan negro con un precio y, por lo que el total a pagar sería x+y, y así sucesivamente con el resto de los ingredientes.

// Como es un local que ya tenía un sistema previo, ellos ya tienen toda la interfaz donde el usuario elige cada ingrediente, lo que nos facilita el trabajo, ya que nosotros recibiremos los datos de la siguiente manera.

// Nos llega un string indicando el tipo de sándwich base. Estos tienen un valor base diferente por cada selección:

// ● Pollo = $150 (“pollo”)
// ● Carne = $200 (“carne”)
// ● Vegetariano (verduras asadas) = $100 (“veggie”)

// Luego, el sistema pregunta al cliente qué tipo de pan quiere. Tienen para elegir entre otras tres opciones, por lo que recibiremos también otro string con el tipo de pan deseado:

// ● Blanco c/orégano y parmesano = $50 (“blanco”)
// ● Negro c/avena = $60 (“negro”)
// ● Sin gluten = $75 (“s/gluten”)

// Para finalizar, el sistema avanza preguntando al cliente si quiere los siguientes adicionales:

// ● Queso = $20
// ● Tomate = $15
// ● Lechuga = $10
// ● Cebolla = $15
// ● Mayonesa = $5
// ● Mostaza = $5

// Cada uno de estos adicionales están representados por booleanos —es decir, true o false—, dependiendo de si aceptan o no cada uno de los adicionales —nos llegan un total de seis valores booleanos, uno por cada adicional—.

// Nuestro trabajo es crear una función que reciba estos ocho parámetros —un string para el sándwich base, uno para el pan y los seis booleanos de los adicionales—. La función deberá consultar primero qué tipo de sándwich base se seleccionó, luego el tipo de pan, y por último deberá verificar qué adicionales se seleccionaron.

// Finalmente, deberá retornar el valor numérico del total a pagar del cliente.

// ***** base *****
let base = ""
// ***** pan *****
let pan = ""
// ***** adicional *****
// ===== FALSE =====
let queso = false // ($20)
let tomate = false // ($15)
let lechuga = false // ($10)
let cebolla = false // ($15)
let mayonesa = false // ($5)
let mostaza = false // ($5)

const costoTotalSandwich = (base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza) => {
  let adicional = 0
  if(base === "pollo") {
    let costoBase = 150
    if(pan === "blanco") {
      let costoPan = 50
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else if(pan === "negro") {
      let costoPan = 60
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else if(pan === "s/gluten") {
      let costoPan = 75
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else { console.log("Ups!!! Algo salió mal con el tipo de PAN, intenta nuevamente") }
  } else if(base === "carne") {
    let costoBase = 200
    if(pan === "blanco") {
      let costoPan = 50
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else if(pan === "negro") {
      let costoPan = 60
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else if(pan === "s/gluten") {
      let costoPan = 75
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else { console.log("Ups!!! Algo salió mal con el tipo de PAN, intenta nuevamente") }
  } else if(base === "veggie") {
    let costoBase = 100
    if(pan === "blanco") {
      let costoPan = 50
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else if(pan === "negro") {
      let costoPan = 60
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else if(pan === "s/gluten") {
      let costoPan = 75
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }
      return costoBase + costoPan + adicional
    } else { console.log("Ups!!! Algo salió mal con el tipo de PAN, intenta nuevamente") }
  } else { console.log("Ups!!! Algo salió mal para la BASE del sandwich, intenta nuevamente") }
}

// $$$$$ PRUEBA 1 $$$$$
// ***** BASE => pollo($150), carne($200), veggie($100) *****
base = "carne"
// ***** PAN => blanco($50), negro($60), s/gluten($75) *****
pan = "negro"
// ***** ADICIONAL *****
// ===== TRUE =====
// queso = true // ($20)
// tomate = true // ($15)
lechuga = true // ($10)
// cebolla = true // ($15)
mayonesa = true // ($5)
// mostaza = true // ($5)

let totalPagar = costoTotalSandwich(base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza)
console.log("1er total a pagar por el sandwich es: $" + totalPagar) // Esperado: 200+60+10+5=275

// $$$$$ PRUEBA 2 $$$$$
// ***** BASE => pollo($150), carne($200), veggie($100) *****
base = "pollo"
// ***** PAN => blanco($50), negro($60), s/gluten($75) *****
pan = "s/gluten"
// ***** ADICIONAL *****
// ===== TRUE =====
queso = true // ($20)
// tomate = true // ($15)
lechuga = true // ($10)
// cebolla = true // ($15)
mayonesa = true // ($5)
mostaza = true // ($5)

totalPagar = costoTotalSandwich(base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza)
console.log("2do otal a pagar por el sandwich es: $" + totalPagar) // Esperado: 150+75+20+10+5+5=265

// $$$$$ PRUEBA 3 $$$$$
// ***** BASE => pollo($150), carne($200), veggie($100) *****
base = "veggie"
// ***** PAN => blanco($50), negro($60), s/gluten($75) *****
pan = "blanco"
// ***** ADICIONAL *****
// ===== TRUE =====
// queso = true // ($20)
tomate = true // ($15)
lechuga = true // ($10)
cebolla = true // ($15)
mayonesa = true // ($5)
mostaza = true // ($5)

totalPagar = costoTotalSandwich(base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza)
console.log("3er total a pagar por el sandwich es: $" + totalPagar) // Esperado: 100+50+15+10+15+5+5=200

// $$$$$ PRUEBA 4 $$$$$
// ***** BASE => pollo($150), carne($200), veggie($100) *****
base = "carne"
// ***** PAN => blanco($50), negro($60), s/gluten($75) *****
pan = "s/gluten"
// ***** ADICIONAL *****
// ===== TRUE =====
queso = true // ($20)
tomate = true // ($15)
lechuga = true // ($10)
cebolla = true // ($15)
mayonesa = true // ($5)
mostaza = true // ($5)

totalPagar = costoTotalSandwich(base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza)
console.log("4to total a pagar por el sandwich es: $" + totalPagar) // Esperado: 200+75+20+15+10+15+5+5=345

// $$$$$ PRUEBA 5 $$$$$
// ***** BASE => pollo($150), carne($200), veggie($100) *****
base = "veggie"
// ***** PAN => blanco($50), negro($60), s/gluten($75) *****
pan = "blanco"
// ***** ADICIONAL *****
// ===== TRUE =====
queso = false // ($20)
tomate = false // ($15)
lechuga = false // ($10)
cebolla = false // ($15)
mayonesa = false // ($5)
mostaza = false // ($5)

totalPagar = costoTotalSandwich(base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza)
console.log("5to total a pagar por el sandwich es: $" + totalPagar) // Esperado: 100+50=150


// =========================================
//  ===== FUNCION ALTERNA "OPTIMIZADA" =====
// =========================================
const totalPagarSandwich = (base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza) => {

  // Validamos que la base del sandwich este correcta
  if(base === "pollo" || base === "carne" || base === "veggie") {
    
    // Ahora validamos que el tipo de pan para el sandwich este correcto
    if(pan === "blanco" || pan === "negro" || pan === "s/gluten") {

      let costoBase = 0
      let costoPan = 0
      let adicional = 0
      
      // ========== Asignamos el costo de la base en función al tipo de base ingresado ==========
      
      // ***** Uso de if general *****
      // if(base === "pollo") { costoBase = 150 }
      // if(base === "carne") { costoBase = 200 }
      // if(base) { costoBase = 100 } // Por defecto para "VEGGIE" al no encontrar los dos anteriores
      
      // ***** Con operador ternario *****
      base === "pollo"
        ? costoBase = 150
        : base === "carne"
          ? costoBase = 200
          : costoBase = 100
      
      // ========== Asignamos el costo del pan en función al tipo de pan ingresado ==========

      // ***** Uso de if general *****
      // if(pan === "blanco") { costoPan = 50 }
      // if(pan === "negro") { costoPan = 60 }
      // if(pan) { costoPan = 75 }

      // ***** Con operador ternario *****
      pan === "blanco"
        ? costoPan = 50
        : pan === "negro"
          ? costoPan = 60
          : costoPan = 75

      // Ahora podemos sumar todos los adicionales agregados
      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }

      // Retornamos el costo total a pagar por el sandwich
      return costoBase + costoPan + adicional
    } else {
      // Si el tipo de PAN para el sandwich esta mal, mandamos mensaje de error
      console.log("Ups!!! Algo salió mal con el tipo de PAN, intenta nuevamente")
    }
  } else {
    // Si la BASE del sandwich esta mal, mandamos mensaje de error
    console.log("Ups!!! Algo salió mal con la BASE del sandwich, intenta nuevamente")
  }
}

// $$$$$ PRUEBA 6 $$$$$
// ***** BASE => pollo($150), carne($200), veggie($100) *****
base = "pollo"
// ***** PAN => blanco($50), negro($60), s/gluten($75) *****
pan = "negro"
// ***** ADICIONAL *****
// ===== TRUE =====
queso = false // ($20)
tomate = false // ($15)
lechuga = true // ($10)
cebolla = false // ($15)
mayonesa = false // ($5)
mostaza = true // ($5)

totalPagar = totalPagarSandwich(base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza)
console.log("6to total a pagar por el sandwich es: $" + totalPagar) // Esperado: 150+60+10+5=225

/*
###################################################################
########## FUNCION ANTERIOR "OPTIMIZADA" SIN COMENTARIOS ##########
###################################################################

const totalPagarSandwich = (base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza) => {

  if(base === "pollo" || base === "carne" || base === "veggie") {
    if(pan === "blanco" || pan === "negro" || pan === "s/gluten") {
      let costoBase = 0
      let costoPan = 0
      let adicional = 0

      base === "pollo"
        ? costoBase = 150
        : base === "carne"
          ? costoBase = 200
          : costoBase = 100

      pan === "blanco"
        ? costoPan = 50
        : pan === "negro"
          ? costoPan = 60
          : costoPan = 75

      if(queso) { adicional += 20 }
      if(tomate) { adicional += 15 }
      if(lechuga) { adicional += 10 }
      if(cebolla) { adicional += 15 }
      if(mayonesa) { adicional += 5 }
      if(mostaza) { adicional += 5 }

      return costoBase + costoPan + adicional

    } else { console.log("Ups!!! Algo salió mal con el tipo de PAN, intenta nuevamente") }
  } else { console.log("Ups!!! Algo salió mal con la BASE del sandwich, intenta nuevamente") }
}
*/


// #################################################
// ########## ¿Cuál es el número secreto? ##########
// #################################################

// Creá una función que reciba un parámetro numérico y verifique si el mismo es el número secreto. El número secreto deberá ser seleccionado de manera random de entre 1 y 10 —investigá qué hace la función Math.random()—. En caso de ser correcto, retorna un mensaje felicitando al usuario y, en caso de que no acierte, retorna un mensaje de aliento junto con el número ingresado y el secreto.

let userNum = 5

const secretNum = num => {
  let randomNum = Math.floor(Math.random() * 10) + 1
  num === randomNum
    ? console.log(`¡¡¡ Felicidades !!! El ${num} es el número secreto...`)
    : console.log(`Lo sentimos ); número INGRESADO: ${num}, número SECRETO: ${randomNum}, mejor suerte para la próxima...`)
}
secretNum(userNum)


// #######################################
// ########## abrirParacaidas() ##########
// #######################################

// Crea una función llamada abrirParacaidas() que recibe dos parámetros: velocidad y altura. La función deberá decirnos si el paracaídas debe abrirse teniendo en cuenta lo siguiente:
// ● La velocidad debe ser menor a 1000 km/h.
// ● La altura debe ser mayor o igual a 2000 m y menor a 3000 m.

const abrirParacaidas = (velocity, height) => {
  (velocity < 1000 && (height >= 2000 && height < 3000))
    ? console.log("El paracaídas DEBE abrirse")
    : console.log("El paracaídas NO debe abrirse")
}

let velocity = 900
let height = 2200
abrirParacaidas(velocity, height)

velocity = 1000
height = 2200
abrirParacaidas(velocity, height)

velocity = 900
height = 1999
abrirParacaidas(velocity, height)

velocity = 900
height = 3000
abrirParacaidas(velocity, height)


// #######################################
// ########## ESTRUCTURA SWITCH ##########
// #######################################

// ========== Traductor condicional ==========

// Usando la estructura switch, crea un programa en el que si un usuario ingresa "casa", "perro", "pelota", "árbol" o "genio", nos devuelva la misma palabra traducida al idioma inglés.
// En caso de que la palabra sea distinta a la esperada, mostrarle un mensaje que le informe que la palabra ingresada es incorrecta.

const translateWord = word => {
  switch(word) {
    case "casa":
      console.log(`La traducción al inglés de la palabra '${word}' es 'house'`)
      break
    case "perro":
      console.log(`La traducción al inglés de la palabra '${word}' es 'dog'`)
      break
    case "pelota":
      console.log(`La traducción al inglés de la palabra '${word}' es 'ball'`)
      break
    case "árbol":
      console.log(`La traducción al inglés de la palabra '${word}' es 'tree'`)
      break
    case "genio":
      console.log(`La traducción al inglés de la palabra '${word}' es 'genius'`)
      break
    default:
      console.log(`La palabra ingresada '${userWord}' es incorrecta, intenta nevamente...`)
  }
}

let userWord = "casa"
translateWord(userWord)
userWord = "perro"
translateWord(userWord)
userWord = "pelota"
translateWord(userWord)
userWord = "árbol"
translateWord(userWord)
userWord = "genio"
translateWord(userWord)
userWord = "errónea"
translateWord(userWord)


// ========== Valoración de películas ==========

// Usando la estructura switch, pedirle al usuario que valore la película que acaba de ver según la siguiente escala:
// ● Muy mala.
// ● Mala.
// ● Mediocre.
// ● Buena.
// ● Muy buena.
// Acompaña cada valoración con un mensaje que indique si te lamentás o te alegrás por su valoración.
// Por ejemplo: "Calificaste la película como Muy Mala. Lo lamentamos mucho.".

const rateMovie = userRate => {
  switch (userRate) {
    case 5:
      console.log(`Calificaste la película como 'Muy buena', que bien que te haya fascinado esta película...`)
      console.log("Gracias por visitarnos...")
      break;
    case 4:
      console.log(`Calificaste la película como 'Buena', que bien que te haya gustado esta película...`)
      console.log("Gracias por visitarnos...")
      break;
    case 3:
      console.log(`Calificaste la película como 'Mediocre', disminuiremos peliculas de este estilo...`)
      console.log("Gracias por visitarnos...")
      break;
    case 2:
      console.log(`Calificaste la película como 'Mala', evitaremos recomendarte peliculas de este estilo...`)
      console.log("Gracias por visitarnos...")
      break;
    case 1:
      console.log(`Calificaste la película como 'Muy mala', lo lamentamos mucho );...`)
      console.log("Gracias por visitarnos...")
      break;
      default:
        console.log(`Ups!!! Algo salió mal, parece que ingresaste un valor inválido...`)
  }
}

// Se asume que el cliente tiene un menú de opciones e ingresará la valoración que más se ajuste a su percepción

let userRate = 5
rateMovie(userRate)
userRate = 4
rateMovie(userRate)
userRate = 3
rateMovie(userRate)
userRate = 2
rateMovie(userRate)
userRate = 1
rateMovie(userRate)
userRate = 0
rateMovie(userRate)
userRate = 6
rateMovie(userRate)