import { Link } from "react-router-dom";

import styles from "./HeaderNav.module.css";

const HeaderNav = () => {
	return (
		<nav className={styles.headerNav}>
			<h2>UseContext</h2>
			<ul className={styles.headerNav_list}>
				<li>
					<Link to="/">Home</Link>
				</li>
				<li>
					<Link to="/products">Products</Link>
				</li>
				<li>
					<Link to="/cart">Cart</Link>
				</li>
			</ul>
		</nav>
	);
};

export default HeaderNav;
