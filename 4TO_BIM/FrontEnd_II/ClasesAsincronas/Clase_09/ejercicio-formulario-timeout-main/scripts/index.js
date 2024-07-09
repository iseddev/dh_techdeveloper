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

// ACTIVIDAD

// Paso a paso:

const loginBtn = document.querySelector(".login-btn")

// 1) Escuchar el evento necesario para reaccionar cuando la persona haga click en el botón iniciar sesión.
loginBtn.addEventListener("click", e => {

  e.preventDefault()

  const errorContainer = document.querySelector("#error-container")
  const loginLoader = document.querySelector("#loader")
  const emailInput = document.querySelector("#email-input").value
  const passwordInput = document.querySelector("#password-input").value
  const errors = []
  
  errorContainer.innerHTML = ""
  
  // 2) El proceso de inicio de sesión deberá tener una demora de 3 segundos. Deberás agregar la función correspondiente para simular dicha demora.
  setTimeout(() => {

    // 4) A partir de los inputs ingresados en el formulario, se deberán realizar las siguientes validaciones:
      const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g

      // 1) Que el primer input sea un email válido.
      const isValidEmail = emailRegex.test(emailInput.trim())
      // 2) Que la contraseña tenga al menos 5 caracteres.
      const isValidPassword = passwordInput.length >= 5

      if (!isValidEmail || !isValidPassword) {
        errorContainer.classList.remove("hidden")
        loginLoader.classList.add("hidden")
        if (!isValidEmail) { errors.push("<p style='color:red; width:100%;'>* Mail no válido</p>") }
        if (!isValidPassword) { errors.push("<p style='color:red; width:100%;'>* La contraseña debe tener al menos 5 caracteres</p>") } 
        errors.forEach(error => errorContainer.innerHTML += error)
      } else {

        // 3) Que los datos ingresados corresponden a una persona que se encuentre registrada en la base de datos.
        const userExists = baseDeDatos.usuarios.find(user => user.email === emailInput && user.password === passwordInput)
        
        // 5) En caso de que los datos ingresados sean correctos, se deberá ocultar el formulario y mostrar un mensaje de bienvenida al sitio.
        if (userExists) {
          const main = document.querySelector("main")
          main.innerHTML = "<h1> Bienvenido al sitio 😀 </h1>"
        } else {
          // En caso de que alguna de las validaciones no sea exitosa, se deberá mostrar un mensaje de error que diga "Alguno de los datos ingresados son incorrectos"
          loginLoader.classList.add("hidden")
          errorContainer.classList.remove("hidden")
          errorContainer.innerHTML += "<p style='color:red'>Alguno de los datos ingresados son incorrectos</p>"
        }
      }
  }, 3000)
  // 3) Durante el tiempo indicado anteriormente, se deberá mostrar el mensaje "Iniciando sesión..."
  loginLoader.classList.remove("hidden")
})

/* 
TIPS:
  - Puedes averiguar acerca de la manera de validar el formato de un email utilizando Javascript, buscando en internet frases como "Validar email con Javascript o similar".

  - Recuerda que puedes seleccionar y manipular los elementos del archivo index.html, usando los recursos que Javascript te ofrece para ello. Además, en el archivo styles.css tiene algunas clases y estilos predefinidos para ayudarte a completar la actividad.

  - También te dejamos algunos mensajes que te pueden ser de utilidad:
   Mensaje de error => <small>Alguno de los datos ingresados son incorrectos</small>
   Mensaje de bienvenida => "<h1> Bienvenido al sitio 😀 </h1>"

   ¡Manos a la obra!
 */
