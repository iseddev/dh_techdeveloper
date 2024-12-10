import { useContext, useCallback, useMemo } from "react";
import { useNavigate } from "react-router-dom";

import FavoritesContext from "../../context/FavoritesContext";

import Layout from "../../components/layout/Layout";
import Card from "../../components/card/Card";

import styles from "../characters/Characters.module.css";

const Favorites = () => {
	const { favorites } = useContext(FavoritesContext);
	const navigate = useNavigate();

	const goToCharacter = useCallback((id) => navigate(`/character/${id}`), [navigate]);

	const favoriteCharacters = useMemo(() => {
		return (
			<main>
				<h2>Favoritos</h2>
				{favorites.length === 0 ? (
					<p>No tienes personajes favoritos.</p>
				) : (
					<div className={styles.charactersGrid}>
						{favorites.map((favorite) => (
							<Card key={favorite.id} data={favorite} onClick={() => goToCharacter(favorite.id)} />
						))}
					</div>
				)}
			</main>
		);
	}, [favorites, goToCharacter]);

	return <Layout>{favoriteCharacters}</Layout>;
};

export default Favorites;
