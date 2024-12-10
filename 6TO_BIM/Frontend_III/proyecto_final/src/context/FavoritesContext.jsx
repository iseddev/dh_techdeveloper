import { createContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const FavoritesContext = createContext();

export const FavoritesProvider = ({ children }) => {
	const [favorites, setFavorites] = useState([]);

	const navigate = useNavigate();

	useEffect(() => {
		const storedFavorites = JSON.parse(localStorage.getItem("favorites"));
		storedFavorites && setFavorites(storedFavorites);
	}, []);

	useEffect(() => {
		favorites.length > 0
			? localStorage.setItem("favorites", JSON.stringify(favorites))
			: localStorage.removeItem("favorites");
	}, [favorites]);

	const addToFavorites = (character) => {
		setFavorites((prevState) => {
			if (prevState.find((fav) => fav.id === character.id)) return prevState;
			return [...prevState, character];
		});
	};

	const removeFromFavorites = (character) =>
		setFavorites((prevState) => prevState.filter((fav) => fav.id !== character.id));

	const goToCharacter = (id) => navigate(`/character/${id}`);

	return (
		<FavoritesContext.Provider
			value={{
				favorites,
				addToFavorites,
				removeFromFavorites,
				goToCharacter,
			}}>
			{children}
		</FavoritesContext.Provider>
	);
};

export default FavoritesContext;
