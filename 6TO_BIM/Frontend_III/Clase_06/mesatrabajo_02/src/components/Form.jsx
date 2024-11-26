import { useState } from "react";

const Form = () => {
	const [userName, setUserName] = useState("");
	const [userAge, setUserAge] = useState("");
	const [pokemon, setPokemon] = useState("");

	const handleChangeFullName = (e) => setUserName(e.target.value);
	const handleChangeUserAge = (e) => setUserAge(e.target.value);
	const handleChangePokemon = (e) => setPokemon(e.target.value);

	const isValidText = (text) => text.trim().length > 0;
	const isValidAge = (age) => age > 0 && age < 100 && age.length > 0;

	// Luego obtener los datos y validarlos. En caso de que las validaciones salgan bien, mostrar un mensaje de éxito, caso contrario, mostrar un mensaje de error.
	const handleSubmit = (e) => {
		e.preventDefault();
		if (isValidText(userName) && isValidAge(userAge) && isValidText(pokemon)) {
			alert("Correctly validated data");
			setUserName("");
			setUserAge("");
			setPokemon("");
		} else alert("Some of the data is wrong");
	};

	return (
		// Crear un formulario de registro de usuario, con los campos:
		<form onSubmit={handleSubmit}>
			{/* - Nombre completo. */}
			<input type="text" value={userName} placeholder="Full name" onChange={handleChangeFullName} />
			{/* - Edad. */}
			<input type="number" value={userAge} placeholder="Age" onChange={handleChangeUserAge} />
			{/* - Pokemon favorito. */}
			<input
				type="text"
				value={pokemon}
				placeholder="Favorite Pokemon"
				onChange={handleChangePokemon}
			/>
			<button type="submit">Validate Data</button>
		</form>
	);
};

export default Form;
