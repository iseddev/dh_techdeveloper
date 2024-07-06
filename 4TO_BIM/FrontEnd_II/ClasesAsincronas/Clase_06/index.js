let text = document.querySelector(".text")

text.onmouseover = () => console.log("Pasaste el mouse")
text.onmouseout = () => console.log("Quitaste el mouse")

// text.addEventListener("mouseover", () => console.log("Pasaste el mouse"))
// text.addEventListener("mouseout", () => console.log("Quitaste el mouse"))

let myInput = document.querySelector("#my-input")
// keydown => Se dispara cuando se presiona una tecla (aplica para las teclas de caracteres y las teclas de función)
// myInput.onkeydown = e => alert("Se pulsó la tecla: " + e.key)
myInput.addEventListener("keydown", e => console.log("Se pulsó la tecla: " + e.key))
// keyup => Se dispara cuando se suelta una tecla
// myInput.onkeyup = e => alert("Se soltó la tecla: " + e.key)
myInput.addEventListener("keyup", e => console.log("Se soltó la tecla: " + e.key))
// keypress => Se dispara durante el recorrido de presionar y soltar una tecla
// myInput.onkeypress = e => alert("Se pulsó y soltó la tecla: " + e.key)
myInput.addEventListener("keypress", e => console.log("Se pulsó y soltó la tecla: " + e.key))