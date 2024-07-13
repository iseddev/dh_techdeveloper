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

  /* -------------------------------------------------------------------------- */
  /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
  /* -------------------------------------------------------------------------- */
  form.addEventListener("submit", e => {
    e.preventDefault()
    showSpinner(body, form)
    const userData = {
      firstName: firstName.value,
      lastName: lastName.value,
      email: email.value,
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