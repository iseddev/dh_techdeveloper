import { Link } from "react-router-dom";

const Navbar = () => {
	// return <nav>{/* Aquí deberán agregar los Links */}</nav>;
	return (
		<nav>
			<h2>GameFactory</h2>
			<ul>
				<li>
					<Link to="/">Home</Link>
				</li>
				<li>
					<Link to="/games">Games</Link>
				</li>
				<li>
					<Link to="/contact">Contact</Link>
				</li>
			</ul>
		</nav>
	);
};

export default Navbar;
