import { useState } from "react";

import UpdatePageTitle from "./components/UpdatePageTitle";

import "./App.css";

function App() {
	const [name, setName] = useState("");

	const handleChangeInputName = (event) => setName(event.target.value);

	return (
		<>
			<h1>Clase 09 - Uso de useEffect 02</h1>

			<div>
				<label htmlFor="name">Name:</label>
				<input type="text" id="name" value={name} onChange={handleChangeInputName} />
			</div>
			<UpdatePageTitle name={name} />
		</>
	);
}

export default App;
