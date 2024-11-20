import { useState } from "react";

const List = () => {
	const [list, setList] = useState([]);
	const [item, setItem] = useState({
		id: list.length + 1,
		content: `El punto ${list.length + 1} ha sido añadido a la lista`,
	});

	const updateList = () => {
		setItem({
			...item,
			id: list.length + 2,
			content: `El punto ${list.length + 2} ha sido añadido a la lista`,
		});
		setList([...list, item]);
	};

	return (
		<section>
			<button onClick={updateList}>Add item</button>
			<ul>{list.map((item) => item.id > 0 && <li key={item.id}>{item.content}</li>)}</ul>
		</section>
	);
};

export default List;
