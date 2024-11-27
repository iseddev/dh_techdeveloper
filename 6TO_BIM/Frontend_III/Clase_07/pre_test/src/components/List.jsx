const handleToDoDeleteTask = (id, list, updateList) => {
	const updatedToDoList = list.filter((task) => task.id !== id);
	updateList(updatedToDoList);
};

const handleToDoChangeIsCompleted = (id, list, updateList) => {
	const updatedToDoList = list.map((task) => {
		if (task.id === id) {
			return {
				...task,
				completed: !task.completed,
			};
		}
		return task;
	});
	updateList(updatedToDoList);
};

const List = ({ toDoList, setToDoList }) => {
	return (
		<ul>
			{toDoList.map((toDoItem) => (
				<li key={toDoItem.id}>
					<input
						type="checkbox"
						checked={toDoItem.completed}
						onChange={() => handleToDoChangeIsCompleted(toDoItem.id, toDoList, setToDoList)}
					/>
					<span>{toDoItem.description}</span>
					<button onClick={() => handleToDoDeleteTask(toDoItem.id, toDoList, setToDoList)}>
						Eliminar
					</button>
				</li>
			))}
		</ul>
	);
};
export default List;
