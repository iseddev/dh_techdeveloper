// window object

console.log(window)

console.log(innerHeight, innerWidth)

console.log(outerHeight, outerWidth)

console.log(location)

innerWidth > 768
  ? console.log("Estás en una pantalla grande")
  : console.log("Estás en una pantalla chica")

window.onload =  ()  => console.log("Se cargó la página correctamente")

const navegar = () => { open("https://www.google.com", "_blank") } // open proviene de window

// document object
console.log(document)

console.log(document.body)

const main = document.getElementById("root")
// const main = document.querySelector("#root")
console.log(main)

const encabezado = document.getElementsByClassName("encabezado")
console.log(encabezado)

const encabezados = document.getElementsByClassName("encabezado")
console.log(encabezados[0])

const encabezadoBySelector = document.querySelector(".encabezado")

const logo = document.querySelector('.encabezado .logo')
const nav = document.querySelector('.navegador')
console.log(logo)
console.log(nav)

const li = document.querySelector('ul li')
console.log(li)

const arrayLi = document.querySelectorAll("#clases li")
console.log(arrayLi)

const arrayArticles = document.querySelectorAll("article")
console.log(arrayArticles)

const navTitle = document.querySelectorAll('nav h4')
console.log(navTitle)

navTitle[0].innerText = 'Inicio'

// innerHTML
//Se borra todo
// main.innerHTML = '<h1>Todos los elementos anteriores han sido borrados</h1>'

//Se suma al final
// main.innerHTML = main.innerHTML + '<h1>Yo me sumé a lo último</h1>'
main.innerHTML += '<h1>Yo me sumé a lo último</h1>'

console.log(nav.style)
nav.style.display = 'flex'
nav.style.justifyContent = 'space-around'
// navTitle[0].style.color = 'red'
// navTitle[0].style.backgroundColor = 'grey'

for(let i = 0; i < navTitle.length; i++) { navTitle[i].style.color = 'green' }

arrArticles.forEach((elemento) => {
    // console.log(elemento)
    elemento.style.color = 'red'
})

for(let elemento of arrLi){
    // console.log(elemento)
    elemento.style.color = 'red'
}