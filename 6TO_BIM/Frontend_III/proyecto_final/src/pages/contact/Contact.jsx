import { useState } from "react";

import Layout from "../../components/layout/Layout";

const Contact = () => {
	const [userName, setUserName] = useState("");
	const [userAge, setUserAge] = useState("");
	const [email, setEmail] = useState("");

	const handleChangeFullName = (e) => setUserName(e.target.value);
	const handleChangeUserAge = (e) => setUserAge(e.target.value);
	const handleChangeEmail = (e) => setEmail(e.target.value);

	const isValidText = (text) => text.trim().length > 0;
	const isValidAge = (age) => age > 0 && age < 100 && age.length > 0;

	// Luego obtener los datos y validarlos. En caso de que las validaciones salgan bien, mostrar un mensaje de éxito, caso contrario, mostrar un mensaje de error.
	const handleSubmit = (e) => {
		e.preventDefault();
		if (isValidText(userName) && isValidAge(userAge) && isValidText(email)) {
			alert("Correctly validated data");
			setUserName("");
			setUserAge("");
			setEmail("");
		} else alert("Some of the data is wrong");
	};

	return (
		<Layout mainTitle={"Join us!"}>
			<h2>¡Únete a nuestra comunidad!</h2>
			<form onSubmit={handleSubmit}>
				<input
					type="text"
					value={userName}
					placeholder="Full name"
					onChange={handleChangeFullName}
				/>
				<input type="number" value={userAge} placeholder="Age" onChange={handleChangeUserAge} />
				<input
					type="text"
					value={email}
					placeholder="Favorite Pokemon"
					onChange={handleChangeEmail}
				/>
				<button type="submit">Validate Data</button>
			</form>
		</Layout>
	);
};

export default Contact;
