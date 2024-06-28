// ¿Cómo podrías ordenar la colección, de menor a mayor, considerando solo la estatura? Utiliza bubble sort.

const personas = [
	{
		nombre: "Dua",
		apellido: "Lipa",
		ocupacion: "cantante",
		estatura: 173
	},
	{
		nombre: "Ariana",
		apellido: "Grande",
		ocupacion: "cantante",
		estatura: 160
	},
	{
		nombre: "Taylor",
		apellido: "Swift",
		ocupacion: "cantante",
		estatura: 180
	},
	{
		nombre: "Kylie",
		apellido: "Minogue",
		ocupacion: "cantante",
		estatura: 169
	},
	{
		nombre: "Gwen",
		apellido: "Stefani",
		ocupacion: "cantante",
		estatura: 178
	},
]


const orderByHeight = arr => {
  const iterations = arr.length - 1
  for (let i = 0; i < iterations; i++) {
    for (let j = 0; j < iterations - i; j++) {
      if (arr[j].estatura > arr[j + 1].estatura) {
        let aux = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = aux;
      }
    }
  }
  return arr
}
console.log(orderByHeight(personas))