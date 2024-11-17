import "./List.css";

export const List = () => {
	return (
		<ul>
			<li>Item 1</li>
			<li>Item 2</li>
			<li>Item 3</li>
			<li>
				Item 4
				<ul>
					<li>Subitem 4-1</li>
					<li>Subitem 4-2</li>
					<li>Subitem 4-3</li>
				</ul>
			</li>
		</ul>
	);
};
