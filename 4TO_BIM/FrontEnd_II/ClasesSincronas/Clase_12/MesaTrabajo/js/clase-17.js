// 🚩 Primero que nada vamos a enlazar el HTML con este nuevo script y a su vez vamos a comentar (o eliminar) la linea que lo vincula con el script de la clase 16.
// La idea es desarrollar en este script las nuevas y mejoradas funcionalidades.

const boton = document.querySelector('button')
const endpoint = 'https://jsonplaceholder.typicode.com/comments'

/* -------------------------------------------------------------------------- */
/*                       [4] FUNCIÓN: Consulta a la API                       */
/* -------------------------------------------------------------------------- */
// En este caso vamos a consultar a un servidor del cual nos vamos a traer la data.
// Esta API tiene su documentación en: https://jsonplaceholder.typicode.com/
// Vamos a implementar el endpoint que nos devuelve comentarios para mostrarlos en pantalla.

// function consultaApi(endpoint) {
//   fetch(endpoint)
//     .then(objetoRespuesta => {
//       console.log(objetoRespuesta)
//       const promesaJson = objetoRespuesta.json()
//       return promesaJson
//     })
//     .then(datosJs => {
//       // 3- Si los comentarios llegan y se cargan correctamente, el botón de "Ver comentarios" debe desaparecer de la interfaz. Así evitamos que se vuelva a llamar a la API.
//       if (datosJs.length > 0) {
//         console.log(datosJs)
//         renderizarElementos(datosJs)
//         boton.remove()
//       }
//     })
//     // 1- En el caso de la consulta a la API, si la misma no es satisfactoria, deberá arrojar un error que se le muestre al usuario.
//     // 2- Para lograr ver el error podemos forzarlo modificando el endpoint incorrectamente, para detectar y arrojar el error deben implementar el bloque try().catch()
//     .catch (error =>
//       Swal.fire({
//         icon: "error",
//         title: "Oops...",
//         text: "Something went wrong!",
//         footer: `<p>${error}</p>`
//       })
//     )
// }

const consultaApi = async endpoint => {
	try {
		const response = await fetch(endpoint)
		const dataJSON = await response.json()
    if (dataJSON) {
      renderizarElementos(dataJSON)
      boton.remove()
    } else { console.log("Ups! Error en la consulta de datos...") }
	} catch (err) {
		Swal.fire({
			icon: "error",
			title: "Oops...",
			text: "Something went wrong!",
			footer: err
		})
	}
}

/* -------------------------------------------------------------------------- */
/*                      [5] FUNCIÓN: Escuchamos el click                      */
/* -------------------------------------------------------------------------- */
// Vamos a re-implementar la escucha del click lanzar las nuevas funciones.
boton.addEventListener('click', function () {
    console.log("Clink para ver comentarios...")
    consultaApi(endpoint)
})

/* -------------------------------------------------------------------------- */
/*                      [6] FUNCIÓN: renderizar elementos                     */
/* -------------------------------------------------------------------------- */
// Acá vamos a reutilizar la función de renderizar renderizarElementos, implementando
// el .map() y .join() para obtener el resultado esperado.
function renderizarElementos(listado) {
  const comentarios = document.querySelector('.comentarios')
  comentarios.innerHTML = listado.map((item, index) => {
    // 4- Solo deben cargarse los primeros 10 comentarios que nos llegan.
    // console.log(index)
    if (index < 10) {
      return `
        <div class="comentario">
          <h4>${item.email}</h4>
          <p>${item.body}</p>
        </div>`
    }
  }).join('')
}
/* ----------------------------- Mesa de trabajo ---------------------------- */
/* -------------------------------------------------------------------------- */
/*                              Mejoras de código                             */
/* -------------------------------------------------------------------------- */
// En este caso no debemos desarrollar una nueva funcionalidad necesariamente. Aunque
// siempre que lo creas necesario va a estar bien modularizar en funciones el código.
// Queda a criterio del grupo generar o no nuevas funciones.
// En este caso deberán cumplir con nuevos requerimientos que necesita la aplicación.