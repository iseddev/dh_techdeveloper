console.log("Mi segundo console.log()")

let a = 1
var b = 2
const c = 3

function scopeVar() {
  if(true){
    var x = 10
    console.log(x)
  }
  console.log(x)
}

scopeVar()

const scopeLet = () => {
  if(true) {
    let y = 20
    console.log(y)
  }
  //Esto tira error porque no está al alcance
  // console.log(y)
}

scopeLet()

let condition = false
// alert()
if(condition === true) alert("La condición es verdadera")
else alert("La condición es falsa")

// confirm()
const answer = confirm("¿Te gusta el Front?")
if(answer) alert("¡Qué bueno! A mi también")
else("No sabes de lo que te pierdes...")

// prompt()
const userName = prompt("¿Cuál es tu nombre?")
!userName
  ? alert("No ingresaste tu nombre")
  : userName.length < 3
    ? alert("Tu nombre debe tener al menos 3 caracteres")
    : alert("Hola " + userName + ", bienvenido a Frontend II")


// ##### LOOPS #####
for(let i = 0; i < 10; i++) console.log("El contador es: " + i)

let j = 11
while(j < 10) { // No se ejecutará este while() ya que j NO ES MENOR a 10
  console.log("El contador es: " + j)
  j++
}

let k = 10
do {
  console.log("El contador es: " + k)
  k++
} while(k <= 20)