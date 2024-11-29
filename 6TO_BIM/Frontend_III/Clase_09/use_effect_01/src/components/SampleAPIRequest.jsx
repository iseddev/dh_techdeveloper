import { useState, useEffect } from "react";

const SampleAPIRequest = () => {
	const [characters, setCharacters] = useState([]);

	// This useEffect will run only once, when the component is mounted
	useEffect(() => {
		try {
			async function getCharacters() {
				const resp = await fetch("https://dragonball-api.com/api/characters");
				const data = await resp.json();
				setCharacters(data.items);
			}
			getCharacters();
		} catch (error) {
			console.log(error);
		}
	}, []);

	return (
		<>
			<h2>SampleAPIRequest</h2>
			<ul>
				{Array.isArray(characters) && characters.length > 0 ? (
					characters.map((item) => (
						<li key={`${item.id}_${item.name}`}>
							<h3>{item.name}</h3>
							<img
								src={item.image}
								alt={item.name}
								style={{
									width: "auto",
									height: "250px",
								}}
							/>
							<p>{item.race}</p>
						</li>
					))
				) : (
					<li>No characters found</li>
				)}
			</ul>
		</>
	);
};

export default SampleAPIRequest;
