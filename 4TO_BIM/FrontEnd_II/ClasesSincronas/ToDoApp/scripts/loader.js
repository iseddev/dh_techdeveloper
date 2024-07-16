function showSpinner(body, form) {

  // Creamos nuestro spinner
  const spinnerContainer = document.createElement("div")
  const spinner = document.createElement("div")
  // Asignamos las Clases a cada nuevo elemento, para poder manipular sus estilos
  spinnerContainer.classList.add("spinner-container")
  spinner.classList.add("spinner")
  // Ocultamos el formulario de registro
  form.classList.add("hidden")
  // Agregamos el Spinner a nuestro HTML.
  spinnerContainer.appendChild(spinner)
  body.appendChild(spinnerContainer)
  return
 }

function hideSpinner(body, form) {
  // Seleccionamos el contenedor del spinner
  const spinnerContainer = document.querySelector(".spinner-container")
  // Removemos el contenedor del spinner del HTML
  body.removeChild(spinnerContainer)
  form.classList.remove("hidden")
  return
}


// /* ---------------------- Skeleton ---------------------- */

const renderizarSkeleton = (total, container) => {

  const tasksContainer = document.querySelector(container)
  const skeletons = Array.from({ length: total })
  skeletons.forEach(() => {
    const template = `
      <li class="skeleton-container ${container.replace(".", "")}-child">
        <div class="skeleton-card">
          <p class="skeleton-text"></p>
          <p class="skeleton-text"></p>
        </div>
      </li>
    `
    tasksContainer.innerHTML += template
  })
}