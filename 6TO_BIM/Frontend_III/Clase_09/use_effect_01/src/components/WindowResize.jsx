import { useState, useEffect } from "react";

const WindowResize = () => {
	const [windowWidth, setWindowWidth] = useState(window.innerWidth);
	const [windowHeight, setWindowHeight] = useState(window.innerHeight);

	useEffect(() => {
		const handleResize = () => {
			setWindowWidth(window.innerWidth);
			setWindowHeight(window.innerHeight);
		};
		window.addEventListener("resize", handleResize);
	}, []);

	return (
		<>
			<h2>Window size: </h2>
			<p>
				{windowWidth}px X {windowHeight}px
			</p>
			<hr />
		</>
	);
};

export default WindowResize;
