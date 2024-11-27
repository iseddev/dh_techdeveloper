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
			{toDoList.map((item) => (
				<li key={item.id}>
					<input
						type="checkbox"
						checked={item.completed}
						onChange={() => handleToDoChangeIsCompleted(item.id, toDoList, setToDoList)}
					/>
					<span>{item.description}</span>
					<button onClick={() => handleToDoDeleteTask(item.id, toDoList, setToDoList)}>
						Eliminar
					</button>
				</li>
			))}
		</ul>
	);
};
export default List;
