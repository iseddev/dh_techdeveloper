import HeaderNav from "../headerNav/HeaderNav";
import Footer from "../footer/Footer";

const Layout = ({ children }) => {
	return (
		<>
			<HeaderNav />
			{children}
			<Footer />
		</>
	);
};

export default Layout;
