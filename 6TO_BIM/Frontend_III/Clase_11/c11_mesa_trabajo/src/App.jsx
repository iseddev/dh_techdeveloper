import { Outlet } from "react-router-dom";

import NavBar from "./components/NavBar";
import Footer from "./components/Footer";

import "./App.css";

function App() {
	return (
		<>
			<NavBar />
			<h1>Mas que solo video juegos, festejemos el triunfo.</h1>
			<Outlet />
			<Footer />
		</>
	);
}

export default App;
