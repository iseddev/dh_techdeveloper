# Pruebas de Componentes con Jest

## Configuraciones iniciales

### Elementos principales

1. Editor de Texto: [Visual Studio Code](https://code.visualstudio.com)
2. Runtime: [Node.js](https://nodejs.org/es/)
3. Framework de pruebas: [Jest](https://jestjs.io/)

### Configuración y ejecución de pruebas

1. Instalación de Jest - En la carpeta donde vayamos a trabajar, debemos instalar el paquete de Jest.

```bash
npm i -D jest
```

2. Una vez instalado, podemos configurar el archivo `package.json` para que Jest se ejecute con el comando `npm test`.

```json
{
  "scripts": {
    // ...
    "test": "jest"
    // ...
  }
}
```

3. Para ejecutar las pruebas con Jest, vamos a crear la carpeta/directorio `__tests__` en la raíz del proyecto y dentro de ella, vamos a crear un archivo con la terminación de extensión `.test.js`, por ejemplo: `app.test.js`.

4. Para poder ejecutar las pruebas, primero debemos exportar la función (o funciones) que vamos a probar que se encuentran en el archivo origen, por ejemplo: `app.js`.

```javascript
// app.js
exports.generateText = (name, age) => return `${name} (${age} years old)`
```

5. Importamos las funciones en el archivo de pruebas y las utilizamos para realizar los test correspondientes.

```javascript
// app.test.js
const { generateText } = require("../app");
```

6. Desarrollamos las pruebas correspondientes de acuerdo a lo que se necesite testear, para ello, utilizamos las funciones predeterminadas de Jest

```javascript
// app.test.js
const { generateText } = require("../app");

test("Salida de Nombre y Edad", () => {
  const text = generateText("Daniel", 30)
  expect(text).toBe("Daniel (30 years old)")
})
```

7. Ejecutar las pruebas con el comando configurado en el `package.json`, en este caso: `npm test`.

8. Para mantener las pruebas actualizadas, podemos agregar a nuestro script la directiva `--watch` ==> `"test": jest --watch` para que Jest esté pendiente de los cambios en los archivos y ejecute las pruebas automáticamente.