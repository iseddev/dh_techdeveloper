console.log("Mensaje que se mostrará en la consola del navegador")

console.error("Mensaje de error que se mostrará en la consola del navegador")

console.warn("Mensaje de advertencia que se mostrará en la consola del navegador")

const myObj = {
  message: "This is a text message",
  utility: "JS testing"
}

const myArr = ["First array element", "Second array element", "Third array element"]

console.table(myObj)
console.table(myArr)

let num = 5
let strNum = "5"
console.log(num == strNum)
console.log(num === strNum)