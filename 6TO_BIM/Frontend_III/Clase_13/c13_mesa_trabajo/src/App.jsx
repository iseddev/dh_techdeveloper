import { LanguageProvider } from "./context/LanguageContext";

import Body from "./components/Body";
import Navbar from "./components/NavBar";

import "./App.css";
function App() {
	return (
		<div className="App">
			<>
				{/* TIP: Add provider of LanguageContext */}
				<LanguageProvider>
					<Navbar />
					<Body />
				</LanguageProvider>
			</>
		</div>
	);
}

export default App;
