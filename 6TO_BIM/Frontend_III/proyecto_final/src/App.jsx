import { BrowserRouter, Route, Routes } from "react-router-dom";

import { FavoritesProvider } from "./context/FavoritesContext";

import Home from "./pages/home/Home";
import Characters from "./pages/characters/Characters";
import Character from "./pages/characters/character/Character";
import Favorites from "./pages/favorites/Favorites";
import Contact from "./pages/contact/Contact";
import NotFound from "./pages/notFound/NotFound";

import "./App.css";

function App() {
	return (
		<BrowserRouter>
			<FavoritesProvider>
				<Routes>
					<Route path="/" element={<Home />} />
					<Route path="/characters" element={<Characters />} />
					<Route path="/character/:id" element={<Character />} />
					<Route path="/favorites" element={<Favorites />} />
					<Route path="/contact" element={<Contact />} />
					<Route path="*" element={<NotFound />} />
				</Routes>
			</FavoritesProvider>
		</BrowserRouter>
	);
}

export default App;
