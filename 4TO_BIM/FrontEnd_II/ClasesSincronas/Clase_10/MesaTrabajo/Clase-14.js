// Vamos a trabajar pasando información al Storage.
// De esta manera vamos a poder consumir en un html algo que haya guardado otro.
// 👉 Para eso debemos agregar al principio de la función [5] en script 'Clase-13' la siguiente línea:
//     localStorage.setItem('user', JSON.stringify(estadoUsuario))

/* -------------------------------------------------------------------------- */
/*           [6] FUNCIÓN: Escuchamos el evento de carga de la página          */
/* -------------------------------------------------------------------------- */
window.addEventListener('load', function () {
  // 👇 Todo lo que desarrollamos dentro, se ejecuta una vez que se carga la página
  // nos traemos la info del storage
  const user = recuperarDataStorage()
  // utilizamos la función para el renderizado
  renderizarElementos(user)
  // ☝ La función debe ser ejecutada al final del evento Load.
  botonCerrarSesion()
})

/* -------------------------------------------------------------------------- */
/*                 [7] FUNCIÓN: Recuperar la info del storage                 */
/* -------------------------------------------------------------------------- */
function recuperarDataStorage() {
  const datosEnJSON = localStorage.getItem('user')

  const datosParseados = JSON.parse(datosEnJSON)

  return datosParseados
}

/* -------------------------------------------------------------------------- */
/*                [8] FUNCIÓN: Renderizamos la info en pantalla               */
/* -------------------------------------------------------------------------- */
function renderizarElementos(objeto) {
  // capturamos los nodos
  const email = document.querySelector('#email')
  const perfil = document.querySelector('#perfil')

  // pintamos las propiedades del objeto en pantalla
  email.innerText = objeto.email
  perfil.innerText = objeto.rol
}

/* ----------------------------- MESA DE TRABAJO ---------------------------- */
/* -------------------------------------------------------------------------- */
/*                     [9] FUNCIÓN: Botón de cerrar sesión                    */
/* -------------------------------------------------------------------------- */
// Ahora vamos a crear elementos en el DOM dinamicamente y le asignaremos a esos elementos la escucha de eventos.

// La idea es crear un botón para cerrar sesión. Entonce necesitamos cumplir los siguientes puntos:
function botonCerrarSesion() {
  //    👇 desarrollar la función
  // 1- Crear un elemento <button>
  const logoutBtn = document.createElement("button")
  // 2- Que ese botón tenga el texto "Cerrar sesión"
  logoutBtn.innerText = "Cerrar sesión"
  // 3- El botón tiene que tener ciertos estilos:
  //     - padding arriba y abajo de 5px y a los costados 20px
  //     - color de fondo rojo con transparencia: rgba(255,0,0,0.2)
  //     - color de letra rojo
  //     - margenes a todos los lados de 20px
  //     - ningún borde
  //     - cursor de tipo pointer
  const customStyles = `
  padding: 5px 20px;
  background-color: rgba(255,0,0,0.2);
  color: red;
  margin: 20px;
  border: none;
  cursor: pointer;
  `
  logoutBtn.style = customStyles
  // 4- Tenemos que agregar el botón en pantalla, adentro del div con la clase 'user', al final del mismo
  const userDiv = document.querySelector('.user')
  userDiv.appendChild(logoutBtn)
  // 5- El botón debe reaccionar cuando se le hace click
  logoutBtn.addEventListener("click", () => {
    // 6- Mediante el click debe aparecer un cuadro de confirmación que pregunte: "¿Seguro desea cerrar sesión?"
    const confirmLogout = confirm("¿Seguro desea cerrar sesión?")
    // 7- Si el usuario acepta, debe borrar todo el storage y re-dirigirlo a la pantalla de Login.
    if (confirmLogout) {
      localStorage.clear()
      logoutBtn.innerText = "Cerrando sesión..."
      setTimeout(() => location.href = "index.html", 2000)
    }
  })
}