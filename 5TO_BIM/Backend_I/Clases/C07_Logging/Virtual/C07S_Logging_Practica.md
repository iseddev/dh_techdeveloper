# ¡Vamos a practicar!

Te proponemos resolver la siguiente actividad: Crear una aplicación donde tengamos dos Clases: Leon y Tigre. Cada una debe tener dos atributos:
    * nombre String
    * edad int

y para la Clase Leon vamos a agregar el atributo:
    * esAlfa boolean

Para los dos animales vamos a crear un método correr(), que va a loguear un info de que está corriendo y vamos a crear otro método que calcule si es mayor a 10 años y ser alfa, en caso de serlo, deberá loguear un info con la información.

También deberemos arrojar una Exception si la edad del animal es menor a cero y agregar un log de error. Creamos una clase main, donde creamos leones y tigres que cumplan que al correr y esMayorA10 ejecutan los métodos:

* public void correr()
* public void esMayorA10()

También debemos chequear que los logs existan.

La salida debe ser algo como:

[2021-07-18 18:27:46] [ INFO ] [Leon:37] El León Simba está corriendo
[2021-07-18 18:27:46] [ INFO ] [Leon:37] El León Bom está corriendo
[2021-07-18 18:27:46] [ ERROR] [Leon:45] La edad no puede ser negativa
[2021-07-18 18:27:46] [ ERROR] [Test:30] La edad del León Bom es incorrecta
java.lang.Exception
	at com.main.Leon.esMayorA10(Leon.java:46)
	at com.main.Test.main(Test.java:28)
[2021-07-18 18:27:46] [ INFO ] [Tigre:28] El Tigre está corriendo
[2021-07-18 18:27:46] [ INFO ] [Tigre:28] El Tigre está corriendo
