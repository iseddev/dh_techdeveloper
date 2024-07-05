// ********** prompt() **********
let userName = prompt("Ingrese su nombre: ")
console.log(userName)

// ********** confirm() **********
let userChoice = confirm("¿Está seguro de que desea continuar?")
console.log(userChoice)

// ********** alert() **********
alert("¡Hola, " + userName + "! Bienvenido a mi página web.")
userChoice ? alert("Haz decidido continuar") : alert("Haz decidido cancelar")

// ********** Math **********
let simpleRandom = Math.random()
let customRandom = Math.random() * (100 - 1 ) + 1
let intCustomRandom = parseInt(customRandom)
console.log(simpleRandom)
console.log(customRandom)
console.log(intCustomRandom)

let rounded = Math.round(20.49)
let customRandomTwo = Math.random() * (100 - 1 ) + 1  // => Math.round(Math.random() * (100 - 1 ) + 1)
let intCustomRandomTwo = Math.round(customRandomTwo)
console.log(rounded)
console.log(customRandomTwo)
console.log(intCustomRandomTwo)

let maxTwo = Math.max(10, 20)
let maxThree = Math.max(10, 20, 30.58)
let maxFour = Math.max(10, 20, 30.58, "No")
console.log(maxTwo)
console.log(maxThree)
console.log(maxFour)

