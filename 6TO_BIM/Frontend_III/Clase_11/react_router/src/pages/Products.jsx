import { useNavigate } from "react-router-dom";
import Layout from "../components/Layout";

const INITIAL_PRODUCTS = [
	{ id: 1, name: "Product 1", price: 152 },
	{ id: 2, name: "Product 2", price: 123 },
	{ id: 3, name: "Product 3", price: 456 },
	{ id: 4, name: "Product 4", price: 789 },
	{ id: 5, name: "Product 5", price: 987 },
];
const Products = () => {
	const navigate = useNavigate();

	const goToProduct = (id) => {
		navigate(`/product/${id}`);
	};

	return (
		<Layout>
			<div>
				<h1>Products</h1>
				<ul>
					{INITIAL_PRODUCTS.map((product) => (
						<li key={product.id} onClick={() => goToProduct(product.id)}>
							<h3>{product.name}</h3>
							<span>{product.price}</span>
						</li>
					))}
				</ul>
			</div>
		</Layout>
	);
};

export default Products;
