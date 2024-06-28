const { generateText, validateInput } = require("../util")

describe("Pruebas EXITOSAS => generateText(name, age, level)", () => {
  test("Datos: name = 'Max', age = 29, level = 'Intermedio'", () => {
    const text = generateText("Max", 29, "Intermedio")
    expect(text).toBe("Registro OK de Max en: Intermedio.")
  })
  test("Datos: name = 'Max', age = 100, level = 'Básico'", () => {
    expect(generateText("Max", 100, "Básico"))
    .toBe("No pudimos registrar a: Max. Por favor contacta a soporte@dh.com para más información.")
  })
  test("Datos: name = 'Max', age = 5, level = 'Básico'", () => {
    expect(generateText("Max", 5, "Básico"))
      .toBe("Edad ingresada no válida. Por favor intenta nuevamente.")
  })
})

describe("Pruebas FALLIDAS => generateText(name, age, level)", () => {
  test("Datos: name = 'Max', age = 5, level = 'Intermedio'", () => {
    expect(generateText("Max", 5, "Intermedio"))
      .toBe("Registro OK de Max en: Intermedio.")
  })
  test("Datos: name = 'Max', age = 100, level = 'Básico'", () => {
    expect(generateText("Max", 100, "Básico"))
    .toBe("Registro OK de Max en: Básico.")
  })
  test("Datos: name = 'Max', age = 5, level = 'Avanzado'", () => {
    const text = generateText("Max", 5, "Avanzado")
    expect(text).toBe("Registro OK de Max en: Avanzado.")
  })
})

describe("Pruebas EXITOSAS => validateInput(text, notEmpty)", () => {
  test("Prueba: validateInput('Max', true)", () => {
    expect(validateInput("Max", true)).toBe(true)
  })
  test("Prueba: validateInput(false, false)", () => {
    expect(validateInput(false, false)).toBe(false)
  })
  test("Prueba: validateInput(' ', true)", () => {
    expect(validateInput(" ", true)).toBe(false)
  })
})

describe("Pruebas FALLIDAS => validateInput(text, notEmpty)", () => {
  test("Prueba: validateInput(null, null)", () => {
    expect(validateInput(null, null)).toBe(true);
  })
  test("Prueba: validateInput(' ', true)", () => {
    expect(validateInput(" ", true)).toBe(true);
  })
  test("Prueba: validateInput('     text     ', true)", () => {
    expect(validateInput("     text     ", true)).toBe(false);
  })
})