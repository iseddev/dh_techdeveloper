import { Link } from "react-router-dom";

import styles from "./Footer.module.css";

const Footer = () => {
	return (
		<footer className={styles.footer}>
			<p className={styles.footerItem}>Proyecto Final Frontend III</p>
			<p className={styles.footerItem}>DIC-2024</p>
			<Link className={styles.footerItem} to="https://github.com/iseddev" target="_blank">
				iseddev
			</Link>
		</footer>
	);
};

export default Footer;
