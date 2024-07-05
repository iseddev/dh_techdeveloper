// Obtener elemento por etiqueta
let titleByTag = document.querySelector("h1")
// Obtener elemento por nombre de clase
let titleByClassName = document.querySelector(".titulo")
let titleByClassName2 = document.getElementsByClassName("titulo2")
// Obtener elemento por id
let titleById = document.querySelector("#titulo")
let titleById2 = document.getElementById("titulo2")

// Obtener todos los elementos por etiqueta
let allTitlesByTag = document.querySelectorAll("h1")
// Obtener todos los elementos por nombre de clase
let allTitlesByClassName = document.querySelectorAll(".titulo")
// Obtener todos los elementos por id
let allTitlesById = document.querySelectorAll("#titulo")


// Leer y/o modificar el contenido de un elemento HTML
let h1InnerHTML = document.querySelector("h1").innerHTML
// Modificar todo el contenido de un elemento HTML
document.querySelector("h1").innerHTML = "Nuevo título"
// Agregar contenido adicional al final del contenido ya existente de un elemento HTML
document.querySelector("h1").innerHTML *= " contenido adicional"// Leer y/o modificar el contenido de un elemento HTML
let h1InnerText = document.querySelector("h1").innerText
// Modificar todo el contenido de un elemento HTML
document.querySelector("h1").innerText = "Nuevo título"
// Agregar contenido adicional al final del contenido ya existente de un elemento HTML
document.querySelector("h1").innerText *= " contenido adicional"