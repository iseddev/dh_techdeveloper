/* -------------------------------------------------------------------------- */
/*               [1] FUNCIÓN: capturar los datos del formulario               */
/* -------------------------------------------------------------------------- */
function capturarDatosFormulario() {
    // 👇 Establecemos un objeto vacío para después rellenarlo
    const objetoInformacion = {
        nombre: "",
        password: "",
        telefono: "",
        hobbies: [],
        nacionalidad: ""
    }

    // capturamos todos los nodos
    const nom = document.querySelector('#nom')
    const pass = document.querySelector('#pass')
    const tel = document.querySelector('#tel')
    const hobbies = document.querySelectorAll('[name=hobbies]')
    const nacionalidad = document.querySelectorAll('[name=nacionalidad]')

    // 👇 rellenamos el objeto con la info correspondiente
    objetoInformacion.nombre = nom.value
    objetoInformacion.password = pass.value
    objetoInformacion.telefono = tel.value
    // recorremos los checkbox
    hobbies.forEach(hobbie => {
        // cada hobbie seleccionado lo sumamos al listado
        if (hobbie.checked) {
            objetoInformacion.hobbies.push(hobbie.id)
        }
    })
    // recorremos los radio
    nacionalidad.forEach(nacion => {
        // la nacionalidad seleccionada es la que se guarda en el objeto
        if (nacion.checked) { objetoInformacion.nacionalidad = nacion.id }
    })

    return objetoInformacion
}

/* -------------------------------------------------------------------------- */
/*                 [2] FUNCIÓN: escuchamos el submit del form                 */
/* -------------------------------------------------------------------------- */
const form = document.querySelector('form')

form.addEventListener('submit', function (evento) {
    // prevenimos el default para que no se intente enviar
    evento.preventDefault()
    // utilizamos nuestra función para capturar los datos
    const datos = capturarDatosFormulario()
    console.log(datos)
    const errores = validarInformacion(datos)
    console.log(errores)
    // mostramos los errores presentes
    // renderizarErrores(errores)
    // mostramos mensaje de éxito si no hay errores
    // mostrarMensajeExito(errores)
})


/* ----------------------------- MESA DE TRABAJO ---------------------------- */
/* -------------------------------------------------------------------------- */
/*                         [3] FUNCIÓN: validar datos                         */
/* -------------------------------------------------------------------------- */
// Desarrollar la función 3 de validar los datos.

// Entonces dentro de esta función vamos a chequear ciertas validaciones.
// Esta función va a recibir un objeto con la misma estructura de objetoInformacion
function validarInformacion(usuario) {
    
    // 1- La función devuelve un listado de errores según las comprobaciones que hace sobre el objeto.
    let errores = []
    
    // 👇 desarrollar aquí la función
    
    // 2- Si el nombre no es un texto y tiene menos de 3 caracteres sumar el error: "El nombre debe tener al menos 3 caracteres."
    const nameRegEx = /^[a-zA-Z]{3,}$/gm
    if (!nameRegEx.test(nom.value)) { errores.push("<p style='color:red;'>El nombre debe tener al menos 3 caracteres.</p>") }
    
    // 3- Si la contraseña tiene menos de 6 caracteres, sin contar espacios al principio, en el medio o final, sumar el error: "La contraseña debe tener al menos 6 caracteres, entre letras y símbolos."
    const passRegEx = /^(?=.*[a-zA-Z]).{6,}$/gm
    if (!passRegEx.test(usuario.password)) { errores.push("<p style='color:red;'>La contraseña debe tener al menos 6 caracteres, entre letras y símbolos.</p>") }
    
    // 4- Si el teléfono tiene menos de 10 números, sumar el error: "No es un teléfono válido."
    const telRegEx = /^\d{10}$/gm
    if (!telRegEx.test(usuario.telefono)) { errores.push("<p style='color:red;'>No es un teléfono válido.</p>") }
    
    // 5- Si la lista de hobbies tiene más de 4 items, sumar el error: "Sólo es posible seleccionar 4 hobbies."
    if (usuario.hobbies.length > 4) { errores.push("<p style='color:red;'>Sólo es posible seleccionar 4 hobbies.</p>") }
    
    // 6- Si no hay una nacionalidad definida, sumar el error: "Debe seleccionar una nacionalidad."
    if (usuario.nacionalidad === "") { errores.push("<p style='color:red;'>Debe seleccionar una nacionalidad.</p>") }

    return errores
}