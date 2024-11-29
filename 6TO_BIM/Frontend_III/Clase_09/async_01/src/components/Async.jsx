import { useState, useEffect } from "react";

const Async = () => {
	const [vector, setVector] = useState([]);

	const getData = async () => {
		const data = await fetch("https://jsonplaceholder.typicode.com/comments");
		const comments = await data.json();
		setVector(comments);
	};

	useEffect(() => {
		getData();
	}, []);

	return (
		<div>
			<ul>
				{vector.map((comment) => (
					<li key={comment.id}>{comment.email}</li>
				))}
			</ul>
		</div>
	);
};

export default Async;
