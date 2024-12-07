import { BrowserRouter, Route, Routes } from "react-router-dom";

import { CartProvider } from "./context/CartContext";
import Products from "./pages/products/Products";
import Cart from "./pages/cart/Cart";

import "./App.css";
import Home from "./pages/home/Home";

function App() {
	return (
		// In this case, with the CartProvider component, we wrap the BrowserRouter component to provide states, functions and another data/logic to the children components, in this case, Products and Cart.
		<CartProvider>
			<BrowserRouter>
				<Routes>
					<Route path="/" element={<Home />} />
					<Route path="/products" element={<Products />} />
					<Route path="/cart" element={<Cart />} />
					<Route path="*" element={<h1>Not Found</h1>} />

					<Route path="/dashboard" element={<h1>Dashboard</h1>} />
				</Routes>
			</BrowserRouter>
		</CartProvider>
	);
}

export default App;
