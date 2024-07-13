/* -------------------------- Estado por defecto ------------------------- */
const estadoUsuario = {
  email: "",
  password: "",
  rol: "",
  terminos: false
}

// Ponemos en true solo cuando estén correctos
const estadoErroresOK = {
  email: false,
  password: false,
  rol: false,
  terminos: false
}

/* ---------------------------------- nodos --------------------------------- */

// capturamos todos los elementos que necesitamos
const formulario = document.forms[0]

const inputEmail = document.querySelector('#email')
const inputPassword = document.querySelector('#password')
const inputRol = document.querySelector('#rol')
const inputTerminos = document.querySelector('#terminos')

const emailError = document.querySelector('#emailError')
const passwordError = document.querySelector('#passwordError')
const rolError = document.querySelector('#rolError')
const terminosError = document.querySelector('#terminosError')


/* -------------------------------------------------------------------------- */
/*                   [1] FUNCIÓN: Mostrar errores al usuario                  */
/* -------------------------------------------------------------------------- */
function mostrarErrores() {
  // Por cada small mostramos u ocultamos el error
  estadoErroresOK.email ? emailError.classList.remove('visible') : emailError.classList.add('visible')
  estadoErroresOK.password ? passwordError.classList.remove('visible') : passwordError.classList.add('visible')
  estadoErroresOK.rol ? rolError.classList.remove('visible') : rolError.classList.add('visible')
  estadoErroresOK.terminos ? terminosError.classList.remove('visible') : terminosError.classList.add('visible')
}

/* -------------------------------------------------------------------------- */
/*               [2] FUNCIÓN: Actualizamos los estados de la app               */
/* -------------------------------------------------------------------------- */

// 👇 Por cada cambio en el formulario actualizamos
formulario.addEventListener('change', function () {

  // 👇 Actualizo el estado de la pantalla con los datos
  estadoUsuario.email = inputEmail.value
  estadoUsuario.password = inputPassword.value
  estadoUsuario.rol = inputRol.value
  estadoUsuario.terminos = inputTerminos.checked

  // 👇 Actualizo el estado del error según el estado del usuario
  estadoErroresOK.email = validarEmail(estadoUsuario.email)
  estadoErroresOK.password = validarPassword(estadoUsuario.password)
  estadoErroresOK.rol = validarRol(estadoUsuario.rol)
  estadoErroresOK.terminos = validarTerminos(estadoUsuario.terminos)

  // finalmente muestro los errores presentes
  mostrarErrores()
})


/* -------------------------------------------------------------------------- */
/*                        [3] FUNCIONES: validar campos                       */
/* -------------------------------------------------------------------------- */
function validarEmail(email) {
  let resultado = false

  // // EJEMPLO VALIDACIÓN A MANO 👇
  // if (email.includes('@') && email.includes('.') && !email.includes(' ') && email.length > 5) {
  //     resultado = true
  // } 

  // EJEMPLO CON EXPRESIÓN REGULAR 👇
  let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}')

  if (regex.test(email)) { resultado = true }

  return resultado
}

function validarPassword(password) {
  let resultado = false

  // Si pasa las pruebas lo damos por válido 👇
  if (password.length > 5 && !password.includes(' ')) { resultado = true }

  return resultado
}

function validarRol(rol) {
  let resultado = false

  // Si pasa las pruebas lo damos por válido 👇
  if (rol === "frontend" || rol === "backend") { resultado = true }

  return resultado
}

function validarTerminos(verificacion) {
  let resultado = false

  // si pasa las pruebas lo damos por válido 👇
  if (verificacion) { resultado = true }

  return resultado
}


/* -------------------------------------------------------------------------- */
/*                      [4] FUNCIÓN: escuchamos el submit                     */
/* -------------------------------------------------------------------------- */

// En el evento submit nos remitimos a chequear nuestro estado de errores
formulario.addEventListener('submit', function (evento) {
  // Prevenimos el default para manejar nosotros el comportamiento
  evento.preventDefault()

  console.log(estadoUsuario)
  console.log(estadoErroresOK)

  if (estadoErroresOK.email && estadoErroresOK.password && estadoErroresOK.rol && estadoErroresOK.terminos) {
      // alert("Pasó todas las validaciones!")
      // ☝ Luego reemplazar esto por la función de éxito
      navegarPaginaExito()
  }
})


/* ----------------------------- MESA DE TRABAJO ---------------------------- */
/* -------------------------------------------------------------------------- */
/*                [5] FUNCIÓN: Formulario completado con éxito                */
/* -------------------------------------------------------------------------- */
// Esta función se va a encargar de realizar la re-dirección cuando el formulario se complete correctamente.
// Para eso deberá cumplir con los siguientes requerimientos.

function navegarPaginaExito() {

  localStorage.setItem('user', JSON.stringify(estadoUsuario))

  //   ########## Desarrollar la función aquí ##########
  const btnSubmit = document.querySelector('button[type="submit"]')

  // 1 - Deshabilitar el botón del formulario.
  btnSubmit.disabled = true

  // 2 - Esperar 3 segundos para re-direccionar a la página de
  const tiempoEspera = 3000
  setTimeout(() => { window.location.href = 'usuario.html' }, tiempoEspera)

  // 3 - Durante ese tiempo el botón deshabilitado debe mostrar el texto: "Cargando..."
  btnSubmit.textContent = "Cargando..."


  // 4 - Cuando vaya a la página de 'usuario.html' NO se debe permitir que mediante el botón de "Atrás"(la flechita del navegador) el usuario vuelva a index.
  window.history.replaceState(null, '', 'usuario.html')
}