import { Link } from "react-router-dom";

import LINKS from "../../data/MenuLinks";

import styles from "./HeaderNav.module.css";

const HeaderNav = () => {
	return (
		<div className={styles.navContainer}>
			<nav className={styles.headerNav}>
				<Link to="/">
					<h2 className={styles.headerNav__title}>Frontend III</h2>
				</Link>
				<ul className={styles.headerNav__list}>
					{LINKS.map((link, index) => (
						<li key={`${index}-${link.page}`}>
							<Link to={link.to}>{link.page}</Link>
						</li>
					))}
				</ul>
			</nav>
		</div>
	);
};

export default HeaderNav;
