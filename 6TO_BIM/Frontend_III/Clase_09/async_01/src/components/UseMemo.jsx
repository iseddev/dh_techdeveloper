import { useState, memo } from "react";

// Create a component that receives a state and a name as props and displays the state.
const ShowState = ({ state, name }) => {
	console.log(`Rendered component: ${name}`);
	return <div>{state}</div>;
};

// Wrap the ShowState component with the memo function to avoid re-rendering the component every time the state of the parent component changes.
const MemoShowState = memo(ShowState);

const UseMemo = () => {
	const [counter, setCounter] = useState(0);
	const [state, setState] = useState("");

	console.log(`UseMemo component re-render counter: ${counter}`);

	const changeCounter = () => {
		setCounter(counter + 1);
	};
	const changeState = () => {
		setState(state === "ON" ? "OFF" : "ON");
	};

	return (
		<div>
			<h2>useMemo sample</h2>
			<div>
				<MemoShowState state={state} name={"MemoShowState"} />
			</div>
			<div>
				<button onClick={changeCounter}>Re-render</button>
				<button onClick={changeState}>Change state</button>
			</div>
		</div>
	);
};

export default UseMemo;
