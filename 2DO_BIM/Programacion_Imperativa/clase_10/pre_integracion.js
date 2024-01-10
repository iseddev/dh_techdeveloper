// Integración de contenido:

// 1) Crear un array llamado misMascotas
let misMascotas = [
    // 2) Dentro de este array crearemos un objeto literal para cada mascota. Cada objeto deberá tener: 
    //     nombre
    //     raza
    //     edad 
    //     sonido
    //     un método que nos retorne ese sonido 2 veces 
    {
        nombre: "Firulais",
        raza: "Pug",
        edad: 3,
        sonido: "guau",
        sonidoDoble: function() {
            return `${this.sonido} ${this.sonido}`
        },
    },
    {
        nombre: "Rocky",
        raza: "Doberman",
        edad: 8,
        sonido: "grrrrr",
        sonidoDoble: function() {
            return `${this.sonido} ${this.sonido}`
        },
    },
    {
        nombre: "Zeus",
        raza: "Pastor Alemán",
        edad: 12,
        sonido: "ahhhhh",
        sonidoDoble: function() {
            return `${this.sonido} ${this.sonido}`
        },
    }
]

// Cuando esté listo, verificar en consola
console.log(misMascotas[0].sonidoDoble())
console.log(misMascotas[1].sonidoDoble())

// 3) Deberemos crear una función que se llame aumentarEdad que aumente la edad de cada animal en 1.
let aumentarEdad = mascota => {
    for(i = 0; i < mascota.length; i++) {
        mascota[i].edad += 1
        console.log(mascota[i].edad)
    }
}
// aumentarEdad(misMascotas)

// 4) Ahora debemos crear otra función, que se llame  aumentarEdad2, que va a hacer un trabajo más fino:
let aumentarEdad2 = mascotas => {
    for(i = 0; i < mascotas.length; i++) {
        // Si la mascota tiene menos de 6 años, debe aumentar su edad en 1
        if(mascotas[i].edad < 6) {
            mascotas[i].edad += 1
            console.log(mascotas[i].edad)
            // Si la mascota tiene más de 10 años, deberá sumarle la mitad de su edad
        } else if(mascotas[i].edad > 10) {
            mascotas[i].edad += (mascotas[i].edad / 2)
            console.log(mascotas[i].edad)
            // Si la mascota tiene entre 6 y 10 años, debe aumentar su edad en 2
        } else {
            mascotas[i].edad += 2
            console.log(mascotas[i].edad)
        }
    }
}

// aumentarEdad2(misMascotas)

// 5) Ahora crearemos una función que va a generar un identificador (ID) en cada objeto, que será secuencial y que empezará en 1.
let identificador = arr => {
    for(i = 0; i < arr.length; i++) {
        arr[i].id = i + 1
        console.log(arr[i])
    }
}

identificador(misMascotas)