import { useState, useEffect } from "react";
const Chocolates = () => {
	const [total, setTotal] = useState(2);

	useEffect(() => {
		const interval = setInterval(() => {
			setTotal((prevState) => prevState + 1);
		}, 1000);
		return () => clearInterval(interval);
	}, []);
	return (
		<>
			<h2>I want {total} chocolates!!!</h2>
			<hr />
		</>
	);
};

export default Chocolates;
