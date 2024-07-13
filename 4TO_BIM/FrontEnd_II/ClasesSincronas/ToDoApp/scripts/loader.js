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
  return
}


// /* ---------------------- Skeleton ---------------------- */

const renderizarSkeleton = (cantidad, contenedor) => {
  
  const contenedorTareas = document.querySelector(contenedor)

  // const skeletons
}