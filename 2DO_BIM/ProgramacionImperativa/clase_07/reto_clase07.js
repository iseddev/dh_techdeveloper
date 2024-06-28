// #####################################################
// ############### Bucles y repeticiones ###############
// #####################################################

// 1) Crear una función que pida un valor por parámetro y muestre los 10 números siguientes.
const nextTenNums = num => {
  console.log(`Número ingresado: ${num}`)
  console.log(`Siguientes 10 números consecutivos:`)
  for(i = 1; i<= 10; i++) { console.log(num + i) }
}
let num = 5
nextTenNums(num)


// 2) Imprimir los números entre el 5 y el 20, saltando de tres en tres.
console.log("Números entre el 5 y el 20, saltando de tres en tres:")
for(i = 5; i <= 20;  i += 3) { console.log(i) }


// 3) Escribir un programa que muestre la sumatoria de todos los números entre el 0 y el 100
let sum = 0
for(i = 0; i <= 100; i++) { sum += i }
console.log(`La suma de todos los números desde 0 hasta 100 es:`, sum)

// 4) Dado un número entero positivo, mostrar su factorial. El factorial de un número se obtiene multiplicando todos los números enteros positivos que hay entre el 1 y ese número.
const factorial = num => {
  if(num > 0) {
    let factorialResult = 1
    for(i = 1; i <= num; i++){ factorialResult *= i }
    return console.log(factorialResult)
  } else { console.log("Ups!!! Ingresa un número entero positivo mayor a CERO...") }
}
let factorialNum = -7
console.log(`${factorialNum} factorial (${factorialNum}!) es:`)
factorial(factorialNum)

factorialNum = 0
console.log(`${factorialNum} factorial (${factorialNum}!) es:`)
factorial(factorialNum)

factorialNum = 1
console.log(`${factorialNum} factorial (${factorialNum}!) es:`)
factorial(factorialNum)

factorialNum = 7
console.log(`${factorialNum} factorial (${factorialNum}!) es:`)
factorial(factorialNum)

// 5) Crear una función que muestre todos los números de la secuencia de fibonacci hasta el valor ingresado por parámetro.
const fibo = limit => {
  if(limit >= 1) {
    let fiboA = 0
    let fiboB = 1
    let fiboC = 1
  
    console.log(`fiboZero: ${fiboA}`)
    console.log(`fiboOne: ${fiboB}`)
  
    while(fiboC <= limit) {
      console.log(`fiboSecuence (${fiboB}+${fiboA}): ${fiboC}`)
      fiboA = fiboB
      fiboB = fiboC
      fiboC = fiboA + fiboB
    }
  } else { console.log("Ups... Ingresa un número entero positivo mayor a CERO...") }
}

let fiboNum = 0
console.log(`La secuencia de Fibonacci *HASTA* ${fiboNum} es:`)
fibo(fiboNum)
fiboNum = 1
console.log(`La secuencia de Fibonacci *HASTA* ${fiboNum} es:`)
fibo(fiboNum)
fiboNum = 33
console.log(`La secuencia de Fibonacci *HASTA* ${fiboNum} es:`)
fibo(fiboNum)
fiboNum = 34
console.log(`La secuencia de Fibonacci *HASTA* ${fiboNum} es:`)
fibo(fiboNum)