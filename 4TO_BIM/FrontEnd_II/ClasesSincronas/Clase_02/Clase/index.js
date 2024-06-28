// Math()
let decimal = 3.478

// Math.round() - Math.floor() - Math.ceil()
let decimalRound = Math.round(decimal)
console.log(decimalRound)

let decimalFloor = Math.floor(decimal)
console.log(decimalFloor)

let decimalCeil = Math.ceil(decimal)
console.log(decimalCeil)

// Math.min() - Math.max()
let num1 = 44
let num2 = 78
let num3 = 16

let minNum = Math.min(num1, num2, num3)
console.log(minNum)

const numbers = [44, 78, 16]
minNum = Math.min(...numbers) // ... => spread operator
console.log(minNum)

let maxNum = Math.max(num1, num2, num3)
console.log(maxNum)
maxNum = Math.max(...numbers)
console.log(maxNum)

// Math.random()
let randomNum = Math.random() // Numero decimal aleatorio entre 0 y 1 =>  0 <= randomNum < 1
console.log(randomNum)

randomNum = Math.random() * 10 // Numero decimal aleatorio entre 0 y 10 =>  0 <= randomNum < 10
console.log(randomNum)

randomNum = Math.round(Math.random() * 10) + 1 // Numero entero aleatorio entre 1 y 11 =>  1 <= randomNun <= 11
console.log(randomNum)

randomNum = Math.floor(Math.random() * 10) + 1 // Numero entero aleatorio entre 1 y 11 =>  1 <= randomNun <= 10
console.log(randomNum)

randomNum = Math.ceil(Math.random() * 10) + 1 // Numero entero aleatorio entre 1 y 11 =>  1 <= randomNun <= 11
console.log(randomNum)

let list = ["Juan", "Pedro", "Maria", "Ana", "Lucia", "Carlos", "Jose", "Luis",]

// for(... of ...)
for (let name of list) { console.log(name) }

// forEach()
list.forEach(name => console.log(name))

list.push("Marta")

// for(... in ...) => Para Objetos
const obj = {
  a: 1,
  b: 2,
  c: 3,
}

for (const key in obj) {
  console.log(obj[key])
  console.log(obj.value)
}

const students = [
  {
    name: "Israel",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "David",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Juan",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Pedro",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Maria",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Ana",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Lucia",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Carlos",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Jose",
    materia: "FE2",
    status: "Aprobado"
  },
  {
    name: "Luis",
    materia: "FE2",
    status: "Aprobado"
  },
]

students.forEach(student => {
  for (let key in student) { console.log(student[key]) }
})

// Buscar y encontrar a un estudiante: Lucia
let student = students.find(student => student.name.toLowerCase() === "lucia")
console.log(student)