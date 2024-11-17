// Destructuring
const user = {
	name: "John",
	age: 30,
};

// Order doesn't matter
const { age, name } = user;
console.log(name);
console.log(age);

// Order is important
const fruits = ["apple", "banana", "orange"];
const [first, second, third] = fruits;
console.log(first);
console.log(second);
console.log(third);

const languages = ["JavaScript", "Python", "Java", "Rust", "Go"];
const [js, _, java, rust, go] = languages;
console.log(js);
console.log(java);
console.log(rust);
console.log(go);

// Default parameter
const hello = (name = "John") => console.log(`Hello ${name}`);
hello();
hello("Alice");

// ##### Rest parameter #####
const even = [2, 4, 6, 8, 10];
const odd = [1, 3, 5, 7, 9];
const numbers = [...even, ...odd];
console.log(numbers);

const userOne = { name: "John" };
const userTwo = { ...userOne, age: 30 };
console.log(userTwo);

const sum = (...numbers) => numbers.reduce((acc, cur) => acc + cur, 0);
console.log(sum(1, 2, 3, 4, 5));
