/*
##### Objetivo #####
=> Aplicar las estructuras de JavaScript para repasar y fijar la sintaxis del lenguaje.

=> Micro desafío
Escribir un programa de Calculadora de acuerdo a los siguientes requerimientos: 

1. Debe poder resolver las 4 operaciones básicas: suma, resta, multiplicación y división. Cada una debe corresponder con una función.
2. Cada operación debe recibir dos operandos. 
3. Solo debe recibir números en cada operando. En el caso de que se envíe otro valor, debe mostrar un mensaje de error controlado.
4. Debe contener una función main donde se envíe como parámetros el primer operando, el segundo operando y la operación. 

**** Ayuda: Se puede implementar con un IF o con SWITCH en base a la operación a realizar. ****


Realizar varios ejemplos de ejecución con distintos tipos de datos enviados como operandos. El programa debe generar una salida controlada de error en los siguientes casos:
let operacionSuma = calcular(2,null,"suma")
let operacionResta = calcular("a",3,"resta")
let operacionMultiplicacion = calcular(5,2.3,"multiplicacion")
let operacionDivision = calcular(20,0,"division")
let operacionSinDatos = calcular()
*/

function calcular(operando1, operando2, operacion) {

  // Verificamos que se hayan ingresado los datos necesarios
  if(operando1 === undefined || operando2 === undefined || operacion === undefined) return "Error: Faltan datos"
  // Verificamos que los operandos sean números
  if (typeof operando1 !== "number" || typeof operando2 !== "number") return `Error: Solo se permiten números como operandos`
  // Convertimos el valor de operación a minúsculas para evitar errores de escritura
  operacion = operacion.toLowerCase()
  // Verificamos que la operación pasada como parámetro sea válida
  if (operacion !== "suma" && operacion !== "resta" && operacion !== "multiplicacion" && operacion !== "division") {
    return "Error: Operación NO válida"
  }
  // Realizamos la operación correspondiente
  switch (operacion) {
    case "suma":
      return operando1 + operando2
    case "resta":
      return operando1 - operando2
    case "multiplicacion":
      return operando1 * operando2
    case "division":
      // Verificamos que el divisor no sea cero
      if (operando2 === 0) { return "Error: NO se puede dividir por cero" }
      return operando1 / operando2
    default:
      return "Error: Operación inválida"
  }
}

// Ejemplos de ejecución propuestos y visualización del manejo de errores
let operacionSuma = calcular(2,null,"suma")
console.log(operacionSuma)
let operacionResta = calcular("a",3,"resta")
console.log(operacionResta)
let operacionMultiplicacion = calcular(5,2.3,"multiplicacion")
console.log(operacionMultiplicacion)
let operacionDivision = calcular(20,0,"division")
console.log(operacionDivision)
let operacionSinDatos = calcular()
console.log(operacionSinDatos)

// Ejemplos de ejecución positivos
console.log(calcular(16, 5, "suma"))
console.log(calcular(16, 5, "resta"))
console.log(calcular(16, 5, "multiplicacion"))
console.log(calcular(16, 5, "division"))