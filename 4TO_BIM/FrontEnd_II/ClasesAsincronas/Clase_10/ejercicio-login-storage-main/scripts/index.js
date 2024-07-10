// Esta es la base de datos de nuestros usuarios
const baseDeDatos = {
  usuarios: [
    {
      id: 1,
      name: "Steve Jobs",
      email: "steve@jobs.com",
      password: "Steve123",
    },
    {
      id: 2,
      name: "Ervin Howell",
      email: "shanna@melissa.tv",
      password: "Ervin345",
    },
    {
      id: 3,
      name: "Clementine Bauch",
      email: "nathan@yesenia.net",
      password: "Floppy39876",
    },
    {
      id: 4,
      name: "Patricia Lebsack",
      email: "julianne.oconner@kory.org",
      password: "MysuperPassword345",
    },
  ],
}

if(localStorage.getItem("userName") !== null) {
  // C10 => 3) Una vez iniciada la sesión, la misma se deberá mantener en ese estado para el caso de que la persona recargue la página. Para ello, deberás validar si existe información del usuario al momento en que se produce la carga de la página, y en base a dicha condición decidir que elementos mostrar.
  const main = document.querySelector("main")
  const userName = localStorage.getItem("userName")
  main.innerHTML = `<h1> Bienvenido al sitio 😀 ${userName}</h1>`
  main.innerHTML += "<button class='login-btn' id='logout-btn'>Cerrar Sesión</button>"

  // C10 => 4) Para el caso de que la persona haga click en el botón "Cerrar Sesión", se deberá eliminar la información del usuario, mostrar un mensaje indicando que se ha cerrado la sesión, y recargar la página para mostrar nuevamente el formulario de login.
  const logoutBtn = document.querySelector("#logout-btn")
  logoutBtn.addEventListener("click", () => {
    logoutBtn.remove()
    main.innerHTML += "<p>Cerrando sesión...</p>"
    localStorage.clear()
    setTimeout(() => location.reload(), 2000)
  })
} else {
  window.addEventListener("load", () => {

    const loginBtn = document.querySelector(".login-btn")
    // C09 => 1) Escuchar el evento necesario para reaccionar cuando la persona haga click en el botón iniciar sesión.
    loginBtn.addEventListener("click", e => {

      e.preventDefault()

      const errorContainer = document.querySelector("#error-container")
      const loginLoader = document.querySelector("#loader")
      const emailInput = document.querySelector("#email-input").value
      const passwordInput = document.querySelector("#password-input").value
      const errors = []

      errorContainer.innerHTML = ""

      // C09 => 3) Durante el tiempo indicado anteriormente, se deberá mostrar el mensaje "Iniciando sesión..."
      loginLoader.classList.remove("hidden")

      // C09 => 4) A partir de los inputs ingresados en el formulario, se deberán realizar las siguientes validaciones:
        // 4.1) Que el primer input sea un email válido.
        const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g
        const isValidEmail = emailRegex.test(emailInput.trim())
        // 4.2) Que la contraseña tenga al menos 5 caracteres.
        const isValidPassword = passwordInput.length >= 5
      
      // C09 => 2) El proceso de inicio de sesión deberá tener una demora de 3 segundos. Deberás agregar la función correspondiente para simular dicha demora.
      setTimeout(() => {
        if (!isValidEmail || !isValidPassword) {
          errorContainer.classList.remove("hidden")
          loginLoader.classList.add("hidden")
          if (!isValidEmail) { errors.push("<p style='color:red; width:100%;'>* Mail no válido</p>") }
          if (!isValidPassword) { errors.push("<p style='color:red; width:100%;'>* La contraseña debe tener al menos 5 caracteres</p>") } 
          errors.forEach(error => errorContainer.innerHTML += error)
        } else {
          // 4.3) Que los datos ingresados corresponden a una persona que se encuentre registrada en la base de datos.
          const registeredUser = baseDeDatos.usuarios.find(user => user.email === emailInput && user.password === passwordInput)
          // C09 => 5) En caso de que los datos ingresados sean correctos, se deberá ocultar el formulario y mostrar un mensaje de bienvenida al sitio.
          if (registeredUser) {
            const main = document.querySelector("main")
            // C10 => 1) Al momento de que la persona inicia sesión, si las validaciones que ya tenemos implementadas han sido exitosas, deberemos almacenar la información del usuario en el LocalStorage.
            localStorage.setItem("userName", registeredUser.name)
            // C10 => 2) Al mensaje de bienvenida que ya teníamos implementado, deberemos agregarle el nombre de la persona y un botón de "Cerrar Sesión".
            const userName = localStorage.getItem("userName")
            main.innerHTML = `<h1> Bienvenido al sitio 😀 ${userName}</h1>`
            main.innerHTML += "<button class='login-btn' id='logout-btn'>Cerrar Sesión</button>"
          } else {
            // En caso de que alguna de las validaciones no sea exitosa, se deberá mostrar un mensaje de error que diga "Alguno de los datos ingresados son incorrectos"
            loginLoader.classList.add("hidden")
            errorContainer.classList.remove("hidden")
            errorContainer.innerHTML += "<p style='color:red'>Alguno de los datos ingresados son incorrectos</p>"
          }
        }
      }, 3000)
    })
  })
}

/* 
TIPS:
  - Para lograr los objetivos de este ejercicio, deberás valerte de algunos eventos y métodos que vimos en las clases anteriores. Te invitamos a que revises los recursos en caso de que tengas dudas, ya que allí encontrarás todas las respuestas que necesitas para completar la actividad.

  - Recuerda que puedes seleccionar y manipular los elementos del archivo index.html, usando los recursos que Javascript te ofrece para ello. Además, en el archivo styles.css tiene algunas clases y estilos predefinidos para ayudarte a completar la actividad.

  - Al momento de guardar información del usuario en el navegador, recuerda que debemos almacenar solo la información necesaria, y EN NINGÚN CASO DEBEMOS GUARDAR LA CONTRASEÑA. Por ello, deberás seleccionar y separar la información que tienes que almacenar, a partir del objeto que contiene la información del usuario.

   ¡Manos a la obra!
 */
