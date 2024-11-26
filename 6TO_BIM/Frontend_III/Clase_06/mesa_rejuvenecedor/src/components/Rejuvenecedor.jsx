// Crea un componente controlado llamado Rejuvenecedor, con 2 campos: nombre y edad.

import { useState } from "react";

import styles from "./Rejuvenecedor.module.css";

const Rejuvenecedor = () => {
	const [userName, setUserName] = useState("");
	const [userAge, setUserAge] = useState("");
	const [invalidUserNameMessage, setInvalidUserNameMessage] = useState("");
	const [invalidUserAgeMessage, setInvalidUserAgeMessage] = useState("");

	const onChangeUserName = (e) => {
		isValidUserName(e.target.value)
			? setInvalidUserNameMessage("")
			: setInvalidUserNameMessage("Este campo debe contener al menos un carácter alfabético");
		setUserName(e.target.value);
	};
	const onChangeUserAge = (e) => {
		isValidUserAge(e.target.value)
			? setInvalidUserAgeMessage("")
			: setInvalidUserAgeMessage("Este campo debe ser un número entero positivo mayor a 10");
		setUserAge(e.target.value);
	};

	// En el nombre, valida que sea string con al menos un carácter.
	const isValidUserName = (userName) => {
		const trimmedUserName = userName.trim();
		const userNameAsArray = trimmedUserName.split("");
		const regex = /^[a-zA-ZÀ-ÿ]+$/;
		const isValidUserName = userNameAsArray.every((char) => regex.test(char));
		return trimmedUserName.length > 0 && isValidUserName;
	};

	// La edad debe ser un número entero positivo.
	const isValidUserAge = (userAge) => (!isNaN(userAge) && userAge > 10 ? true : false);

	// Al dar submit, hacer que nos quite 10 años de edad mostrándonos nuestro nombre y nuestra nueva y feliz edad en un alert().
	const handleSubmitForm = (e) => {
		e.preventDefault();
		!isValidUserName(userName) || !isValidUserAge(userAge)
			? alert("Invalid data")
			: alert(`Hola ${userName}, tu nueva edad es de ${parseInt(userAge) - 10} años`);
		setUserName("");
		setUserAge("");
	};
	return (
		<form onSubmit={handleSubmitForm} className={styles.form}>
			<div>
				<input
					type="text"
					name="name"
					placeholder="Name"
					value={userName}
					onChange={onChangeUserName}
				/>
				<span>{invalidUserNameMessage}</span>
			</div>
			<div>
				<input
					type="number"
					name="age"
					placeholder="Age"
					value={userAge}
					onChange={onChangeUserAge}
				/>
				<span>{invalidUserAgeMessage}</span>
			</div>
			<button type="submit">Rejuvenecer</button>
		</form>
	);
};

export default Rejuvenecedor;
