// ###########################################
// ############### Bonus extra ###############
// ###########################################

// ***** Propiedad única *****
// Crear una función llamada propiedadUnica que reciba un arreglo de objetos como parámetro y un string. Esta deberá retornar un nuevo arreglo de objetos, teniendo como parámetro la propiedad que fue pasada como string.
// Ejemplo:
// let array = [ { nombre: “Lean”, edad: 27 }, { nombre: “Eze”, edad: 49} ]
// propiedadUnica(array, “edad”) debe retornar [ { edad: 27 }, { edad: 49 } ]
// propiedadUnica(array, “nombre”) debe retornar [ { nombre: “Lean”}, { nombre: “Eze” } ]
const countries = [
  {name: "México", population: 123456789},
  {name: "Argentina", population: 963852741},
  {name: "Perú", population: 987654321},
  {name: "Colombia", population: 147258369},
  {name: "Chile", population: 369258147},
]

const propiedadUnica = (arr, key) => {
  let success = false

  for(i = 0; i < arr.length; i++) {
    if(Object.keys(arr[i]).includes(key)) success = true
  }

  if(success) {
    const details = []
    for(i = 0; i < arr.length; i++) {
      details[i] = {[key]: arr[i][key]}
    }
    return details
  } else return (`Ups!!! Algo salió mal, revisa e intenta nuevamente...`)
  
}
console.log(propiedadUnica(countries, "name"))
console.log(propiedadUnica(countries, "population"))
console.log(propiedadUnica(countries, "test"))

// ***** Calculador de notas *****
// Crear el objeto “alumno”, el cual va a consistir de las siguientes propiedades básicas:
// ● Nombre
// ● Número de legajo
// ● Lista de notas
// Nos gustaría calcular el promedio del alumno y si el mismo está aprobado, basado en una nota de aprobación que le va a ser dada. Para este ejercicio, vamos a dejar que pienses todos los métodos y propiedades que puedan hacer falta para que el programa funcione correctamente de la manera solicitada.

const PROMEDIO_APROBADO = 80

const alumno = {
  nombre: "John",
  idEmpleado: 58962,
  notas1: [82, 98, 85, 78, 89, 96],
  notas2: [82, 68, 75, 68, 89, 66],
  promedioNotas: function(listaNotas) {
    let acumulado = 0
    let promedio = 0
    for(let i=0; i < listaNotas.length; i++) {
      acumulado += listaNotas[i]
    }
    promedio = acumulado / listaNotas.length
    return promedio
  },
  estaAprobado: function(promedioNotas, promedioAprobatorio) {
    if(promedioNotas >= promedioAprobatorio) {
      console.log(`${this.nombre} SI está aprobado con un promedio de ${promedioNotas}`)
    } else { console.log(`${this.nombre} NO está aprobado con un promedio de ${promedioNotas}`) }
  }
}

alumno.estaAprobado(alumno.promedioNotas(alumno.notas1), PROMEDIO_APROBADO)
alumno.estaAprobado(alumno.promedioNotas(alumno.notas2), PROMEDIO_APROBADO)