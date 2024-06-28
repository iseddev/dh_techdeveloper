const prompt = require("prompt-sync")({ sigint: true })

// ##### ¿Qué devuelve cada función? #####
// En este ejercicio deberás pensar qué devuelve cada función sin ejecutarla en la consola.

// ===== Micro Desafío 1 =====
function test1(x, y) {
  return y - x
}
test1(10, 40) // Devuelve 30, ya que y=40 y x=10, y como se retorna (y - x) => (40 - 10 = 30)
// console.log(test1(10, 40))

// ===== Micro Desafío 2 =====
function test2(x, y) {
  return x * 2
  console.log(x)
  return x / 2
}
test2(10) // Devuelve 20, ya que el return indica devolver el resulatado de 10*2, lo demás es ignorado
// console.log(test2(10))


// ***** En todos los casos en que se reciban parámetros, utilizar el prompt para el ingreso por consola de los valores *****


// 1. Crear una función que convierta pulgadas en centímetros.
// Recibe por parámetro pulgadas y retorna su equivalente en centímetros.
function inchesToCentimeters(inches) { return inches * 2.54 }
let inches = parseInt(prompt("Ingresa las pulgadas a convertir: "))
console.log(`La conversion de ${inches} pulgada(s) es de: ${inchesToCentimeters(inches)} CENTÍMETRO(S)`)

// 2. Crear una función que recibe un string y lo convierte en una URL.
// Ej: “pepito” es devuelto como “http://www.pepito.com”
function toURL(str) { return `http://www.${str}.com` }
let str = prompt("Ingresa un nombre de dominio: ")
console.log(`Tu URL queda de la siguiente manera: ${toURL(str)}`)

// 3. Crear una función que recibe un string y devuelve la misma frase pero con admiración.
function exclamationMarks(phrase) { return `¡${phrase}!`}
let phrase = prompt("Ingresa una frase aleatoria: ")
console.log(`Tu frase queda de la siguiente forma: ${exclamationMarks(phrase)}`)

// 4. Crear una función que calcule la edad de los perros, considerando que 1 año para nosotros son 7 de ellos.
function dogAge(years) { return years * 7 }
let years = parseInt(prompt("Ingresa la edad actual de tu perro en AÑOS: "))
console.log(`La edad "perruna" de tu mascota es de: ${dogAge(years)} AÑOS`)

// 5. Crear una función que calcule el valor de tu hora de trabajo, introduciendo tu sueldo mensual como parámetro.
// PD: considerá que tu mes de trabajo tiene 40 horas.
function hourlySalary(monthlySalary) { return monthlySalary / 40 }
let monthlySalary = parseInt(prompt("Ingresa tu sueldo mensual: "))
console.log(`Tu salario por hora es de: $${hourlySalary(monthlySalary)}`)

// 6. Crear la función calculadorIMC() que reciba la altura en metros y el peso en kilogramos y calcule el IMC de una persona. Luego, ejecutar la función probando diferentes valores.
function calculadorIMC(weight, height) { return  weight / (height * height)}
let weight = parseFloat(prompt("Ingresa tu peso en KILOGRAMOS (puedes usar decimales): "))
let height = parseFloat(prompt("Ingresa tu altura en METROS (puedes usar decimales): "))
console.log(`Tu IMC (Índice de Masa Muscular) es de: ${calculadorIMC(weight, height).toFixed(2)} kg/m2`)


// Seleccionar alguna de estas funciones —o de manera opcional, todas— y escribirla como función expresada y función flecha.
// ================================
// ===== FUNCIONES EXPRESADAS =====
// ================================
// let inchesToCentimeters = function(inches) { return inches * 2.54 }
// let toURL = function(str) { return `http://www.${str}.com` }
// let exclamationMarks = function(phrase) { return `¡${phrase}!`}
// let dogAge = function(years) { return years * 7 }
// let hourlySalary = function(monthlySalary) { return monthlySalary / 40 }
// let calculadorIMC = function(weight, height) { return  weight / (height * height)}

// ==============================================
// ===== FUNCIONES FLECHA (arrow functions) =====
// ==============================================
// const inchesToCentimeters = inches => inches * 2.54
// const toURL = str => `http://www.${str}.com`
// const exclamationMarks = phrase => `¡${phrase}!`
// const dogAge = years => years * 7
// const hourlySalary = monthlySalary => monthlySalary / 40
// const calculadorIMC = (weight, height) => weight / (height * height)


// 7. Crear una función que recibe un string en minúscula, lo convierta a mayúsculas y lo retorne.
// Investigá qué hace el método de strings .toUpperCase()
function toUppercase(text) { return text.toUpperCase() }
let text = prompt("Ingresa un texto sólo en MINÚSCULAS: ")
console.log(`El texto en MAYÚSCULAS es: ${toUppercase(text)}`)

// 8. Crear una función que recibe un parámetro y devuelve qué tipo de dato es ese parámetro.
// Pista: te servirá revisar qué hace la palabra reservada typeof.
function dataType(data) { return typeof data }
let data = prompt("Ingresa algún valor que desees: ")
console.log(`El tipo de dato para ${data} es: ${dataType(data)}`)

// 9. Crear una función que le pasamos el radio de un círculo y nos devuelve la circunferencia.
// Pista: Investigá si el objeto Math tiene entre sus propiedades el número Pi.
function circumference(radius) { return Math.PI * (2 * radius) }
let radius = parseFloat(prompt("Ingresa el radio del circulo (puedes usar decimales): "))
console.log(`La circunferencia(perímetro) resultante es: ${circumference(radius).toFixed(2)}`)