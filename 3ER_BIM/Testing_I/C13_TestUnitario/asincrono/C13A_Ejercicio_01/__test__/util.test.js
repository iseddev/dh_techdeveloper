const { generateText, validateInput, createElements } = require('../util.js')

describe('Pruebas de salida de datos', () => {
    test('Salida con datos', () => {
        const text = generateText('Daniel',30)
        expect(text).toBe('Daniel (30 years old)')
    })
      
    test('Salida con datos vacíos', () => {
        const text = generateText('',null)
        expect(text).toBe(' (null years old)')
    })
    
    test('Salida sin datos', () => {
        const text = generateText()
        expect(text).toBe('undefined (undefined years old)')
    })

    test("Validar input", () => {
        const text = validateInput("Texto validar input", true, true)
        expect(text).toBe(true)
    })
})