import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

import fetchSingleData from "../../../data/fetchSingleData";

import Layout from "../../../components/layout/Layout";
import CardDetailed from "../../../components/cardDetailed/CardDetailed";

const Character = () => {
	const [character, setCharacter] = useState([]);

	const { id } = useParams();

	const characterURL = `https://dragonball-api.com/api/characters/${id}`;

	useEffect(() => {
		fetchSingleData(characterURL, setCharacter);
	}, [characterURL]);

	return (
		<Layout>
			<CardDetailed data={character} />
		</Layout>
	);
};

export default Character;
