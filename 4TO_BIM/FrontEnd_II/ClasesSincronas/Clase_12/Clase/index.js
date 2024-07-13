window.addEventListener("load", () => {
  const listSection = document.querySelector("#list-container")


  // ===== Repasando método fetch() con .then() =====
  const urlCartoons = "https://api.sampleapis.com/cartoons/cartoons2D"
  fetch(urlCartoons)
    .then(res => res.json())
    .then(data => {
      console.log(data.length)
      if (data.length > 0) {
        data.forEach(item => {
          listSection.innerHTML += `
            <div class='card'>
              <h3>${item.title}</h3>
              <img src=${item.image} alt=${item.title} width='200'>
            </div>`
        })
      }
    })
    .catch(err => console.log(err))
    .finally(() => {
      const loader = document.querySelector(".loader")
      loader.remove()
    })


  // ===== Mismo ejemplo que el anterior pero con async/await y try/catch =====
  const getCartoon = async () => {
    try {
      const res = await fetch(urlCartoons) // Consulta a la API
      console.log(res)
      const data = await res.json() // Parseo de la respuesta
      console.log(data)
      if (data.length > 0) {
        data.forEach(item => {
          listSection.innerHTML += `
            <div class='card'>
              <h3>${item.title}</h3>
              <img src=${item.image} alt=${item.title} width='200'>
            </div>`
        })
      }
    }
    catch (err) { console.log(err) }
    // Comentamos puesto que se aplicó en el ejercicio anterior
    // finally {
    //   const loader = document.querySelector(".loader")
    //   loader.remove()
    // }
  }
  getCartoon()


  // ===== Otro ejemplo con otra API y le sumamos Sweetalert =====
  const urlRick = "https://rickandmortyapi.com/api/character"
  const getCharacters = async () => {
    try {
      const res = await fetch(urlRick)
      // Usando destructuring para obtener solo los datos que necesitamos
      const { info, results } = await res.json()
      console.log(results)
      if (results) {
        // Comentamos puesto que se aplicó en el primer ejercicio
        // const loader = document.querySelector(".loader")
        // loader.remove()
        results.forEach(character => {
          listSection.innerHTML += `
            <div class='card'>
              <h3>${character.name}</h3>
              <img src=${character.image} alt=${character.name} width='200'>
            </div>`
        })
      }
    } catch (err) {
      // Aplicando el uso de SweetAlert
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: err,
        footer: `No se pudieron obtener los personajes`,
      })
    }
  }
  getCharacters()


  // ===== Ejemplo de método POST con fetch() =====
  const endpoint = "https://jsonplaceholder.typicode.com/posts"
  // Creamos un objeto con los datos que queremos enviar
  const data = {
    title: "Titulo enviado desde Postman",
    body: "Tiene todo este contenido",
    userId: 11,
  }
  // Configuramos el método POST
  const config = {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-type": "application/json" }
  }
  // Hacemos la petición y mostramos la respuesta
  fetch(endpoint, config)
    .then(response => response.json())
    .then(json => console.log(json))
    .catch(err => console.log(err))
})