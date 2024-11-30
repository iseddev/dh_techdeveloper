import { useState, useEffect } from "react";
import { getComments } from "../data/getComments";

const Comments = () => {
	const [comments, setComments] = useState([]);

	useEffect(() => {
		getComments().then((response) => setComments(response));
	}, []);

	return (
		<section>
			<h2>Comments</h2>
			{comments.map((comment) => (
				<article key={comment.id}>
					<h2>{comment.name}</h2>
					<p>{comment.email}</p>
					<p>{comment.body}</p>
				</article>
			))}
		</section>
	);
};

export default Comments;
