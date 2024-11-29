import { useEffect } from "react";

const UpdatePageTitle = ({ name }) => {
	const message = `Hello ${name}!!!`;
	useEffect(() => {
		document.title = `Welcome ${name}!!!`;
	}, [name]);
	return <h2>{message}</h2>;
};

export default UpdatePageTitle;
