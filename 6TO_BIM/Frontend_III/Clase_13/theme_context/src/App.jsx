import { ThemeProvider } from "./context/ThemeContext";

import Layout from "./components/Layout/Layout";
import HeaderNav from "./components/HeaderNav/HeaderNav";
import MainContent from "./components/MainContent/MainContent";

import "./App.css";

function App() {
	return (
		<ThemeProvider>
			<Layout>
				<HeaderNav />
				<MainContent />
			</Layout>
		</ThemeProvider>
	);
}

export default App;
