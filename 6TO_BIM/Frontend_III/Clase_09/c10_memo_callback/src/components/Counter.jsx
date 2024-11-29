import { useCallback, useState } from "react";
import ButtonIncrement from "./ButtonIncrement";

const Counter = () => {
	const [count, setCount] = useState(0);

	// Function to increase the counter (it is created on each render)
	// const handleClickIncrement = () => {
	// 	setCount(count + 1);
	// };

	// Function to increase the counter (it is created on each render)
	// const handleClickIncrement = useCallback(() => {
	// 	setCount(count + 1);
	// }, [count]);

	// To fix the issue we need to use useCallback to save the reference of the function in memory
	const handleClickIncrement = useCallback(() => {
		setCount((prevState) => prevState + 1);
	}, []);

	console.log("Parent component Counter rendered");

	return (
		<div>
			<p>Count: {count}</p>
			{/* The component below is called from a memo of React */}
			<ButtonIncrement onClick={handleClickIncrement} />
		</div>
	);
};
export default Counter;
