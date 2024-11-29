import { useState, useEffect } from "react";

const IsLogged = () => {
	const [user, setUser] = useState({ username: "", password: "" });
	const [isLogged, setIsLogged] = useState(false);

	const addLocalUser = () => {
		localStorage.setItem("USERNAME", "admin");
		localStorage.setItem("PASSWORD", "admin123");
	};

	const getLocalUser = () => {
		const localUsername = localStorage.getItem("USERNAME");
		const localPassword = localStorage.getItem("PASSWORD");
		return { username: localUsername, password: localPassword };
	};

	useEffect(() => {
		addLocalUser();
		const { username, password } = getLocalUser();

		user.username === username && user.password === password
			? setIsLogged(true)
			: setIsLogged(false);
	}, [user.username, user.password]);

	const handleChangeUserInput = (e) => setUser({ ...user, username: e.target.value });
	const handleChangePasswordInput = (e) => setUser({ ...user, password: e.target.value });

	return (
		<>
			<div>
				<label htmlFor="username">Username</label>
				<input
					type="text"
					name="username"
					id="username"
					value={user.username}
					onChange={handleChangeUserInput}
				/>
			</div>
			<div>
				<label htmlFor="password">Password</label>
				<input
					type="password"
					name="password"
					id="password"
					value={user.password}
					onChange={handleChangePasswordInput}
				/>
			</div>
			{isLogged ? <b>Welcome {user.username}!</b> : <b>Invalid credentials</b>}
			<hr />
		</>
	);
};

export default IsLogged;
