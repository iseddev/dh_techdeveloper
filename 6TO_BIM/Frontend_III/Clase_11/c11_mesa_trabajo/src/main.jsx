import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import App from "./App.jsx";
import Games from "./pages/Games.jsx";
import Contact from "./pages/Contact.jsx";
// import Beer from "./pages/Beer.jsx";
import Game from "./pages/Game.jsx";

import "./index.css";

createRoot(document.getElementById("root")).render(
	<StrictMode>
		{/* <App /> */}
		<BrowserRouter>
			<Routes>
				<Route path="/" element={<App />}>
					<Route path="games" element={<Games />} />
					<Route path="contact" element={<Contact />} />
					{/* <Route path="beer/:id" element={<Beer />} /> */}
					{/* We change https://api.punkapi.com/v2/beers by https://www.freetogame.com/api/games */}
					<Route path="game/:id" element={<Game />} />
					<Route path="*" element={<h1>Not found!!!</h1>} />
				</Route>
			</Routes>
		</BrowserRouter>
	</StrictMode>
);
