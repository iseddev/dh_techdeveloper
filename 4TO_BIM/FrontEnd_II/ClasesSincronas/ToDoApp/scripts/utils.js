// #####################################
// ########## Clase 17 - Live ##########
// #####################################

const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g
/* ---------------------------------- texto --------------------------------- */
const validarTexto = text => text.length >= 3
const normalizarTexto = text => text.trim().toLowerCase()

/* ---------------------------------- email --------------------------------- */
const validarEmail = email => emailRegex.test(email)
const normalizarEmail = email => email.trim().toLowerCase()

/* -------------------------------- password -------------------------------- */
const validarContrasenia = password => password.length >= 6
const compararContrasenias = (pass_1, pass_2) => pass_1 === pass_2

// #########################################
// ########## FIN Clase 17 - Live ##########
// #########################################