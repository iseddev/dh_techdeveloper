import { useEffect, useState, useCallback, useMemo } from "react";
import { useNavigate } from "react-router-dom";

import fetchGames from "../data/fetchGames";

import Card from "../components/Card";

// const apiURL = "https://www.freetogame.com/api/games?category=sci-fi";
const apiURL =
	"https://api.allorigins.win/get?url=" +
	encodeURIComponent("https://www.freetogame.com/api/games?category=sci-fi");

const Games = () => {
	const [games, setGames] = useState([]);
	const navigate = useNavigate();

	// Avoid creating a new function every time the component renders
	const goToGame = useCallback(
		(id) => {
			navigate(`/game/${id}`);
		},
		[navigate]
	);

	useEffect(() => {
		fetchGames(apiURL, setGames);
	}, []);

	const content = useMemo(() => {
		if (games.length === 0) return <div>Cargando datos...</div>;
		return games.map((game) => (
			<Card
				key={game.id}
				data={game}
				onClick={() => {
					goToGame(game.id);
				}}
			/>
		));
	}, [games, goToGame]);

	return (
		<>
			<div className="grid">{content}</div>
		</>
	);
};

export default Games;
