import styles from "./Layout.module.css";

import HeaderNav from "../headerNav/HeaderNav";
import Footer from "../footer/Footer";

const Layout = ({ children }) => {
	return (
		<div className={styles.layout}>
			<HeaderNav />
			{children}
			<Footer />
		</div>
	);
};

export default Layout;
