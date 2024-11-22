import { useState } from "react";

const List = () => {
	const [item, setItem] = useState({
		id: 0,
		content: "",
	});
	const [list, setList] = useState([]);

	const updateItem = () =>
		setItem((prev) => {
			return {
				...prev,
				id: list.length + 1,
				content: `El punto ${list.length + 1} ha sido añadido a la lista`,
			};
		});

	const updateList = () => setList((prev) => [...prev, item]);

	const handleListItems = () => {
		updateItem();
		updateList();
	};

	return (
		<>
			<button onClick={handleListItems}>Add item</button>
			<section>
				<ul>{list.map((item) => item.id >= 0 && <li key={item.id}>{item.content}</li>)}</ul>
			</section>
		</>
	);
};

export default List;
