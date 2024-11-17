import FruitItem from "./FruitItem";

const fruits = ["apple", "banana", "cherry", "date", "elderberry"];
const title = "FruitShop Box";

const Store = () => {
	const fruitBoxes = () =>
		fruits.map((fruitName, index) => <FruitItem key={index} fruitName={fruitName} />);
	return (
		<>
			<h1>{title}</h1>
			<ul>{fruitBoxes()}</ul>
		</>
	);
};

export default Store;
