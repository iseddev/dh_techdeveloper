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
	// const listElements = CHARACTERS.map((character, index) =>
	// 	React.createElement("li", { key: `${index}-${character}`, className: "character" }, character)
	// );

	// return React.createElement("ul", null, listElements);

	return (
		<ul>
			<h1>Mi lista de personajes</h1>
			{CHARACTERS.map((character, index) => {
				return (
					<li key={`${index}-${character}`} className="character">
						{character}
					</li>
				);
			})}
		</ul>
	);
};

const charactersList = createCharactersList();

ReactDOM.render(charactersList, $root);
