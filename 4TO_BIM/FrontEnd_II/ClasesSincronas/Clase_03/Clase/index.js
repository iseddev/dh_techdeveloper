// window object

console.log(window)

console.log(innerHeight, innerWidth)

console.log(outerHeight, outerWidth)

console.log(location)

innerWidth > 768
  ? console.log("Estás en una pantalla grande")
  : console.log("Estás en una pantalla chica")

window.onload =  ()  => console.log("Se cargó la página correctamente")

const navegar = () => { open("https://www.google.com", "_blank") }

// document object
console.log(document)

console.log(document.body)

const main = document.getElementById("root")
console.log(main)

const encabezado = document.getElementsByClassName("encabezado")
console.log(encabezado)

const encabezados = document.getElementsByClassName("encabezado")
console.log(encabezados[0])

const encabezadoBySelector = document.querySelector(".encabezado")

const arrayList = document.querySelectorAll("li")
console.log(arrayList)

const arrayClases = document.querySelectorAll("#clases li")
console.log(arrayClases)

const arrayArticles = document.querySelectorAll("article")
console.log(arrayArticles)