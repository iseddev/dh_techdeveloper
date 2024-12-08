import { useState, useEffect, useCallback, useMemo } from "react";
import { useNavigate } from "react-router-dom";

import fetchData from "../../data/fetchData";

import Layout from "../../components/layout/Layout";
import Card from "../../components/card/Card";

import styles from "./Characters.module.css";

const apiURL = "https://dragonball-api.com/api/characters?page=1&limit=24";

const Characters = () => {
	const [characters, setCharacters] = useState([]);
	const [isLoading, setIsLoading] = useState(true);
	const [isFirstLoad, setIsFirstLoad] = useState(true);

	const navigate = useNavigate();

	useEffect(() => {
		if (isFirstLoad) {
			fetchData(apiURL, setCharacters);
			setTimeout(() => setIsFirstLoad(false), 1000);
		}
		setIsLoading(false);
	}, [isFirstLoad]);

	const goToCharacter = useCallback((id) => navigate(`/character/${id}`), [navigate]);

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
		<Layout>
			<div
				className={!isLoading || !isFirstLoad ? styles.charactersGrid : styles.charactersLoading}>
				{content}
			</div>
		</Layout>
	);
};

export default Characters;
