const notas = [10, 4, 5, 8, 9, 2, 7]

const notasSumadas = notas.reduce((acum, num) => acum + num)

console.log(notasSumadas)


// ############### Ejercicio clase ###############

// Nos dejaron un array con las vueltas que dio una corredora entrenando en distintos momentos para una maratón.
// Nuestro desafío será crear la variable totalVueltas y almacenar en ella el total, usando el método reduce.
const vueltas = [5, 8, 12, 3, 22]

let totalVueltas = vueltas.reduce((aux, num) => aux + num)
console.log(totalVueltas)