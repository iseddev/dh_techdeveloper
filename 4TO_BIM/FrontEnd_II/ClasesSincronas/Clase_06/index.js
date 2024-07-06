//  ########## EVENTOS ##########

// window.addEventListener("load", () => {
//   console.log("Se cargó la página 3")
// })
// window.addEventListener("load", () => {
//   console.log("Se cargó la página 4")
// })
// window.onload = () => {
//   console.log("Se cargó la página 1")
// }
// window.onload = () => {
//   console.log("Se cargó la página 2")
// }
// window.onload = () => {
//   console.log("Se cargó la página 5")
// }
// console.log(window)

window.addEventListener("load", () => {
  const div = document.querySelector("#root")
  console.log(div)
  const contenedor = document.querySelector("#contenedor")
  console.log(contenedor)

  div.addEventListener("mouseover", () => {
    console.log("mouseover")
    div.innerHTML = "<p>Quita el mouse de sobre mi</p>"
    contenedor.innerHTML = "<p>Elemento 1</p><p>Elemento 2</p><p>Elemento 3</p>"
  })

  div.addEventListener("mouseout", () => {
    console.log("mouseout")
    div.innerHTML = "<p>Pasa el mouse sobre mi</p>"
    contenedor.innerHTML = ""
  })
})

//click, event y preventDefault
const aTag = document.querySelector("#anchor")

aTag.addEventListener("click", (event) => {
  console.log(event)
  event.preventDefault()
  const pregunta = confirm("Estas seguro que quiere salir del sitio?")
  if (pregunta) { open("https://playground.digitalhouse.com/login") }
})

//  Eventos de teclado
//keypress
const pTag = document.getElementById("keypress")

document.addEventListener("keypress", event => {
  console.log(event.key)
  pTag.innerText = "Presionaste la tecla " + event.key
  if (event.key === "Enter") { console.log("Epa! apretaste enter!") }
})

//keydown y keyup
document.addEventListener("keydown", event => console.log("Presionaste " + event.key))
document.addEventListener("keyup", event => console.log("Soltaste " + event.key))

const contador = document.querySelector("#contador")
let cantSegundos = 0
let intervalo

document.addEventListener("keydown", () => {
  if (!intervalo) {
    intervalo = setInterval(() => {
      cantSegundos++
      contador.innerText = `Tiempo: ${cantSegundos} segundos`
    }, 1000)
  }
})

document.addEventListener("keyup", () => {
  clearInterval(intervalo)
  intervalo = null
  cantSegundos = 0
  contador.innerText = "Tiempo: 0 segundos"
})