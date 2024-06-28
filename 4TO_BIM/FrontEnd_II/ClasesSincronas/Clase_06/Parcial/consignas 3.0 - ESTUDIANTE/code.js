/* --------------------------- NO TOCAR DESDE ACÁ --------------------------- */
let datosPersona = {
  nombre: "",
  edad: 0,
  ciudad: "",
  interesPorJs: "",
}

const listado = [{
    imgUrl: "https://huguidugui.files.wordpress.com/2015/03/html1.png",
    lenguajes: "HTML y CSS",
    bimestre: "1er bimestre",
  },
  {
    imgUrl: "https://jherax.files.wordpress.com/2018/08/javascript_logo.png",
    lenguajes: "Javascript",
    bimestre: "2do bimestre",
  },
  {
    imgUrl: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/React.svg/1200px-React.svg.png",
    lenguajes: "React JS",
    bimestre: "3er bimestre",
  },
]

const profileBtn = document.querySelector("#completar-perfil")
const materiasBtn = document.querySelector("#obtener-materias")
const verMasBtn = document.querySelector("#ver-mas")
const cambiarTema = document.querySelector('#cambiar-tema')

profileBtn.addEventListener("click", renderizarDatosUsuario)
materiasBtn.addEventListener("click", recorrerListadoYRenderizarTarjetas)
cambiarTema.addEventListener("click", alternarColorTema)
/* --------------------------- NO TOCAR HASTA ACÁ --------------------------- */

function obtenerDatosDelUsuario() {
  /* --------------- PUNTO 1: Escribe tu código a partir de aquí --------------- */
  let userName = ""
  let userBirthYear = 0
  let userCity = ""
  let currentYear = new Date().getFullYear()

  let isValidName = false
  let isValidYear = false
  let isValidCity = false

  do {
    userName = prompt("Ingresa tu nombre")
    !userName || userName === "" || userName.trim().length <= 3 || !isNaN(parseInt(userName))
      ? alert("Debes ingresar un nombre válido, intenta nuevamente...")
      : (datosPersona.nombre = userName, isValidName = true)
  } while (!isValidName)

  do {
    userBirthYear = parseInt(prompt("Ingresa el año en que naciste"))
    !userBirthYear || userBirthYear === "" || userBirthYear < 1900 || userBirthYear > currentYear || isNaN(userBirthYear)
      ? alert("Debes ingresar un año válido, intenta nuevamente...")
      : (datosPersona.edad = currentYear - userBirthYear, isValidYear = true)
  } while (!isValidYear)

  do {
    userCity = prompt("Ingresa la ciudad donde vives")
    !userCity || userCity === "" || userCity.trim().length <= 3 || !isNaN(parseInt(userCity))
      ? alert("Debes ingresar una ciudad válida, intenta nuevamente...")
      : (datosPersona.ciudad = userCity, isValidCity = true)
  } while (!isValidCity)

  datosPersona.interesPorJs = confirm("Te interesa JavaScript?") ? "Si" : "No"
}

function renderizarDatosUsuario() {
  /* ------------------- NO TOCAR NI ELIMINAR ESTA FUNCIÓN. ------------------- */
  obtenerDatosDelUsuario()
  /* --------------- PUNTO 2: Escribe tu código a partir de aquí --------------- */
  for(let key in datosPersona){
    key !== "interesPorJs"
      ? document.querySelector(`#${key}`).textContent = datosPersona[key]
      : document.querySelector("#javascript").textContent = datosPersona[key]
  }
}

function recorrerListadoYRenderizarTarjetas() {
  /* ------------------ PUNTO 3: Escribe tu código desde aquí ------------------ */
  const filaMaterias = document.querySelector("#fila")
  filaMaterias.innerHTML === ""
    ?
      (listado.forEach((materia) => {
      let cardContainer = document.createElement("div")
      cardContainer.className = "caja"
      cardContainer.innerHTML = `
        <img src="${materia.imgUrl}" alt="${materia.lenguajes}">
        <p class="lenguajes">${materia.lenguajes}</p>
        <p class="bimestre">${materia.bimestre}</p>`
      filaMaterias.appendChild(cardContainer)
      }))
    : null
}

function alternarColorTema() {
  /* --------------------- PUNTO 4: Escribe tu código aquí --------------------- */
  document.querySelector("#sitio").classList.toggle("dark")
}

/* --------------------- PUNTO 5: Escribe tu código aquí --------------------- */
document.addEventListener("keypress", (e) => e.key === "F"
  ? document.querySelector("#sobre-mi").classList.remove("oculto")
  : null
)