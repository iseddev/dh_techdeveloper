import { useContext } from "react";

import ThemeContext from "../../context/ThemeContext";

const HeaderNav = () => {
	const { theme, handleChangeTheme } = useContext(ThemeContext);

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
