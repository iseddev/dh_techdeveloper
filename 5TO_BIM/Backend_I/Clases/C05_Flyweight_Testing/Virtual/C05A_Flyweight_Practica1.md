# ¡Vamos a practicar!

Pensemos en un sistema para agregar canciones a una lista de reproducción.

Una canción está compuesta por:

* Nombre.
* Artista.
* Género.

Una lista de reproducción está compuesta por:

* Nombre.

Para agregar una canción es necesario crear la lista de reproducción. Se podrá eliminar y obtener canciones.

**CancionFactory** será el lugar donde se almacenarán las canciones. Permitirá, antes de crear el objeto, validar si ya existe uno idéntico al que se le está solicitando. De ser así, regresa el objeto existente; de no existir, crea el nuevo objeto y lo almacena en caché para ser reutilizado más adelante.

También nos gustaría poder ver por consola las listas de reproducción.

Te proponemos realizar diagrama UML e implementación en JAVA.
