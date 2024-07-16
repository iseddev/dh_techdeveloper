// ################################################
// ########## Clase 13 - Mesa de Trabajo ##########
// ################################################

window.addEventListener("load", function () {
  /* ---------------------- obtenemos variables globales ---------------------- */
  const signupEndpoint = "https://todo-api.digitalhouse.com/v1/users"
  const body = document.querySelector("body")
  const form = document.forms[0]
  const firstName = document.querySelector("#inputNombre")
  const lastName = document.querySelector("#inputApellido")
  const email = document.querySelector("#inputEmail")
  const pass = document.querySelector("#inputPassword")
  const re_pass = document.querySelector("#inputPasswordRepetida")

  /* -------------------------------------------------------------------------- */
  /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
  /* -------------------------------------------------------------------------- */
  form.addEventListener("submit", e => {
    e.preventDefault()
    
    // #####################################
    // ########## Clase 17 - Live ##########
    // #####################################
    if(!validarTexto(firstName.value)) {
      alert("El nombre debe tener al menos 3 caracteres")
      return
    }
    if(!validarTexto(lastName.value)) {
      alert("El apellido debe tener al menos 3 caracteres")
      return
    }
    if(!validarEmail(email.value)) {
      alert("El email no es válido")
      return
    }
    if(!validarContrasenia(pass.value)) {
      alert("La contraseña debe tener al menos 6 caracteres")
      return
    }
    if(!compararContrasenias(pass.value, re_pass.value)) {
      alert("Las contraseñas no coinciden")
      return
    }
    // #########################################
    // ########## FIN Clase 17 - Live ##########
    // #########################################

    showSpinner(body, form)
    const userData = {
      firstName: normalizarTexto(firstName.value),
      lastName: normalizarTexto(lastName.value),
      email: normalizarEmail(email.value),
      password: pass.value,
    }
    const config = {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(userData)
    }
    signupAccount(config)
  })

  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN 2: Realizar el signup [POST]                    */
  /* -------------------------------------------------------------------------- */
  function signupAccount(settings) {
    fetch(signupEndpoint, settings)
      .then(response => response.json())
      .then(data => {
        const { jwt } = data
        console.log(jwt)
        if (jwt) {
          localStorage.setItem("token", jwt)
          setTimeout(() => location.replace("./mis-tareas.html"), 2000)
        }
      })
      .catch(err => {
        ocultarSpinner(body, form)
        console.log(err)
      })
  }
})

// ####################################################
// ########## FIN Clase 13 - Mesa de Trabajo ##########
// ####################################################