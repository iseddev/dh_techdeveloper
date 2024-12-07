import { useContext } from "react";

import CartContext from "../../context/CartContext";

import styles from "./Cart.module.css";
import { Link } from "react-router-dom";
import Layout from "../../components/layout/Layout";

// Test an empty array
// const dataFromContext = [];

// Test an array with data
// const dataFromContext = [{ id: 1, name: "Producto A", price: 100 }];

const Cart = () => {
	// We need to use the useContext hook to access the cart state and the functions that will modify it in the children components. We will use the CartContext that we created before.
	const { cart, removeProductFromCart } = useContext(CartContext);

	return (
		<Layout>
			<main className={styles.container}>
				<h1 className={styles.title}>Cart</h1>
				{cart.length === 0 ? (
					<p className={styles.emptyMessage}>There are no products added to cart</p>
				) : (
					<ul className={styles.productList}>
						{cart.map((product) => (
							<li key={product.id} className={styles.productItem}>
								{product.quantity} {product.quantity < 2 ? "UNIT" : "UNITS"} - {product.name} - $
								{product.price}
								<button className={styles.button} onClick={() => removeProductFromCart(product.id)}>
									Delete product
								</button>
							</li>
						))}
					</ul>
				)}
				<Link to="/products" className={styles.link}>
					Back to products
				</Link>
			</main>
		</Layout>
	);
};

export default Cart;
