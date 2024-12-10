import { Link } from "react-router-dom";

import LINKS from "../../data/MenuLinks";

import styles from "./HeaderNav.module.css";
import { useContext } from "react";
import FavoritesContext from "../../context/FavoritesContext";

const HeaderNav = () => {
	const { favorites } = useContext(FavoritesContext);
	return (
		<div className={styles.navContainer}>
			<nav className={styles.headerNav}>
				<Link to="/">
					<h2 className={styles.headerNav__title}>Frontend III</h2>
				</Link>
				<ul className={styles.headerNav__list}>
					{LINKS.map((link, index) => (
						<li className={styles.headerNav__item} key={`${index}-${link.page}`}>
							{link.page.toLowerCase() === "favorites" && favorites.length > 0 ? (
								<>
									<Link to={link.to}>{link.page}</Link>
									<span className={styles.navFavoritesCounter}>{favorites.length}</span>
								</>
							) : (
								<Link to={link.to}>{link.page}</Link>
							)}
							{/* <Link to={link.to}>{link.page}</Link> */}
						</li>
					))}
				</ul>
			</nav>
		</div>
	);
};

export default HeaderNav;
