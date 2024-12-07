import { useContext } from "react";

// Import the ThemeContext object
import ThemeContext from "../../context/ThemeContext";

// Create a Layout component that receives children as a prop
const Layout = ({ children }) => {
	const { theme } = useContext(ThemeContext);

	return <div style={{ backgroundColor: theme.background, color: theme.font }}>{children}</div>;
};

export default Layout;
