const notas = [10, 4, 5, 8, 9, 2, 7]

const notasAprobadas = notas.filter(el => (el * 10) >= 70)

console.log(notasAprobadas)

// ############### Ejercicio clase ###############

// Necesitamos enviarle un diploma a los alumnos que están aprobados y un e-mail a los alumnos desaprobados para acordar un recuperatorio. Por lo tanto, necesitamos dos listas: una lista que almacene todos los aprobados y otra los desaprobados. Deberemos guardarlos en las variables aprobados y desaprobados respectivamente.
const estudiantes = [
  {nombre: 'John', promedio: 8.5, aprobado: true},
  {nombre: 'Jane', promedio: 7, aprobado: true},
  {nombre: 'June', promedio: 3, aprobado: false},
]

const aprobados = estudiantes.filter(obj => obj.aprobado === true)
console.log(aprobados)
const desaprobados = estudiantes.filter(obj => obj.aprobado === false)
console.log(desaprobados)