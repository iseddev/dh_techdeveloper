const { generateText } = require("../util")

test("Salida de Nombre y Edad", () => {
  const text = generateText("Daniel", 30)
  expect(text).toBe("Daniel (30 years old)")
})

describe("Pruebas de salidas de datos", () => {
  test("Salida de Nombre y Edad", () => {
    const text = generateText("Daniel", 30)
    expect(text).toBe("Daniel (30 years old)")
    const text2 = generateText("Anas", 25)
    expect(text2).toBe("Ana (25 years old)")
  })

  it("Salida con datos vacíos", () => {
    const text = generateText("", null)
    expect(text).toBe(" (null years old)")
  })

  test("Salida sin datos", () => {
    const text = generateText()
    expect(text).toBe("undefined (undefined years old)")
  })
})