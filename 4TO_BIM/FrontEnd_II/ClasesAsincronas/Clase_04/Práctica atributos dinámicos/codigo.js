const d = document

//1- Agregar a la tarjeta, el atributo "class" con el valor "card"
d.querySelector("#tarjeta").classList.add("card")

//2- Agregar a la imagen, el atributo "src" con el valor "https://www.youtube.com/img/desktop/yt_1200.png"
d.querySelector("#logo").setAttribute("src", "https://www.youtube.com/img/desktop/yt_1200.png")

//3- Quitarle al titulo la clase que le está dando un formato feo
d.querySelector("h1").classList.remove("titulo-feo")

//4- Chequear si el link a youtube posee o no el atributo href
const hasHref = d.querySelector("#link_youtube").hasAttribute("href")
console.log(`Youtube link has href? ${hasHref}`)

//5- Obtener el href del link a wikipedia y mostrarlo por consola
const wikiHref = d.querySelector("#link_wikipedia").getAttribute("href")
console.log(wikiHref)