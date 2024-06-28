//  ########## EVENTOS ##########


// window.onload() = () => console.log("Se cargó la página 1")

// window.onload() = () => console.log("Se cargó la página 2")

// window.addEventListener("load", () => console.log("Se cargó la página 3"))

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


//  Eventos de teclado

const pTag = document.querySelector("#pTag")