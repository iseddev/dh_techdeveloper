import { useContext } from "react";
import { Link } from "react-router-dom";

import CartContext from "../../context/CartContext";

import styles from "./Products.module.css";
import Layout from "../../components/layout/Layout";

const products = [
	{ id: 1, name: "Product A", price: 100, quantity: 0 },
	{ id: 2, name: "Product B", price: 200, quantity: 0 },
	{ id: 3, name: "Product C", price: 300, quantity: 0 },
];

const Products = () => {
	// We need to use the useContext hook to access the cart state and the functions that will modify it in the children components. We will use the CartContext that we created before.
	const { addProductToCart } = useContext(CartContext);

	return (
		<Layout>
			<main className={styles.container}>
				<h1 className={styles.title}>Products</h1>
				<ul className={styles.productList}>
					{products.map((product) => (
						<li key={product.id} className={styles.productItem}>
							{product.name} - ${product.price}
							<button className={styles.button} onClick={() => addProductToCart(product)}>
								Add to cart
							</button>
						</li>
					))}
				</ul>
				<Link to="/cart" className={styles.link}>
					Go to cart
				</Link>
			</main>
		</Layout>
	);
};

export default Products;
