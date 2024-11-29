import { useState, useEffect } from "react";
import Characters from "./components/Characters";
import Message from "./components/Message";

import "./App.css";

function App() {
	const [formData, setFormData] = useState({
		user: "",
		password: "",
	});

	// Destructuring of formData to use each value separately
	const { user, password } = formData;

	// Function to handle the input on change using destructuring of the event target
	const handleChangeInput = ({ target }) => {
		// Getting the name and value of the target
		const { name, value } = target;
		setFormData({ ...formData, [name]: value });
	};

	// useEffect applied to the user state
	useEffect(() => console.log("Se montó el componente App en el primer renderizado"), []);

	useEffect(() => console.log("Escuchando cambios en el input user"), [user]);
	useEffect(() => console.log("Escuchando cambios en el input password"), [password]);

	return (
		<main>
			<form>
				<div>
					<label htmlFor="user">Usuario</label>
					<input type="text" id="user" name="user" value={user} onChange={handleChangeInput} />
				</div>
				<div>
					<label htmlFor="password">Contraseña</label>
					<input
						type="password"
						id="password"
						name="password"
						value={password}
						onChange={handleChangeInput}
					/>
				</div>
			</form>
			{user === "humberto" ? <Message /> : null}

			<Characters />
		</main>
	);
}

export default App;
