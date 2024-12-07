import { Link } from "react-router-dom";

import styles from "./HeaderNav.module.css";

const HeaderNav = () => {
	return (
		<nav className={styles.headerNav}>
			<Link to="/">
				<h2>Final Frontend III</h2>
			</Link>
			<ul className={styles.headerNav_list}>
				<li>
					<Link to="/">Home</Link>
				</li>
				<li>
					<Link to="/characters">Characters</Link>
				</li>
				<li>
					<Link to="/contact">Contact</Link>
				</li>
			</ul>
		</nav>
	);
};

export default HeaderNav;
