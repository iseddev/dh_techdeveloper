// 
let test = true

// resolve => En caso de que la promesa se resuelva satisfactoriamente, reject => En caso de que la promesa no se resuelva satisfactoriamente
const promise = new Promise( (resolve, reject) => test ? resolve('Promise resolved satisfactorily') : reject('Promise resolved unsatisfactorily') )

// En este caso, promise es una solicitud asíncrona, por lo que no se ejecutará inmediatamente, sino que se ejecutará en un futuro. Por lo que se deben aplicar métodos que permitan la continuidad de la ejecución del código mientras se espera la respuesta de la promesa
// Con .then() accedemos al valor que se resuelve en la promesa y con .catch() capturamos el posible error en el resultado de la promesa y de esta forma, podemos continuar con la ejecución del código 
promise
  .then(response => console.log(response))
  .catch(error => console.log(error))

const newPromise = success => {
  return new Promise( (resolve, reject) => {
    success
      ? resolve(["a", "b", "c", "d"])
      : reject("No se pudo obtener el array")
  })
}

newPromise(true)
  .then((response) => console.log(response))
  .catch((error) => console.log(error))

newPromise(false)
  .then((response) => console.log(response))
  .catch((error) => console.log(error))


// ########## Ejemplo de promesas con fetch ##########
const countries = [
  { name: "México", capitalCity: "México" },
  { name: "Argentina", capitalCity: "Buenos Aires" },
  { name: "Colombia", capitalCity: "Bogotá" },
  { name: "Perú", capitalCity: "Lima" },
  { name: "Venezuela", capitalCity: "Caracas" },
  { name: "Chile", capitalCity: "Santiago" },
  { name: "Ecuador", capitalCity: "Quito" },
  { name: "Bolivia", capitalCity: "La Paz" },
  { name: "Paraguay", capitalCity: "Asunción" },
  { name: "Uruguay", capitalCity: "Montevideo" },
  { name: "Brasil", capitalCity: "Brasilia" },
]

const getCountries = (success) => {
  return new Promise( (resolve, reject) => {
    success
      ? setTimeout(() => resolve(countries), 2000)
      : reject("No se pudo obtener los países")
  })
}

const main = document.querySelector('main')

getCountries(true)
  .then(response => {
    console.log(response)
    const ul = document.createElement('ul')
    response.forEach(country => {
      const li = document.createElement('li')
      li.innerText = `País: ${country.name} - Capital: ${country.capitalCity}`
      ul.appendChild(li)
      // Otra forma de agregar los elementos li al elemento ul
      // ul.innerHTML += `<li>País: ${country.name} - Capital: ${country.capitalCity}</li>`
    })
    main.appendChild(ul)
  })
  .catch(error => console.log(error))


// Utilización de fetch() (retorna una promise) para el acceso y manejo de API's
const urlApiCat = "https://api.thecatapi.com/v1/images/search?limit=10"
fetch(urlApiCat)
  .then(response => response.json()) // Convertimos la respuesta a un objeto JSON, esto retorna también una promise
  .then(data => { // Al obtener una promise de la respuesta anterior, "cacheamos" esta promise con otro método .then()
    console.log(data)
    data.forEach(cat => {
      const img = document.createElement('img')
      img.src = cat.url
      img.style.width = "200px"
      img.setAttribute('alt', `Gato ${cat.id}`)
      // Otra manera de hacer lo anterior
      // main.innerHTML += `<img src="${cat.url}" alt="Gato ${cat.id}" width="200">`
      document.body.appendChild(img)
    })
  })
  .catch(error => console.log(error))

/* 
// Utilizando validaciones dentro de la promesa
fetch(urlApiCat)
  .then(response => if (response.ok) { return response.json() })
  .then(data => { // Al obtener una promise de la respuesta anterior, "cacheamos" esta promise con otro método .then()
    if(data) {
      console.log(data)
      data.forEach(cat => main.innerHTML += `<img src="${cat.url}" alt="Gato ${cat.id}" width="200">` )
    } else { console.log("No se pudo obtener la información") }
  })
  .catch(error => console.log(error))
*/


// ########## async - await ##########
const asyncGetCountries = async () => {
  let response = await getCountries(true)
  console.log(response)
  const ul = document.createElement("ul")
  response.forEach(country => ul.innerHTML += `<li>Country: ${country.name} - Capital City: ${country.capitalCity}</li>` )
  main.appendChild(ul)
}
asyncGetCountries()