const CHARACTERS = [
	"Padmé Amidala",
	"Anakin Skywalker",
	"Obi-Wan Kenobi",
	"Mace Windu",
	"Yoda",
	"Darth Sidious",
	"Darth Maul",
	"Darth Vader",
	"Luke Skywalker",
	"Leia Organa",
	"Han Solo",
	"Chewbacca",
	"Lando Calrissian",
	"Rey",
	"Finn",
	"Poe Dameron",
	"Kylo Ren",
	"BB-8",
	"R2-D2",
	"C-3PO",
];

const $root = document.querySelector("#root");

const createCharactersList = () => {
	// Creating a li element for each character using React.createElement method
	// const listElements = CHARACTERS.map((character, index) =>
	// 	React.createElement("li", { key: `${index}-${character}`, className: "character" }, character)
	// );
	// Creating an ul element and adding previous li elements to it using React.createElement method
	// return React.createElement("ul", null, listElements);

	// Creating an ul element with each li character using JSX
	return (
		<div>
			<h1>Mi lista de personajes</h1>
			<ul>
				{CHARACTERS.map((character, index) => {
					return (
						<li key={`${index}-${character}`} className="character">
							{character}
						</li>
					);
				})}
			</ul>
		</div>
	);
};

const charactersList = createCharactersList();

ReactDOM.render(charactersList, $root);
