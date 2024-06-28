// ***** SEGURIDAD: Si no se encuentra en localStorage info del usuario no lo deja acceder a la página, redirigiendo al login inmediatamente. *****
  const token = localStorage.getItem("jwt")
  !token ? location.replace("./index.html") : null


/* ------ comienzan las funcionalidades una vez que carga el documento ------ */
window.addEventListener('load', function () {

  /* ---------------- variables globales y llamado a funciones ---------------- */
  const btnCerrarSesion = document.querySelector("#closeApp")
  const formCrearTarea = document.forms[0]
  const urlUser = "https://todo-api.digitalhouse.com/v1/users/getMe"
  const urlTask = "https://todo-api.digitalhouse.com/v1/tasks"

  obtenerNombreUsuario()
  consultarTareas()
  
  /* -------------------------------------------------------------------------- */
  /*                          FUNCIÓN 1 - Cerrar sesión                         */
  /* -------------------------------------------------------------------------- */
  btnCerrarSesion.addEventListener('click', function () {
    const cerrarSesion = confirm("Estas seguro que quieres salir?")
    if (cerrarSesion) {
      localStorage.removeItem("jwt")
      setTimeout(() => { location.replace("./index.html") }, 2000)
    }
  })

  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 2 - Obtener nombre de usuario [GET]                */
  /* -------------------------------------------------------------------------- */

  function obtenerNombreUsuario() {
    const settings = {
      method: "GET",
      headers: { authorization: token },
    }

    fetch(urlUser, settings)
      .then((res) => res.json())
      .then((data) => {
        const userInfo = document.querySelector(".user-info p")
        userInfo.innerText = data.firstName
      })
      .catch((err) => console.log(err))
  }


  /* -------------------------------------------------------------------------- */
  /*                 FUNCIÓN 3 - Obtener listado de tareas [GET]                */
  /* -------------------------------------------------------------------------- */

  function consultarTareas() {
    
    fetch(urlTask, {
      method: "GET",
      headers: { Authorization: token },
    })
      .then((res) => res.json())
      .then((data) => {
        renderizarTareas(data)
        botonesCambioEstado()
        botonBorrarTarea()
      })
      .catch((err) => console.log(err))
  }


  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN 4 - Crear nueva tarea [POST]                    */
  /* -------------------------------------------------------------------------- */

  formCrearTarea.addEventListener('submit', function (event) {
    event.preventDefault()
    const inputNuevaTarea = document.querySelector("#nuevaTarea")
    const data = {
      description: inputNuevaTarea.value,
      completed: false,
    }
    const settings = {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        "Content-type": "application/json",
        Authorization: token,
      },
    }

    fetch(urlTask, settings)
      .then(res => res.json())
      .then(() => consultarTareas())
      .catch(err => console.log(err))
  })


  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 5 - Renderizar tareas en pantalla                 */
  /* -------------------------------------------------------------------------- */
  function renderizarTareas(listado) {
    const tareasPendientes = document.querySelector(".tareas-pendientes")
    const tareasTerminadas = document.querySelector(".tareas-terminadas")
    const nroFinalizadas = document.querySelector("#cantidad-finalizadas")
    let contador = 0

    tareasPendientes.innerHTML = ""
    tareasTerminadas.innerHTML = ""
    nroFinalizadas.innerText = contador

    listado.forEach(tarea => {
      const fecha = new Date(tarea.createdAt)
      if (tarea.completed) {
        contador++
        tareasTerminadas.innerHTML += `
          <li class="tarea">
            <div class="hecha">
              <i class="fa-regular fa-circle-check"></i>
            </div>
            <div class="descripcion">
              <p class="nombre">${tarea.description}</p>
              <div class="cambios-estados">
                <button class="change incompleta" id="${tarea.id}" ><i class="fa-solid fa-rotate-left"></i></button>
                <button class="borrar" id="${tarea.id}"><i class="fa-regular fa-trash-can"></i></button>
              </div>
            </div>
          </li>
        `
      } else {
        tareasPendientes.innerHTML += `
          <li class="tarea">
            <button class="change" id="${tarea.id}"><i class="fa-regular fa-circle"></i></button>
            <div class="descripcion">
              <p class="nombre">${tarea.description}</p>
              <p class="timestamp">${fecha.toLocaleDateString()}</p>
            </div>
          </li>
        `
      }
    })
    nroFinalizadas.innerText = contador
  }

  /* -------------------------------------------------------------------------- */
  /*                  FUNCIÓN 6 - Cambiar estado de tarea [PUT]                 */
  /* -------------------------------------------------------------------------- */
  function botonesCambioEstado() {
    const botones = document.querySelectorAll(".change")
    botones.forEach(boton => {
      boton.addEventListener('click', function () {
        const id = boton.id
        const urlTaskID = `${urlTask}/${id}`

        const settings = {
          method: "GET",
          headers: { Authorization: token },
        }
        fetch(urlTaskID, settings)
          .then(res => res.json())
          .then(data => {
            const taskData = {
              completed: !data.completed,
              description: data.description
            }

            const settings = {
              method: "PUT",
              headers: {
                "Content-type": "application/json",
                Authorization: token,
              },
              body: JSON.stringify(taskData)
            }
            fetch(urlTaskID, settings)
              .then(res => res.json())
              .then(() => consultarTareas())
              .catch(err => console.log(err))
          })
          .catch(err => console.log(err))
      })
    })
  }

  /* -------------------------------------------------------------------------- */
  /*                     FUNCIÓN 7 - Eliminar tarea [DELETE]                    */
  /* -------------------------------------------------------------------------- */
  function botonBorrarTarea() {
    const botones = document.querySelectorAll(".borrar")
    botones.forEach(boton => {
      boton.addEventListener('click', () => {
        const id = boton.id
        const urlTaskID = `${urlTask}/${id}`
        const settings = {
          method: "DELETE",
          headers: { Authorization: token },
        }
        fetch(urlTaskID, settings)
          .then(() => consultarTareas())
          .catch(err => console.log(err))
      })
    })
  }
})