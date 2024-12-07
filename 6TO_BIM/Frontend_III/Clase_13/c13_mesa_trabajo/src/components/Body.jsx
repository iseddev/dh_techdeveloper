import { useContext } from "react";

import LanguageContext from "../context/LanguageContext";

const Body = () => {
	// TIP: Use the useContext() function to capture the values of the context
	const { language } = useContext(LanguageContext);
	const { text } = language;

	return (
		<div>
			{/* TIP: Use the values captured via context */}
			<h1>{text.title}</h1>
			<p>{text.description}</p>
		</div>
	);
};

export default Body;
