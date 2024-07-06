const personaje = {
  nombre: "Michael",
  apellido: "Scott",
  nacimiento: {
      fecha: "15/04/1965",
      ciudad: "Scranton",
      estado: "Pensilvania"
  },
  imagenUrl : "https://upload.wikimedia.org/wikipedia/en/thumb/d/dc/MichaelScott.png/220px-MichaelScott.png",
  trabajo: {
      rol: "manager regional",
      compania: "Dunder Mifflin"
  }
}

let htmlTemplate = `
<div style="border: 1px solid black; width: 500px">
  <img src="(${personaje.imagenUrl}" width: "100%" alt="">
  <h3>Nombre</h3>
  <h4>(${personaje.nombre})</h4>
  <h3>Apellido</h3>
  <h4>(${personaje.apellido})</h4>
  <hr>
  <h3>Nacimiento</h3>
  <h4>(${personaje.nacimiento.fecha})</h4>
  <h3>Lugar</h3>
  <h4>(${personaje.nacimiento.ciudad})</h4>
  <h4>(${personaje.nacimiento.estado})</h4>
  <hr>
  <h3>Trabajo</h3>
  <p>${personaje.trabajo.rol}, en <strong>${personaje.trabajo.compania}</strong></p>
</div>
`

// ########## Manejo de estilos CSS ##########

// "Capturamos" el elemento objetivo
let mainTitle = document.querySelector("h1")
// Agregamos contenido adicional al elemento
mainTitle.innerHTML += " - Contenido desde JS"
// Modificamos el estilo del elemento
mainTitle.style.color = "red"
mainTitle.style.fontSize = "50px"
mainTitle.style.textAlign = "center"


// ########## Manejo de clases CSS ##########

let quote = document.querySelector(".quote")
// classList.add("nombreClase"): agrega una clase a un elemento
quote.classList.add("quote--italic")
quote.classList.add("quote--test")

// classList.remove("nombreClase"): remueve una clase de un elemento
quote.classList.remove("quote--test")

// classList.toggle("nombreClase"): agrega o remueve una clase de un elemento
quote.classList.toggle("quote--italic")

// classList.contains("nombreClase"): verifica si un elemento tiene una clase
quote.classList.add("quote--test")
let hasQuoteTestClass = quote.classList.contains("quote--test")

if (hasQuoteTestClass) {
  console.log("El elemento tiene la clase 'quote--test'")
  console.log("Eliminado la clase 'quote--test' ...")
  quote.classList.remove("quote--test")
}