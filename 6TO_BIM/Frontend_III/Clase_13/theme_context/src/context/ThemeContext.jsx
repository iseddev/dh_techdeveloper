import { createContext, useState } from "react";

// Importing the themes object from the theming file
import { themes } from "../data/theming";

// Creating a ThemeContext object with the default value of the light theme
const ThemeContext = createContext(themes.light);

export const ThemeProvider = ({ children }) => {
	const [theme, setTheme] = useState(themes.light);

	const handleChangeTheme = () => {
		setTheme((prevTheme) => (prevTheme === themes.light ? themes.dark : themes.light));
	};

	return (
		<ThemeContext.Provider value={{ theme, handleChangeTheme }}>{children}</ThemeContext.Provider>
	);
};

export default ThemeContext;
