import { useState, useEffect, useMemo, useContext } from "react";

import fetchData from "../../data/fetchData";

import FavoritesContext from "../../context/FavoritesContext";
import Layout from "../../components/layout/Layout";
import Card from "../../components/card/Card";

import styles from "./Characters.module.css";

const apiURL = "https://dragonball-api.com/api/characters?page=1&limit=24";

const Characters = () => {
	const [characters, setCharacters] = useState([]);
	const [isLoading, setIsLoading] = useState(true);
	const [isFirstLoad, setIsFirstLoad] = useState(true);

	const { goToCharacter } = useContext(FavoritesContext);

	useEffect(() => {
		if (isFirstLoad) {
			fetchData(apiURL, setCharacters);
			setTimeout(() => setIsFirstLoad(false), 1000);
		}
		setIsLoading(false);
	}, [isFirstLoad]);

	const content = useMemo(() => {
		if (isLoading) return <h3>Cargando datos ...</h3>;

		return characters.map((character) => (
			<Card
				key={character.id}
				data={character}
				onClick={() => {
					goToCharacter(character.id);
				}}
			/>
		));
	}, [characters, goToCharacter, isLoading]);

	return (
		<Layout mainTitle="Dragon Ball Z - Best Characters">
			<div
				className={!isLoading || !isFirstLoad ? styles.charactersGrid : styles.charactersLoading}>
				{content}
			</div>
		</Layout>
	);
};

export default Characters;
