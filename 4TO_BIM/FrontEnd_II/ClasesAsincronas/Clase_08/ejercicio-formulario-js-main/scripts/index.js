const registerBtn = document.querySelector(".register-btn")

registerBtn.addEventListener("click", e => {
  e.preventDefault()

  // Escribe tu código aquí, siguiendo los siguientes lineamientos paso a paso:

  // 1. Obtenemos el valor ingresado en el input de email
  const email = document.querySelector("#email-input").value

  // 2. Obtenemos los datos ingresados en el input de password
  const password = document.querySelector("#password-input").value

  // 3. Obtenemos el valor del input radio
  let selectedRadio = null
  const legalAgeRadios = document.querySelectorAll("input[name='legalAge']")
  legalAgeRadios.forEach(radioInput => radioInput.checked ? selectedRadio = radioInput.getAttribute("id") : null)
  
  // 4. Obtenemos el valor del input checkbox
  let tycCheckbox = document.querySelector("#tyc-input").checked
  
  // 5 Validamos si el usuario es mayor de edad. Si no, mostramos un mensaje de error: "Debes ser mayor de edad para registrarte en el sitio"
  let isLegalAge = false
  selectedRadio === "age_yes" ? isLegalAge = true : alert("Debes ser mayor de edad para registrarte en el sitio")
  
  // 6 Validamos si el usuario aceptó los términos y condiciones. Si no, mostramos un mensaje de error: "Debes aceptar los TyCs para registrarte en el sitio"
  let tycIsAccepted = false
  tycCheckbox ? tycIsAccepted = true : alert("Debes aceptar los TyCs para registrarte en el sitio")

  // 7 Si todo esta correcto, mostramos por consola un objeto con la información ingresada por el usuario.
  if (email && password && isLegalAge && tycIsAccepted) {
    console.log({
      email,
      password,
      isLegalAge,
      tycIsAccepted
    })
  }
})