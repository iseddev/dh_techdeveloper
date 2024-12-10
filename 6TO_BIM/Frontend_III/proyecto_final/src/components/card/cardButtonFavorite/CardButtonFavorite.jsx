import { useContext } from "react";

import FavoritesContext from "../../../context/FavoritesContext";

import styles from "./CardButtonFavorite.module.css";

const CardButtonFavorite = ({ data }) => {
	const { favorites, addToFavorites, removeFromFavorites } = useContext(FavoritesContext);

	const toggleFavorite = () => {
		if (favorites.some((fav) => fav.id === data.id)) {
			removeFromFavorites(data);
		} else {
			addToFavorites(data);
		}
	};

	return (
		<button
			type="button"
			className={`${styles.isNotFavorite} ${
				favorites.some((fav) => fav.id === data.id) ? styles.isFavorite : ""
			}`}
			onClick={() => toggleFavorite()}>
			<svg
				width="100%"
				height="100%"
				viewBox="0 0 24 24"
				fill="none"
				stroke="currentColor"
				strokeWidth="1ss"
				strokeLinecap="round"
				strokeLinejoin="round">
				<path stroke="none" d="M0 0h24v24H0z" fill="none" />
				<path d="M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l3.086 6.253l6.9 1l-5 4.867l1.179 6.873z" />
			</svg>
		</button>
	);
};

export default CardButtonFavorite;
