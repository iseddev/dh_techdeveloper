function onClick() {
  if (inputsAreEmpty()) {
    label.textContent = 'Error: Uno o los dos inputs están vacíos.';
    return;
  }
  updateLabel();
}
function inputsAreEmpty() {
  if (getNumber1() === '' || getNumber2() === '') {
    return true;
  } else {
    return false;
  }
}
function updateLabel() {
  // Se "convierten" a enteros los valores de los inputs
  var addend1 = parseInt(getNumber1())
  var addend2 = parseInt(getNumber2())

  // Se valida que los valores de los inputs sean de tipo "number"
  isNaN(addend1) || isNaN(addend2)
    ? label.textContent = 'Error: One or both inputs are not a number.'
    : label.textContent = addend1 + ' + ' + addend2 + ' = ' + (addend1 + addend2);
}
function getNumber1() {
  return inputs[0].value;
}
function getNumber2() {
  return inputs[1].value;
}
var inputs = document.querySelectorAll('input');
var label = document.querySelector('p');
var button = document.querySelector('button');
button.addEventListener('click', onClick);
