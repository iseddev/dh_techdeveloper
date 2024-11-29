import { useState, useEffect } from "react";
import { getCharacters } from "../services/getCharacters";

const Characters = () => {
	const [characters, setCharacters] = useState([]);
	const [newQuery, setNewQuery] = useState(false);

	useEffect(() => {
		getCharacters().then((response) => setCharacters(response));
	}, [newQuery]);

	// console.log(characters);

	return (
		<section>
			<h2>Characters</h2>
			{characters.map((character) => (
				<article key={character.id}>
					<h2>{character.name}</h2>
					<img src={character.image} alt={character.name} />
				</article>
			))}
			<button onClick={() => setNewQuery((prev) => !prev)}>
				{newQuery ? "Detener" : "Iniciar"} Fetch
			</button>
		</section>
	);
};

export default Characters;
