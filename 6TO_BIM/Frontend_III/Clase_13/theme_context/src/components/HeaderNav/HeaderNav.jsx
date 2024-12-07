import { useContext } from "react";

import ThemeContext from "../../context/ThemeContext";

const HeaderNav = () => {
	// Use the useContext hook to get the theme and the handleChangeTheme function from the ThemeContext
	const { providerContextValue } = useContext(ThemeContext);
	const { theme, handleChangeTheme } = providerContextValue;

	return (
		<div>
			<p>Inicio</p>
			<button
				type="button"
				onClick={handleChangeTheme}
				style={{ background: theme.background, color: theme.font }}>
				Change Theme
			</button>
		</div>
	);
};

export default HeaderNav;
