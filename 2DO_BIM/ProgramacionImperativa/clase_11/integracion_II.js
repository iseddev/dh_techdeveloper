/* 
Punto 1: Variables, Condicionales y Bucles
Escribe una función llamada encontrarMultiplos que tome dos números, numero y limite, y devuelva un arreglo con los múltiplos de numero hasta el limite, excluyendo el límite.
Luego, utiliza la función encontrarMultiplos para obtener los múltiplos de 5 hasta 50.
*/
//CÓDIGO
const encontrarMultiplos = (num, limit) => {
  const multiples = []
  let product = 0
  for(let i = 1; product < limit; i++) {
    product = num * i
    multiples.push(product)
  }
  return multiples
}

// Luego, utiliza la función encontrarMultiplos para obtener los múltiplos de 5 hasta 50.
console.log(`===== Múltiplos de 5 hasta 50 =====`)
console.log(encontrarMultiplos(5, 50))


/* 
Punto 2: Arreglos y Objetos
3. Crea un arreglo de 4 objetos, cada objeto representa un estudiante con propiedades como nombre, notas (arreglo de números) y aprobado (booleano).
Agrega un método al objeto para calcular si el estudiante aprobó o no, considerando que aprueba si su promedio de notas es mayor o igual a 70.
*/
// Crear arreglo de 4 objetos estudiantes
const estudiantes = [
  {
    nombre: "Juan",
    notas: [60, 80, 80, 90, 70, 40],
    aprobado: false,
  },
  {
    nombre: "Pedro",
    notas: [80, 80, 50, 60, 80, 50],
    aprobado: false,
  },
  {
    nombre: "Luis",
    notas: [90, 50, 80, 90, 70, 60],
    aprobado: false,
  },
  {
    nombre: "Antonio",
    notas: [50, 60, 80, 60, 90, 50],
    aprobado: false,
  },
]

// Función para calcular el promedio de notas
const getAverage = arr => {
  let sum = 0
  arr.forEach(note => sum += note)
  let average = Math.round(sum / arr.length)
  return average
}

// Función para determinar si el estudiante aprobó
const isAproved = average => average >= 70

// Calcular si los estudiantes aprobaron o no
const validateEstudents = estudiantes.map(obj => {
  let average = getAverage(obj.notas)
  let aproved = isAproved(average)
  const validated = {
    nombre: obj.nombre,
    promedio: average,
    esAprobado: aproved
  }
  return validated
})
console.log(`\n===== Validación de aprobación de los estudiantes =====`)
console.log(validateEstudents)

 
// Punto 3: Arreglos y Bucles
// 7. Crea un arreglo de números y utiliza un bucle while para calcular la suma de los números pares en el arreglo.
const nums = [1, 8, 45, 98, 65, 25, 56, 35, 57, 58, 18]

let i = 0
let evenSum = 0
while(i < nums.length) {
  nums[i] % 2 === 0 ? evenSum += nums[i] : evenSum
  i++
}
console.log(`\n===== Suma de numeros pares =====`)
console.log(evenSum)

// Punto 4: Bucles y Arreglos
// 10. Crea una función que tome un arreglo de números y devuelva el producto de los números impares.
const oddProduct = arr => {
  let product = 1
  arr.forEach(num => num % 2 !== 0 ? product *= num : product)
  return product
}
let product = oddProduct(nums)
console.log(`\n===== Producto de numeros impares =====` )
console.log(product)
// ********** Respuesta y Explicación **********
// 1. La función oddProduct(arr) recibe un array de números
// 2. Dentro de la función definimos la variable product y le asignamos el valor de 1, y nos servirá para ir almacenando el resultado de las multiplicaciones realizadas
// 3. Se utiliza el método forEach() para recorrer el array recibido como parámetro y acceder a cada uno de los elementos de dicho array
// 4. Validamos con el operador ternario que cada elemento sea impar mediante num % 2 !== 0 (ya que si num % 2 === 0, entonces es par) y realizamos la multiplicación correspondiente con product *= num
// 5. Al finalizar, sólo retornamos el valor de product para ser utilizado como lo necesitemos


// Punto 5: Objetos y Condicionales
// 11. Crea un objeto vehiculo con propiedades como marca, modelo, anio y precio.
const vehiculo = {
  marca: "Renault",
  modelo: "Sandero",
  anio: 2011,
  precio: 80000,
  // Agrega un método al objeto que calcule el impuesto a pagar según el año del vehículo. Si el año es anterior a 2010, el impuesto es del 10% del precio; si es posterior o igual a 2010, el impuesto es del 5%.
  impuestoPagar: function() {
    let impuesto = 0
    this.anio < 2010 ? impuesto = 10 : impuesto = 5
    return impuesto
  }
}
console.log(`Impuesto a pagar: ${vehiculo.impuestoPagar()}%`)