let butacasCine = [ ["ocupado", "libre", "libre", "libre"],
                    ["libre", "libre", "libre", "libre"],
                    ["libre", "libre", "ocupado", "ocupado"],
                    ["ocupado", "ocupado", "ocupado", "ocupado"],
                    ["libre", "libre", "libre", "libre"], ]


let totalFilas = butacasCine.length
console.log(`Total filas:`, totalFilas)
let totalColumnas = butacasCine[0].length
console.log(`Total columnas:`, totalColumnas)

// ############### Recorrer UNA fila ###############

// Saber cuantas butacas "libres" hay en la FILA 1 (índice 0)
let libres1 = 0
for(let i = 0; i < butacasCine[0].length; i++) {
  butacasCine[0][i] === "libre" ? libres1++ : libres1
}
console.log(`Total butacas libres en la FILA 1: ${libres1}`)

// Saber cuantas butacas "libres" hay en la FILA 2 (índice 1)
let libres2 = 0
for(let i = 0; i < butacasCine[1].length; i++) {
  butacasCine[1][i] === "libre" ? libres2++ : libres2
}
console.log(`Total butacas libres en la FILA 2: ${libres2}`)

// Saber cuantas butacas "libres" hay en la FILA 3 (índice 2)
let libres3 = 0
for(let i = 0; i < butacasCine[2].length; i++) {
  butacasCine[2][i] === "libre" ? libres3++ : libres3
}
console.log(`Total butacas libres en la FILA 3: ${libres3}`)


// ############### Recorrer UNA columna ###############

// Saber cuantas butacas "ocupadas" hay en la COLUMNA 1 (índice 0)
let ocupadas1 = 0
for(let i = 0; i <butacasCine.length; i++){
  butacasCine[i][0] === "ocupado" ? ocupadas1++ : ocupadas1
}
console.log(`Total butacas ocupadas en la COLUMNA 1: ${ocupadas1}`)

// Saber cuantas butacas "ocupadas" hay en la COLUMNA 2 (índice 1)
let ocupadas2 = 0
for(let i = 0; i <butacasCine.length; i++){
  butacasCine[i][1] === "ocupado" ? ocupadas2++ : ocupadas2
}
console.log(`Total butacas ocupadas en la COLUMNA 2: ${ocupadas2}`)

// Saber cuantas butacas "ocupadas" hay en la COLUMNA 3 (índice 2)
let ocupadas3 = 0
for(let i = 0; i <butacasCine.length; i++){
  butacasCine[i][2] === "ocupado" ? ocupadas3++ : ocupadas3
}
console.log(`Total butacas ocupadas en la COLUMNA 3: ${ocupadas3}`)


// ############### Dos ciclos "for" ###############

// Recorrido por FILA == Ver las filas que tienen butacas "libres"
for(let m = 0; m < butacasCine.length; m++) {
  let libre = false
  for(let n = 0; n < butacasCine[m].length; n++) {
    butacasCine[m][n] === "libre" ? libre = true : libre
  }
  libre ? console.log(`Hay butacas libres en al fila ${m+ 1}`) : libre
}

// Recorrido por COLUMNA == Ver las columnas que tienen TODAS sus butacas "libres"
// for(let m = 0; m < butacasCine.length; m++) {
//   let libre = false
//   for(let n = 0; n < butacasCine[m].length; n++) {
//     butacasCine[m][n] === "libre" ? libre = true : libre
//   }
//   libre ? console.log(`Hay butacas libres en al fila ${m+ 1}`) : libre
// }
