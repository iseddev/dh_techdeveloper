# Instalación de **Prompt Sync**

El objetivo de este proceso, es utilizar la herramienta de desarrollo PromptSync, que cuenta con la característica de permitirnos introducir valores por la consola o terminal, algo que por defecto no es posible en Node —pero sí en la terminal de un navegador como Google Chrome, por ejemplo—.  

De esta manera, podremos ejecutar nuestros programas, aplicaciones y código en general que realicemos en Node a lo largo de la materia que requieran de ingresar datos desde la linea de comandos (terminal).  

## Pasos a seguir

Para poder utilizar PromptSync dentro de las prácticas que así lo requieran, se recomienda seguir las siguientes indicaciones

1. Al tener abierto nuestro directorio(carpeta) donde vanos a trabajar, abrir la linea de comandos y posicionarnos en dicha carpeta.
2. Ya estando en la linea de comandos, ejecutar lo siguiente:
   ```powershell
   npm i -D prompt-sync
   ```
3. Lo anterior debió haber generado la carpeta `node_modules` y un archivo `package-lock.json`, lo que es un indicio de que ya se instaló `prompt-sync` en nuestro proyecto.
4. Ahora, para poder utilizar esta herramienta, es necesario que dentro de nuestro archivo JavaScript en donde estemos trabajando, agreguemos lo siguiente:
   ```js
   const prompt = require("prompt-sync")({ sigint: true })
   ```
5. Ahora, para validar que todo está funcionando correctamente, podemos ejecutar una instrucción en la terminal usando Node para ejecutar nuestro archivo JavaScript
   Por ejemplo:  
   **app.js**
   ```js
   const prompt = require("prompt-sync")({ sigint: true })

   let name = prompt("Ingresa tu nombre: ")
   console.log(`Hola ${name}, PromptSync está funcionando correctamente!!!`)
   ```
   Ejecución en línea de comandos
   ```powershell
   PS C:Users\john\Desktop\test> node app.js
   ```
   Resultado
   ```powershell
   PS C:Users\john\Desktop\test> node app.js
   Ingresa tu nombre: John
   Hola John, PromptSync está funcionando correctamente!!!
   PS C:Users\john\Desktop\test>
   ```