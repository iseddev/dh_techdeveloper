import { createContext, useState } from "react";
import { useNavigate } from "react-router-dom";

const FavoritesContext = createContext();

export const FavoritesProvider = ({ children }) => {
	const [favorites, setFavorites] = useState([]);

	const navigate = useNavigate();

	const addToFavorites = (character) => {
		setFavorites((prevState) => {
			if (prevState.find((fav) => fav.id === character.id)) return prevState;
			return [...prevState, character];
		});
	};

	const removeFromFavorites = (character) => {
		setFavorites((prevState) => prevState.filter((fav) => fav.id !== character.id));
	};

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
