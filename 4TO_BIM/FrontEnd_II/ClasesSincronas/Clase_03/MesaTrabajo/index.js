// // 👇Acá vemos que el document nos dá acceso a todo el DOM, ese árbol que contiene todos los nodos de nuestro sitio
// console.log(document);

// // Ahora vamos a utilizar 2 métodos propios de document que nos facilitan "pescar" elementos en el sitio:
// // - querySelector()
// // - querySelectorAll()

// // Obtenemos el titulo principal
// const titulo = document.querySelector('h1');
// // Ahora vayamos a la consola y despleguemos la flecha que nos muestra todas las propiedades del nodo
// console.log(titulo);

// // nos traemos ahora un listado de nodos 👇
// const itemsMenu = document.querySelectorAll('li');
// console.log(itemsMenu);

// // hacemos un selector más específico👇
// const infoExtra = document.querySelector('.info .clima')
// console.log(infoExtra);

// /* ------------------------------- Practicando ------------------------------ */
// // Seleccionamos la lista de noticias y revisamos su información interna.
// // Aprovechamos que la NodeList es un ITERABLE, entonces podemos recorrerla.
// // 🚩 No es un Array.
// const articulos = document.querySelectorAll('article');

// for (let i = 0; i < articulos.length; i++) {
//     console.log(articulos[i]);
// }

// // Ahora hacemos la misma practica pero con ForEach, y accedemos a propiedades de los nodos.
// articulos.forEach( articulo =>{
//     const titulo = articulo.querySelector('h2').innerText;
//     console.log(titulo);
//     // 💡 si quisiéramos, acá podemos mutar los nodos, o cambiar algunas de sus propiedades
// });


/* -------------------------------------------------------------------------- */
/*                          CONSIGNA MESA DE TRABAJO                          */
/* -------------------------------------------------------------------------- */
// 1 - Escribir un selector para cada elemento del sitio.
const d = document

const body = d.querySelector('body')
console.log(body)


// ########## HEADER ##########
const header = d.querySelector('header')
console.log(header)

// Elementos dentro de header
const headerH1 = d.querySelector('header h1')
console.log(headerH1)

const headerNav = d.querySelector('header nav')
console.log(headerNav)

const navUl = d.querySelector('nav ul')
console.log(navUl)

const navUlLi = d.querySelectorAll('nav ul li')
navUlLi.forEach(li => console.log(li))

const divTema = d.querySelector('.tema')
console.log(divTema)

const divTemaBtn = d.querySelector('.tema button')
console.log(divTemaBtn)

const divInfo = d.querySelector('.info')
console.log(divInfo)

const divInfoClima = d.querySelector('.info .clima')
console.log(divInfoClima)

const divInfoDolar = d.querySelector('.info .dolar')
console.log(divInfoDolar)


// ########## MAIN ##########
const main = d.querySelector('.noticias')
console.log(main)

// Elementos dentro del main(.noticias)
const mainArticles = d.querySelectorAll('main article')
mainArticles.forEach(article => console.log(article))

const mainArticleH2 = d.querySelectorAll('main article h2')
mainArticleH2.forEach(h2 => console.log(h2))

const mainArticleImg = d.querySelectorAll('main article img')
mainArticleImg.forEach(img => console.log(img))

const mainArticleP = d.querySelectorAll('main article p')
mainArticleP.forEach(p => console.log(p))


// ########## FOOTER ##########
const footer = d.querySelector('footer')
console.log(footer)


// 2 - Plasmarlo en un diagrama de árbol como la consigna: https://docs.google.com/document/d/15nGvKkEcbrRgwqV50ISh0QYZ_TO67vmWQaLfNpUxqjs/preview