const jsonData = `
{
  "squadName": "Super hero squad",
  "homeTown": "Metro City",
  "formed": 2016,
  "secretBase": "Super tower",
  "active": true,
  "members": [
    {
      "name": "Molecule Man",
      "age": 29,
      "secretIdentity": "Dan Jukes",
      "powers": ["Radiation resistance", "Turning tiny", "Radiation blast"]
    },
    {
      "name": "Madame Uppercut",
      "age": 39,
      "secretIdentity": "Jane Wilson",
      "powers": [
        "Million tonne punch",
        "Damage resistance",
        "Superhuman reflexes"
      ]
    },
    {
      "name": "Eternal Flame",
      "age": 1000000,
      "secretIdentity": "Unknown",
      "powers": [
        "Immortality",
        "Heat Immunity",
        "Inferno",
        "Teleportation",
        "Interdimensional travel"
      ]
    }
  ]
}
`;

//Recorrer el JSON e insertar en el listado del html los nombres de los miembros
function recorrerMiembros() {
  //escribe la lógica

  // Convertimos el JSON en un objeto JS
  const data = JSON.parse(jsonData)
  // Extraemos el array de miembros
  const { members } = data
  // Capturamos el selector(ul) donde se van a insertar los nombres de los miembros
  const listado = document.getElementById('miembros')
  // Recorremos el array members y por cada uno de ellos insertamos un elemento li con el nombre del miembro
  members.forEach(member => listado.innerHTML += `<li>${member.name}</li>` )
}

recorrerMiembros();