import { createContext, useState } from "react";

const FavoritesContext = createContext();

export const FavoritesProvider = ({ children }) => {
	const [favorites, setFavorites] = useState([]);

	const addToFavorites = (character) => {
		setFavorites((prevState) => [...prevState, character]);
	};

	const removeFromFavorites = (character) => {
		setFavorites((prevState) => prevState.filter((fav) => fav.id !== character.id));
	};

	return (
		<FavoritesContext.Provider
			value={{
				favorites,
				addToFavorites,
				removeFromFavorites,
			}}>
			{children}
		</FavoritesContext.Provider>
	);
};

export default FavoritesContext;
