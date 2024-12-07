import HeaderNav from "../headerNav/HeaderNav";

const Layout = ({ children }) => {
	return (
		<>
			<HeaderNav />
			{children}
			<p>FOOTER</p>
		</>
	);
};

export default Layout;
