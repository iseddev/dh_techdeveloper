import { useState } from "react";

import styles from "./ItemCounter.module.css";

const ItemCounter = () => {
	const [counter, setCounter] = useState(0);

	const handleIncrement = () => {
		setCounter(counter + 1);
	};
	const handleDecrement = () => {
		setCounter(counter - 1);
	};

	return (
		<div className={styles.counterWrapper}>
			<button onClick={handleDecrement}>-</button>
			<span className={styles.counterNumber}>{counter}</span>
			<button onClick={handleIncrement}>+</button>
		</div>
	);
};

export default ItemCounter;
