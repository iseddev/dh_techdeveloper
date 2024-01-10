const notas = [10, 4, 5, 8, 9, 2, 7]

const notasHastaCienConMap = notas.map(el => el * 10)
console.log(notasHastaCienConMap)

notas.forEach(num => console.log(num * 10))


// ############### Ejercicio clase ###############

// Para este ejercicio tenemos el array listaDeSupermercado. Nuestro trabajo será mostrar cada ítem de esa lista por consola utilizando un foreach.

const listaDeSuperMercado = [
  'Bife de chorizo', 
  'Coca Cola', 
  'Bananas', 
  'Lechuga', 
  'Chimichurri', 
  'Lata de tomates', 
  'Arvejas', 
  'Cereales', 
  'Pechuga de pollo', 
  'Leche'
]

listaDeSuperMercado.forEach(el => console.log(el))