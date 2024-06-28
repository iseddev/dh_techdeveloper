window.addEventListener('load', () => {

  /* -------------------------------------------------------------------------- */
  /* ---------------------- Obtenemos variables globales ---------------------- */
  /* -------------------------------------------------------------------------- */
  const url = "https://todo-api.digitalhouse.com/v1/users"
  const form = document.forms[0]
  const name = document.querySelector("#inputNombre")
  const lastName = document.querySelector("#inputApellido")
  const email = document.querySelector("#inputEmail")
  const pass = document.querySelector("#inputPassword")
  const passAgain = document.querySelector("#inputPasswordRepetida")

  /* -------------------------------------------------------------------------- */
  /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
  /* -------------------------------------------------------------------------- */
  form.addEventListener('submit', event => {
    event.preventDefault()
    mostrarSpinner()
    const data = {
      firstName: name.value,
      lastName: lastName.value,
      email: email.value,
      password: pass.value,
    }
    const config = {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(data)
    }
    realizarRegister(config)
  })

  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN 2: Realizar el signup [POST]                    */
  /* -------------------------------------------------------------------------- */
  function realizarRegister(settings) {
    fetch(url, settings)
      .then(res => res.json())
      .then(data => {
        console.log(data)
        if (data.jwt) {
          localStorage.setItem("jwt", data.jwt)
          ocultarSpinner()
          setTimeout(() => { location.replace("./mis-tareas.html") }, 2000)
        }
      })
      .catch(err => {
        ocultarSpinner()
        console.log(err)
      })
  }
})