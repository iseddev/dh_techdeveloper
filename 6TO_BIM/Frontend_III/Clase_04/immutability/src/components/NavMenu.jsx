const LINKS = [
	{ href: "#", text: "Home" },
	{ href: "#", text: "About" },
	{ href: "#", text: "Services" },
	{ href: "#", text: "Portfolio" },
	{ href: "#", text: "Contact" },
];

import styles from "./NavMenu.module.css";

const NavMenu = () => {
	return (
		<nav className={styles.navWrapper}>
			<ul className={styles.navList}>
				{LINKS.map((link, index) => (
					<li key={`${index}-${link.text}`} className={styles.navItem}>
						<a href={link.href} className={styles.navLink}>
							{link.text}
						</a>
					</li>
				))}
			</ul>
		</nav>
	);
};

export default NavMenu;
