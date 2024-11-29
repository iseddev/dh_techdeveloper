import "./App.css";
import Chocolates from "./components/Chocolates";
import IsLogged from "./components/IsLogged";
import PageTitle from "./components/PageTitle";
import SampleAPIRequest from "./components/SampleAPIRequest";
import WindowResize from "./components/WindowResize";

function App() {
	return (
		<>
			<PageTitle />
			<Chocolates />
			<WindowResize />
			<IsLogged />
			<SampleAPIRequest />
		</>
	);
}

export default App;
