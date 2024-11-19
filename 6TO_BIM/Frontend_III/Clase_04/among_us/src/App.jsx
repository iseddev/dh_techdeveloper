import StatusTripulante from "./StatusTripulante";
import "./App.css";

const tripulantes = [
	{ nombre: "Mr. Poindibags", esImpostor: true },
	{ nombre: "Bombom", esImpostor: false },
	{ nombre: "Tito", esImpostor: false },
	{ nombre: "X-Ray", esImpostor: false },
	{ nombre: "Fixfox", esImpostor: false },
];

function App() {
	return <StatusTripulante tripulantes={tripulantes} />;
}

export default App;
