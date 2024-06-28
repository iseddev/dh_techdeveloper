

// hasAttribute
// getAttribute

// setAttribute
const div = document.querySelector(".container")
console.log(div)

const img = document.querySelector("img")
div.appendChild(img)
img.setAttribute("src", "https://placekitten.com/200/300")
img.setAttribute("alt", "gatito")