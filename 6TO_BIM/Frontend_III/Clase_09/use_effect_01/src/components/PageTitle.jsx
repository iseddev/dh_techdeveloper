import { useState, useEffect } from "react";

const PageTitle = () => {
	const [title, setTitle] = useState("Default Title");

	useEffect(() => {
		document.title = title;
	}, [title]);

	const handleChangeInput = (e) => setTitle(e.target.value);

	return (
		<>
			<h2>Dynamic page title</h2>
			<label htmlFor="pageTitle">My favorite title: </label>
			<input type="text" name="pageTitle" id="pageTitle" onChange={handleChangeInput} />
			<hr />
		</>
	);
};

export default PageTitle;
