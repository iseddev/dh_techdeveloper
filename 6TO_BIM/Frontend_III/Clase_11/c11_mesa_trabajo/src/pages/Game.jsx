import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import fetchGames from "../data/fetchGames";

//Esta pagina renderizará cada video juego de manera individual
const Game = () => {
	const [game, setGame] = useState([]);

	const navigate = useNavigate();
	const { id } = useParams();

	const apiURL =
		"https://api.allorigins.win/get?url=" +
		encodeURIComponent(`https://www.freetogame.com/api/game?id=${id}`);

	useEffect(() => {
		fetchGames(apiURL, setGame);
	}, [apiURL]);

	return (
		<div>
			<div className="card-detailed">
				<img src={game.thumbnail} alt={game.title} />
				<div className="card-detailed__info">
					<h2>{game.title}</h2>
					<p>{game.platform}</p>
					<p>{game.short_description}</p>
					<p>{game.publisher} </p>
				</div>
			</div>
			<button onClick={() => navigate("/games")}>Go back</button>
		</div>
	);
};

export default Game;
