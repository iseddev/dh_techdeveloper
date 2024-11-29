import { useMemo, useState } from "react";
import { db } from "../database/db";

// Create this function outside the component, so it doesn't get recreated on every render
const getAverage = (list) => {
	console.log("Calculando Average");
	const length = list.length;
	const sum = list.reduce((a, b) => a + b.amount, 0);
	return sum / length;
};

const Statistics = () => {
	const [show, setShow] = useState(false);

	// Calculate the average on every render
	// const average = getAverage(db);

	// Use useMemo() to avoid recalculating the average on every render
	const average = useMemo(() => getAverage(db), []);

	console.log("Renderizado de Statistics");

	const handleClickShow = () => setShow(!show);

	return (
		<div>
			{show && <h2>Statics, average: {average}</h2>}
			{/* Show in console the rendering of this component, but with useMemo, we avoid to re-calculate the arithmetic operation */}
			<button onClick={handleClickShow}>{show ? "Hide" : "Show"}</button>
		</div>
	);
};
export default Statistics;
