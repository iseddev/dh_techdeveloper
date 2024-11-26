import { useState } from "react";
import "./App.css";

function App() {
	const [userName, setUserName] = useState("");
	const [password, setPassword] = useState("");

	const onChangeUserName = (event) => setUserName(event.target.value);
	const onChangePassword = (event) => setPassword(event.target.value);

	const onSubmitLogin = (event) => {
		event.preventDefault();
		const isValidUserName = validateUserName(userName);
		const isValidPassword = validatePassword(password);
		!isValidPassword || !isValidUserName
			? alert("Invalid data")
			: alert(`Nice to see you ${userName}`);
		setUserName("");
		setPassword("");
	};

	// Data Validations
	const validateUserName = (userName) => (userName.trim().length > 2 ? true : false);
	const hasAtLeastOneNumber = (arr) => arr.some((value) => (isNaN(value) ? false : true));
	const validatePassword = (password) => {
		const cleanedPasswordAsArray = password.trim().split("");
		const hasNumber = hasAtLeastOneNumber(cleanedPasswordAsArray);
		return cleanedPasswordAsArray.length > 5 && hasNumber;
	};

	return (
		<div className="loginContainer">
			<h3>Account Login</h3>
			<form onSubmit={onSubmitLogin} className="loginForm">
				<input type="text" placeholder="User name" value={userName} onChange={onChangeUserName} />
				<input
					type="password"
					placeholder="Password"
					value={password}
					onChange={onChangePassword}
				/>
				<button onSubmit={onSubmitLogin}>Login</button>
			</form>
		</div>
	);
}

export default App;
