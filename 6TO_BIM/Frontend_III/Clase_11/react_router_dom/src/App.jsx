import NavBar from "./components/NavBar";

import "./App.css";
import { Outlet } from "react-router-dom";
import Footer from "./components/Footer";

function App() {
	return (
		<>
			<NavBar />
			<Outlet />
			<Footer />
		</>
	);
}

export default App;
