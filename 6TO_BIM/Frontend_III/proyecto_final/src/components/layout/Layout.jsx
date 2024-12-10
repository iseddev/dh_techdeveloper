import { Outlet } from "react-router-dom";

import HeaderNav from "../headerNav/HeaderNav";
import Footer from "../footer/Footer";

import styles from "./Layout.module.css";

const Layout = ({ children, mainTitle }) => {
	return (
		<div className={styles.layout}>
			<HeaderNav />
			<main>
				<h1>{mainTitle}</h1>
				{children}
			</main>
			<Outlet />
			<Footer />
		</div>
	);
};

export default Layout;
