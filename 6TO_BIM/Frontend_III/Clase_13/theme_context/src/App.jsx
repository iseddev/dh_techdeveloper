import { useCallback, useMemo, useState } from "react";

import HeaderNav from "./components/HeaderNav/HeaderNav";
import MainContent from "./components/MainContent/MainContent";

// Import the ThemeContext object
import ThemeContext from "./context/ThemeContext";
import { themes } from "./data/theming";

import "./App.css";
import Layout from "./components/Layout/Layout";

function App() {
	// Define a default theme as light
	const [theme, setTheme] = useState(themes.light);

	// Function to handling the theme change. We use the useCallback hook to avoid creating a new function every time the component re-renders.
	const handleChangeTheme = useCallback(() => {
		setTheme((prevTheme) => (prevTheme === themes.light ? themes.dark : themes.light));
	}, [setTheme]);

	// Create a providerContextValue object with the theme and the handleChangeTheme function. We use the useMemo hook to avoid creating a new object every time the component re-renders.
	const providerContextValue = useMemo(
		() => ({ theme, handleChangeTheme }),
		[theme, handleChangeTheme]
	);

	return (
		<ThemeContext.Provider value={{ providerContextValue }}>
			<Layout>
				<HeaderNav />
				<MainContent />
			</Layout>
		</ThemeContext.Provider>
	);
}

export default App;
