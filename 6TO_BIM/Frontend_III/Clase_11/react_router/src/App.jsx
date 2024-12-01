import { BrowserRouter as BrowserRouter, Route, Routes } from "react-router-dom";

import Home from "./pages/Home";
import About from "./pages/About";
import Products from "./pages/Products";
import Product from "./pages/Product";
import Dashboard from "./pages/dashboard/Dashboard";
import Profile from "./pages/dashboard/Profile";
import Stats from "./pages/dashboard/Stats";
import NotFound from "./pages/NotFound";

import "./App.css";
import ProtectedRoute from "./components/ProtectedRoute";
import Login from "./pages/Login";

function App() {
	return (
		<BrowserRouter>
			<Routes>
				{/* <Route path="/pathName" element={<ComponentName/>} /> */}
				<Route path="/" element={<Home />} />
				<Route path="/about" element={<About />} />
				<Route path="/products" element={<Products />} />
				<Route path="/login" element={<Login />} />
				<Route
					path="/dashboard"
					element={
						<ProtectedRoute isLogged={true}>
							<Dashboard />
						</ProtectedRoute>
					}>
					<Route path="profile" element={<Profile />} />
					<Route path="stats" element={<Stats />} />
				</Route>
				<Route path="/product/:id" element={<Product />} />
				{/* <Route path="*" element={<NotFound />} /> */}
				<Route path="*" element={<NotFound />} />
			</Routes>
		</BrowserRouter>
	);
}

export default App;
