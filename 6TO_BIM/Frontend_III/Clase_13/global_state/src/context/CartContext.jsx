import { useState, createContext } from "react";

// Create a Context
const CartContext = createContext();

// Create and export the Provider. It is similar to a component that will wrap the children components that will have access to the cart state and the functions that will modify it. The children prop is a special prop that gets passed to components automatically.
export const CartProvider = ({ children }) => {
	// ***************************************************************************************************
	// ***** Here we develop the logic of the cart, the state and the functions that will modify it. *****
	// ***************************************************************************************************

	// Create the state cart and his setter through the useState hook.
	const [cart, setCart] = useState([]);

	// Create the function to add a product to the cart. Verify if the product already exist in the cart. If it does, just increase the value of quantity property.
	const addProductToCart = (product) => {
		// We check if the product is already in the cart
		const productExist = cart.find((item) => item.id === product.id);

		// If the product is already in the cart
		if (productExist) {
			// We update the quantity of the product
			setCart((prevState) =>
				prevState.map((item) => {
					if (item.id === product.id) return { ...item, quantity: item.quantity + 1 };
					else return item;
				})
			);
			// If the product is not in the cart, we add it to the cart with a quantity of 1
		} else setCart((prevState) => [...prevState, { ...product, quantity: 1 }]);
	};

	// Create the functions that will remove an item from the cart
	const removeProductFromCart = (productId) => {
		// We filter the to add only the products that are different from the one we want to remove
		setCart((prevState) => prevState.filter((product) => product.id !== productId));
	};

	return (
		// The CartContext.Provider "component" will be used to wrap the children components that will have access to the cart state and the functions that will modify it. As props we pass the value that will be available to the children components.
		<CartContext.Provider value={{ cart, addProductToCart, removeProductFromCart }}>
			{children}
		</CartContext.Provider>
	);
};

// Now, we need to use the useContext hook to access the cart state and the functions that will modify it in the children components. We will use the CartContext that we created before.
export default CartContext;
