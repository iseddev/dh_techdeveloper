import { useState, createContext, useCallback } from "react";

import { languages } from "../languages/languages";

// TIP: Use createContext and start English as the default language
const LanguageContext = createContext(languages.english);

export const LanguageProvider = ({ children }) => {
	const [language, setLanguage] = useState(languages.english);

	const handleChangeLanguage = useCallback(() => {
		setLanguage(() => {
			if (language.id === "EN") {
				return languages.portuguese;
			} else if (language.id === "PTBR") {
				return languages.spanish;
			} else {
				return languages.english;
			}
		});
	}, [language]);

	// TIP: Use the provider to pass the language and the function to change the language
	return (
		<LanguageContext.Provider value={{ language, handleChangeLanguage }}>
			{children}
		</LanguageContext.Provider>
	);
};

export default LanguageContext;
