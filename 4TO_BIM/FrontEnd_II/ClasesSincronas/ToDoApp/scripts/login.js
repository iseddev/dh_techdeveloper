// #####################################
// ########## Clase 13 - LIVE ##########
// #####################################

window.addEventListener('load', function () {
  /* ---------------------- obtenemos variables globales ---------------------- */
  const loginEndpoint = "https://todo-api.digitalhouse.com/v1/users/login"
  const body = document.querySelector("body")
  const form = document.forms[0]
  // const form = document.querySelector("form") // Otra alternativa
  const email = document.querySelector("#inputEmail")
  const pass = document.querySelector("#inputPassword")

  /* -------------------------------------------------------------------------- */
  /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
  /* -------------------------------------------------------------------------- */
  form.addEventListener("submit", e => {
    e.preventDefault()
    showSpinner(body, form)
    const data = {
      email: email.value,
      password: pass.value,
    }
    const config = {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(data),
    }
    accessAccount(config)
  })


  /* -------------------------------------------------------------------------- */
  /*                     FUNCIÓN 2: Realizar el login [POST]                    */
  /* -------------------------------------------------------------------------- */
  const accessAccount = settings => {
    fetch(loginEndpoint, settings)
      .then(response => response.json())
      .then(data => {
        const { jwt } = data
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

// #########################################
// ########## Fin Clase 13 - LIVE ##########
// #########################################