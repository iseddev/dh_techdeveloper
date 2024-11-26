import { useState } from "react";

import {
	isValidName,
	isValidLastName,
	isValidAddress,
	isValidEmail,
	isValidPhone,
} from "../../utilities/validate_form_data";

import styles from "./Form.module.css";

const Form = () => {
	const [formData, setFormData] = useState({
		name: "",
		lastName: "",
		address: "",
		email: "",
		phone: "",
	});

	const [showSummary, setShowSummary] = useState(false);
	const [formSubmitted, setFormSubmitted] = useState(false);

	const handleInputChange = (e) => {
		setFormData({
			...formData,
			[e.target.name]: e.target.value,
		});
	};

	const handleSubmit = (e) => {
		e.preventDefault();

		setFormSubmitted(true);

		const invalidInputs = {
			invalidName: !isValidName(formData.name),
			invalidLastName: !isValidLastName(formData.lastName),
			invalidAddress: !isValidAddress(formData.address),
			invalidEmail: !isValidEmail(formData.email),
			invalidPhone: !isValidPhone(formData.phone),
		};

		const isValidForm = Object.values(invalidInputs).every((input) => !input);
		isValidForm && setShowSummary(true);
	};

	return (
		<div className={styles.formContainer}>
			{/* {errorForm && <p>Todos los campos son necesarios</p>} */}
			{!showSummary && (
				<>
					<h2>Orden de compra</h2>
					<form className={styles.form} onSubmit={handleSubmit}>
						<div className={styles.formGroup}>
							<label htmlFor="name">First Name:</label>
							<input
								type="text"
								id="name"
								name="name"
								value={formData.name}
								onChange={handleInputChange}
							/>
							{formSubmitted && !isValidName(formData.name) && <p>El nombre es requerido</p>}
						</div>
						<div className={styles.formGroup}>
							<label htmlFor="lastName">Last Name:</label>
							<input
								type="text"
								id="lastName"
								name="lastName"
								value={formData.lastName}
								onChange={handleInputChange}
							/>
							{formSubmitted && !isValidLastName(formData.lastName) && (
								<p>El apellido es requerido</p>
							)}
						</div>
						<div className={styles.formGroup}>
							<label htmlFor="address">Address:</label>
							<input
								type="text"
								id="address"
								name="address"
								value={formData.address}
								onChange={handleInputChange}
							/>
							{formSubmitted && !isValidAddress(formData.address) && (
								<p>La dirección es requerida</p>
							)}
						</div>
						<div className={styles.formGroup}>
							<label htmlFor="email">Email:</label>
							<input
								type="email"
								id="email"
								name="email"
								value={formData.email}
								onChange={handleInputChange}
							/>
							{formSubmitted && !isValidEmail(formData.email) && <p>El email es requerido</p>}
						</div>
						<div className={styles.formGroup}>
							<label htmlFor="phone">Phone:</label>
							<input
								type="tel"
								id="phone"
								name="phone"
								value={formData.phone}
								onChange={handleInputChange}
							/>
							{formSubmitted && !isValidPhone(formData.phone) && <p>El teléfono es requerido</p>}
						</div>
						<button type="submit" className={styles.submitButton}>
							Enviar
						</button>
					</form>
				</>
			)}
			{showSummary && (
				<>
					<h2>Detalles del envío</h2>
					<section className={styles.summary}>
						<p>Nombre: {formData.name}</p>
						<p>Apellido: {formData.lastName}</p>
						<p>Dirección: {formData.address}</p>
						<p>Email: {formData.email}</p>
						<p>Teléfono: {formData.phone}</p>
					</section>
				</>
			)}
		</div>
	);
};

export default Form;
