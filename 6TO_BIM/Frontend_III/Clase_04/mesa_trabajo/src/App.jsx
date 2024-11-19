import { products } from "./data/products";
import { Card } from "./components/Card";
import "./App.css";

const App = () => {
	return (
		<section>
			<h1>Products</h1>
			<ul className="cardList">
				{products.map(({ id, description, image, price }) => (
					<Card key={id} description={description} imgURL={image} price={price} />
				))}
			</ul>
		</section>
	);
};

export default App;
