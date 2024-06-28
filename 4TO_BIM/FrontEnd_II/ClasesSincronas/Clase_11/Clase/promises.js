let test = true

const promise = new Promise( (resolve, reject) => test ? resolve('Success') : reject('Error') )

promise
  .then((response) => console.log(response))
  .catch((error) => console.log(error))


const newPromise = (success) => {
  return new Promise( (resolve, reject) => {
    success
      ? resolve(["a", "b", "c", "d"])
      : reject("No se pudo obtener el array")
  })
}

newPromise(false)
  .then((response) => console.log(response))
  .catch((error) => console.log(error))

const countries = [
  {
    name: "México",
    capitalCity: "México"
  },
  {
    name: "Argentina",
    capitalCity: "Buenos Aires"
  },
  {
    name: "Colombia",
    capitalCity: "Bogotá"
  },
  {
    name: "Perú",
    capitalCity: "Lima"
  },
  {
    name: "Venezuela",
    capitalCity: "Caracas"
  },
  {
    name: "Chile",
    capitalCity: "Santiago"
  },
  {
    name: "Ecuador",
    capitalCity: "Quito"
  },
  {
    name: "Bolivia",
    capitalCity: "La Paz"
  },
  {
    name: "Paraguay",
    capitalCity: "Asunción"
  },
  {
    name: "Uruguay",
    capitalCity: "Montevideo"
  },
  {
    name: "Brasil",
    capitalCity: "Brasilia"
  },
]

const obtenerPaises = (success) => {
  return new Promise( (resolve, reject) => {
    success
      ? setTimeout(() => resolve(countries), 2000)
      : reject("No se pudo obtener los países")
  })
}

obtenerPaises(true)
  .then((response) => {
    console.log(response)
    const body = document.querySelector('body')
    const ul = document.createElement('ul')
    response.forEach((country) => {
      const li = document.createElement('li')
      li.innerText = `País: ${country.name} - Capital: ${country.capitalCity}`
      ul.appendChild(li)
    })
    body.appendChild(ul)
  })
  .catch((error) => console.log(error))


const urlApiCat = "https://api.thecatapi.com/v1/images/search?limit=10"
fetch(urlApiCat)
  .then((response) => response.json())
  .then((data) => {
    console.log(data)
    data.forEach((cat) => {
      const img = document.createElement('img')
      img.src = cat.url
      img.style.width = "200px"
      img.setAttribute('alt', `Gato ${cat.id}`)
      document.body.appendChild(img)
    })
  })
  .catch((error) => console.log(error))


// ########## Async-Await ##########
const getCountries = async () => {
  let response = await obtenerPaises(true)
  console.log(response)
  const ul = document.createElement("ul")
  response.forEach(country => {
    ul.innerHTML += `<li>Country: ${country.name} - Capital City: ${country.capitalCity}</li>`
  })
}
getCountries()