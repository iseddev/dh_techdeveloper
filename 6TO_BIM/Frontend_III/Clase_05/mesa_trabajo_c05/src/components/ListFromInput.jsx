import { useState } from "react";

const ListFromInput = () => {
	const [item, setItem] = useState({ id: null, content: "" });
	const [list, setList] = useState([]);

	const handleInputChanges = (e) => {
		setItem({ ...item, id: list.length + 1, content: e.target.value });
	};

	const addItemToList = () => {
		if (item.content.trim().length <= 0) return;
		setList([...list, item]);
		setItem({ ...item, id: null, content: "" });
	};

	return (
		<div>
			<input type="text" value={item.content} onChange={handleInputChanges} />
			<button onClick={addItemToList}>Add item</button>
			<ul>
				{list.map((item) => (
					<li key={item.id}>{item.content}</li>
				))}
			</ul>
		</div>
	);
};

export default ListFromInput;
