import { useState } from "react";

import List from "./List";

const INITIAL_TODO_LIST = [
	{ id: crypto.randomUUID(), description: "Comprar pan", completed: false },
	{ id: crypto.randomUUID(), description: "Estudiar React", completed: true },
];

const Form = () => {
	const [toDoList, setToDoList] = useState(INITIAL_TODO_LIST);
	const [toDoItem, setTodoItem] = useState({ id: "", description: "", completed: false });

	const handleToDoFormChangeInput = (e) => {
		setTodoItem({
			...toDoItem,
			description: e.target.value,
		});
	};

	const handleToDoFormSubmit = (e) => {
		e.preventDefault();
		if (!toDoItem.description.trim()) return;
		setToDoList([...toDoList, { ...toDoItem, id: crypto.randomUUID() }]);
		setTodoItem({ ...toDoItem, description: "" });
	};

	return (
		<>
			<h2>Total de tareas: {toDoList.length}</h2>
			<form onSubmit={handleToDoFormSubmit}>
				<div>
					<label htmlFor="description">Tarea:</label>
					<input
						type="text"
						id="description"
						name="description"
						value={toDoItem.description}
						onChange={handleToDoFormChangeInput}
					/>
				</div>
				<button type="submit">Agregar</button>
			</form>
			<List toDoList={toDoList} setToDoList={setToDoList} />
		</>
	);
};
export default Form;
