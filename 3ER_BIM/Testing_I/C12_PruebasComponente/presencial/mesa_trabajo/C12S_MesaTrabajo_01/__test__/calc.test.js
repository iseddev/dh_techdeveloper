const { suma, resta, multiplicacion, division } = require("../calc")

describe("Pruebas Calculadora", () => {

  // SUMA
  test("Suma caso 01 => 1 + 2 = 3", () => {
    expect(suma(1, 2)).toBe(3)
  })
  test("Suma caso 02 => 'a' + 8 = 0", () => {
    expect(suma("a", 8)).toBe(0)
  })
  test("Suma caso 03 => 5 + null = 0", () => {
    expect(suma(5, null)).toBe(0)
  })
  test("Suma caso 04 => undefined + 5 = 0", () => {
    expect(suma(undefined, 5)).toBe(0)
  })

  // RESTA
  test("Resta caso 01 => 5 - 2 = 3", () => {
    expect(resta(5, 2)).toBe(3)
  })
  test("Resta caso 02 => 'a' - 8 = 0", () => {
    expect(resta("a", 8)).toBe(0)
  })
  test("Resta caso 03 => 5 - null = 0", () => {
    expect(resta(5, null)).toBe(0)
  })
  test("Resta caso 04 => undefined - 5 = 0", () => {
    expect(resta(undefined, 5)).toBe(0)
  })
    
  // MULTIPLICACION
  test("Multiplicacion caso 01 => 5 * 2 = 10", () => {
    expect(multiplicacion(5, 2)).toBe(10)
  })
  test("Multiplicación caso 02 => 'a' * 8 = 0", () => {
    expect(multiplicacion("a", 8)).toBe(0)
  })
  test("Multiplicación caso 03 => 5 * null = 0", () => {
    expect(multiplicacion(5, null)).toBe(0)
  })
  test("Multiplicación caso 04 => undefined * 5 = 0", () => {
    expect(multiplicacion(undefined, 5)).toBe(0)
  })
  
  // DIVISION
  test("División caso 01 => 5 / 2 = 2.5", () => {
    expect(division(5, 2)).toBe(2.5)
  })
  test("División caso 02 => 'a' / 8 = 0", () => {
    expect(division("a", 8)).toBe(0)
  })
  test("División caso 03 => 5 / null = 0", () => {
    expect(division(5, null)).toBe(0)
  })
  test("División caso 04 => undefined / 5 = 0", () => {
    expect(division(undefined, 5)).toBe(0)
  })
  test("División caso 05 => 10 / 0 = 0", () => {
    expect(division(10, 0)).toBe(0)
  })
})