const listado = [
  {
    nombre: 'Juan',
    edad: 32
  },
  {
    nombre: 'Lucía',
    edad: 45
  },
  {
    nombre: 'Nicolas',
    edad: 22
  }
]

const nodoUl = document.querySelector('ul')

function mostrarPersonas(lista) {
  lista.forEach(item => nodoUl.innerHTML += `<li><strong>${item.nombre}</strong> (${item.edad} años)</li>`)
}
// mostrarPersonas(listado)

/* -------------------------------- Consigna -------------------------------- */
// Realizar el mismo proceso de renderizar en pantalla pero utilizando la función .map()
// Detalles:
// . Indagar en la documentación de MDN -> https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Global_Objects/Array/map
// . Comentar la función anterior y ejecutar esta para probar el resultado 👇

function mostrarPersonasConMap(lista) {
  // lista.map(objeto => nodoUl.innerHTML += `<li><strong>${objeto.nombre}</strong> (${objeto.edad} años)</li>`)
  nodoUl.innerHTML = lista.map(objeto => `<li><strong>${objeto.nombre}</strong> (${objeto.edad} años)</li>`).join("")
}
mostrarPersonasConMap(listado)