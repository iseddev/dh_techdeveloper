import { useState, useCallback, memo } from "react";

const Button = ({ handleClick, name }) => {
	console.log(`Rendered component: ${name}`);
	return <button onClick={handleClick}>{name}</button>;
};

// The Button component is wrapped with the memo function to avoid re-rendering the Button components every time the state of the parent component changes.
const MemorizedButton = memo(Button);

const UseCallback = () => {
	console.log(`UseCallback parent component rendered`);
	const [countOne, setCountOne] = useState(0);
	const [countTwo, setCountTwo] = useState(0);

	const memorizedCountOne = useCallback(() => setCountOne((prevState) => prevState + 1), []);
	const memorizedCountTwo = useCallback(() => setCountTwo((prevState) => prevState + 1), []);

	return (
		// The Button components are re-rendered every time the state of the parent component changes.
		// <>
		// 	<div>{countOne}</div>
		// 	<Button handleClick={() => setCountOne(countOne + 1)} name="ButtonOne" />
		// 	<div>{countTwo}</div>
		// 	<Button handleClick={() => setCountTwo(countTwo + 1)} name="ButtonTwo" />
		// </>

		// To avoid re-rendering the Button components, we can use the useCallback hook to memorize the functions that are passed as props to the Button components.
		<>
			<div>{countOne}</div>
			<MemorizedButton handleClick={memorizedCountOne} name="MemorizedButtonOne" />
			<div>{countTwo}</div>
			<MemorizedButton handleClick={memorizedCountTwo} name="MemorizedButtonTwo" />
		</>
	);
};

export default UseCallback;
