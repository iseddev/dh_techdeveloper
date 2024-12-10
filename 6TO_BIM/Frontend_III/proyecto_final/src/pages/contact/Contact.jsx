import { useState } from "react";

import Layout from "../../components/layout/Layout";

import { isValidText, isValidEmail } from "../../data/validateData";

import styles from "./Contact.module.css";
import button from "../../components/card/Card.module.css";

const Contact = () => {
	const [userName, setUserName] = useState("");
	const [userAlias, setUserAlias] = useState("");
	const [email, setEmail] = useState("");
	const [invalidUserNameMessage, setInvalidUserNameMessage] = useState("");
	const [invalidAliasMessage, setInvalidAliasMessage] = useState("");
	const [invalidEmailMessage, setInvalidEmailMessage] = useState("");

	const handleChangeName = (e) => {
		isValidText(e.target.value)
			? setInvalidUserNameMessage("")
			: setInvalidUserNameMessage("This field must contain at least one alphabetic character");
		setUserName(e.target.value);
	};

	const handleChangeAlias = (e) => {
		isValidText(e.target.value)
			? setInvalidAliasMessage("")
			: setInvalidAliasMessage("This field must contain at least 3 alphabetic character");
		setUserAlias(e.target.value);
	};

	const handleChangeEmail = (e) => {
		isValidEmail(e.target.value)
			? setInvalidEmailMessage("")
			: setInvalidEmailMessage("This field must contain a valid email");
		setEmail(e.target.value);
	};

	const handleSubmit = (e) => {
		e.preventDefault();
		if (isValidText(userName) && isValidText(userAlias) && isValidEmail(email)) {
			alert("Welcome to our community!");
			setUserName("");
			setUserAlias("");
			setEmail("");
		} else alert("Some of the data is wrong");
	};

	return (
		<Layout mainTitle={"Join us!"}>
			<h2 className={styles.formTitle}>Join to our amazing community!</h2>
			<form className={styles.mainForm} onSubmit={handleSubmit}>
				<div className={styles.formField}>
					<input type="text" value={userName} placeholder="Full name" onChange={handleChangeName} />
					<span className={styles.errorMessage}>{invalidUserNameMessage}</span>
				</div>
				<div className={styles.formField}>
					<input
						type="text"
						value={userAlias}
						placeholder="Nick name"
						onChange={handleChangeAlias}
					/>
					<span className={styles.errorMessage}>{invalidAliasMessage}</span>
				</div>
				<div className={styles.formField}>
					<input type="email" value={email} placeholder="Email" onChange={handleChangeEmail} />
					<span className={styles.errorMessage}>{invalidEmailMessage}</span>
				</div>
				<button className={button.mainButton} type="submit">
					Join
				</button>
			</form>
		</Layout>
	);
};

export default Contact;
