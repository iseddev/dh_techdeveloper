import { useContext } from "react";

import LanguageContext from "../context/LanguageContext";

import "../App.css";

const Navbar = () => {
	// TIP: Uncomment this block of code when "App.jsx" has a provider
	const { language, handleChangeLanguage } = useContext(LanguageContext);
	const { text } = language;

	return (
		<div className="navbar">
			{/* Leave this dynamic information, use the values captured via context (see 'text', in line 10) */}
			<p>{text.home}</p>
			<p>
				{text.current}: {language.id}
			</p>
			<button onClick={handleChangeLanguage}>{text.button}</button>
		</div>
	);
};

export default Navbar;
