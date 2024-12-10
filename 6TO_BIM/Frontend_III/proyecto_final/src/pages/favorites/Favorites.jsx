import { useContext, useMemo } from "react";

import FavoritesContext from "../../context/FavoritesContext";

import Layout from "../../components/layout/Layout";
import Card from "../../components/card/Card";

import styles from "../characters/Characters.module.css";

const Favorites = () => {
	const { favorites, goToCharacter } = useContext(FavoritesContext);

	const favoriteCharacters = useMemo(
		() => (
			<>
				{favorites.length === 0 ? (
					<p className={styles.noFavorites}>You don&apos;t have any favorite characters.</p>
				) : (
					<div className={styles.charactersGrid}>
						{favorites.map((favorite) => (
							<Card key={favorite.id} data={favorite} onClick={() => goToCharacter(favorite.id)} />
						))}
					</div>
				)}
			</>
		),
		[favorites, goToCharacter]
	);

	return <Layout mainTitle="Favorite Characters">{favoriteCharacters}</Layout>;
};

export default Favorites;
