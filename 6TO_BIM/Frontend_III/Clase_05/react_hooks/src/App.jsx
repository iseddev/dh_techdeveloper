import NavMenu from "./components/NavMenu.jsx";
import Card from "./components/Card";

import { DATA } from "./data/index.js";

import "./App.css";
import styles from "./components/Card.module.css";

// Without destructuring Not recommended, since the entire object would be passed with all its attributes and methods.
// function App() {
// 	return DATA.map((product) => (
// 		<Card
// 			key={product.tail}
// 			id={product.id}
// 			name={product.name}
// 			image={product.image}
// 			alt={product.amiiboSeries}
// 			price={product.price}
// 		/>
// 	));
// }

// Applying destructuring
function App() {
	return (
		<div>
			<NavMenu />
			<div className={styles.cardSection}>
				{DATA.map(({ tail, id, name, image, amiiboSeries, price }) => (
					<Card key={tail} id={id} name={name} image={image} alt={amiiboSeries} price={price} />
				))}
			</div>
		</div>
	);
}

export default App;
