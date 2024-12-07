import { useState } from "react";

import LanguageContext from "./context/LanguageContext";
import { languages } from "./languages/languages";

import Body from "./components/Body";
import Navbar from "./components/NavBar";

import "./App.css";
function App() {
	const [language, setLanguage] = useState(languages.english);

	const handleChangeLanguage = () => {
		setLanguage(() => {
			//TIP: Function that exchanges one language for another (by clicking the button)
			if (language.id === "EN") {
				return languages.portuguese;
			} else if (language.id === "PTBR") {
				return languages.spanish;
			} else {
				return languages.english;
			}
		});
	};

	return (
		<div className="App">
			<>
				{/* TIP: Add provider of LanguageContext */}
				<LanguageContext.Provider value={{ language, handleChangeLanguage }}>
					<Navbar />
					<Body />
				</LanguageContext.Provider>
			</>
		</div>
	);
}

export default App;
