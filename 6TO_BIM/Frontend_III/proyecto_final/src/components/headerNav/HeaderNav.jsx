import { Link } from "react-router-dom";

import styles from "./HeaderNav.module.css";

const HeaderNav = () => {
	return (
		<div className={styles.navContainer}>
			<nav className={styles.headerNav}>
				<Link to="/">
					<h2 className={styles.headerNav__title}>Frontend III</h2>
				</Link>
				<ul className={styles.headerNav__list}>
					<li>
						<Link to="/">Home</Link>
					</li>
					<li>
						<Link to="/characters">Characters</Link>
					</li>
					<li>
						<Link to="/favorites">Favorites</Link>
					</li>
					<li>
						<Link to="/contact">Contact</Link>
					</li>
				</ul>
			</nav>
		</div>
	);
};

export default HeaderNav;
