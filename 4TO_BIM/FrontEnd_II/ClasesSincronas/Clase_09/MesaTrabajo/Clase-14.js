// Vamos a trabajar pasando información al Storage.
// De esta manera vamos a poder consumir en un html algo que haya guardado otro.
// 👉 Para eso debemos agregar al principio de la función [5] en script "Clase-13" la siguiente línea:
// localStorage.setItem("user", JSON.stringify(estadoUsuario))

/* -------------------------------------------------------------------------- */
/*           [6] FUNCIÓN: Escuchamos el evento de carga de la página          */
/* -------------------------------------------------------------------------- */
window.addEventListener("load", function () {
    // 👇 Todo lo que desarrollamos dentro, se ejecuta una vez que se carga la página

    // Nos traemos la info del storage
    const user = recuperarDataStorage()
    // Utilizamos la función para el renderizado
    renderizarElementos(user)
    // Llamamos a la función del botón de cerrar sesión
    botonCerrarSesion()
})

/* -------------------------------------------------------------------------- */
/*                 [7] FUNCIÓN: Recuperar la info del storage                 */
/* -------------------------------------------------------------------------- */
function recuperarDataStorage() {
    const datosEnJSON = localStorage.getItem("user")
    const datosParseados = JSON.parse(datosEnJSON)
    return datosParseados
}


/* -------------------------------------------------------------------------- */
/*                [8] FUNCIÓN: Renderizamos la info en pantalla               */
/* -------------------------------------------------------------------------- */
function renderizarElementos(objeto) {
    // Capturamos los nodos
    const email = document.querySelector("#email")
    const perfil = document.querySelector("#perfil")

    // Pintamos las propiedades del objeto en pantalla
    email.innerText = objeto.email
    perfil.innerText = objeto.rol
}


/* ----------------------------- MESA DE TRABAJO ---------------------------- */
/* -------------------------------------------------------------------------- */
/*                     [9] FUNCIÓN: Botón de cerrar sesión                    */
/* -------------------------------------------------------------------------- */
// Ahora vamos a crear elementos en el DOM dinámicamente y le asignaremos a esos elementos la escucha de eventos.
// ☝ La función debe ser ejecutada al final del evento Load.
// La idea es crear un botón para cerrar sesión. Entonce necesitamos cumplir los siguientes puntos:

function botonCerrarSesion() {
    // 👇 Desarrollar la función

    // 1- Crear un elemento <button>
    const button = document.createElement("button")

    // 2- Que ese botón tenga el texto "Cerrar sesión"
    button.textContent = "Cerrar sesión"

    // 3- El botón tiene que tener ciertos estilos:
    //     - padding arriba y abajo de 5px y a los costados 20px
    button.style.padding = "5px 20px"
    //     - color de fondo rojo con transparencia: rgba(255,0,0,0.2)
    button.style.backgroundColor = "rgba(255,0,0,0.2)"
    //     - color de letra rojo
    button.style.color = "red"
    //     - margenes a todos los lados de 20px
    button.style.margin = "20px"
    //     - ningún borde
    button.style.border = "none"
    //     - cursor de tipo pointer
    button.style.cursor = "pointer"

    // 4- Tenemos que agregar el botón en pantalla, adentro del div con la clase "user", al final del mismo
    const userDiv = document.querySelector(".user")
    userDiv.appendChild(button)

    // 5- El botón debe reaccionar cuando se le hace click
    button.addEventListener("click", () => {
        // 6- Mediante el click debe aparecer un cuadro de confirmación que pregunte: "¿Seguro desea cerrar sesión?"
        const confirmLogout = confirm("¿Seguro desea cerrar sesión?")
        // 7- Si el usuario acepta debe borrar todo el storage y redirigirlo a la pantalla de Login.
        if (confirmLogout) {
            setTimeout(() => {
                localStorage.clear()
                location.href = "index.html"
            }, 500)
        }
    })
}
