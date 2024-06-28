/* ---------------------------------- texto --------------------------------- */
function validarTexto(texto) { return texto >= 3 }

function normalizarTexto(texto) { return texto.trim().toLowerCase() }

/* ---------------------------------- email --------------------------------- */
function validarEmail(email) {
  const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g
  return emailRegex.test(email)
}

function normalizarEmail(email) {}

/* -------------------------------- password -------------------------------- */
function validarContrasenia(contrasenia) {}

function compararContrasenias(contrasenia_1, contrasenia_2) {}