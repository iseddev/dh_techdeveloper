const notas = [10, 4, 5, 8, 9, 2, 7]

const notasHastaCien = notas.map(el => el * 10)

console.log(notasHastaCien)

// ############### Ejercicio clase ###############
// Nos dejaron una lista con los horarios de partida de algunos aviones. Esta lista se reproduce directamente en las pantallas del aeropuerto y, a modo de travesura, queremos adelantar una hora cada partida. Nuestro trabajo será utilizar el método map para poder lograrlo y almacenar la lista en una variable nueva llamada horariosAtrasados.

const horariosPartida = [12, 14, 18, 21];

const horariosAdelantados = horariosPartida.map(el => ++el)
const horariosAtrasados = horariosPartida.map(el => --el)
console.log(horariosAtrasados)
console.log(horariosAdelantados)